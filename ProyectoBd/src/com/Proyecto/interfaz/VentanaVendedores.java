package com.Proyecto.interfaz;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import org.apache.commons.lang3.math.NumberUtils;

import com.Proyecto.modelodao.EmpleadoDAO;
import com.Proyecto.modelovo.EmpleadoVO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@SuppressWarnings("serial")
public class VentanaVendedores extends JFrame implements ActionListener {

	@SuppressWarnings("unused")
	public VentanaVendedores() {

		initGUI();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestor de Licoreria");
		Toolkit tk= Toolkit.getDefaultToolkit();
		setSize(800,600);
		//setSize((int)(tk.getScreenSize().getWidth()), (int)(tk.getScreenSize().getHeight()));
		setVisible(true);
		setResizable(true);

	}

	private void initGUI() {
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		final GridBagConstraints config = new GridBagConstraints();

		JLabel etiquetagrande = new JLabel(" Gestor de Empleados");
		etiquetagrande.setFont(new java.awt.Font("Arial", Font.BOLD, 34));
		config.gridx = 1;
		config.gridy = 1;
		config.gridheight = 3;
		config.gridwidth = 1;
		config.weighty = 0;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(etiquetagrande, config);
		
		final EmpleadoDAO consultas = new EmpleadoDAO();// bd
		ArrayList<EmpleadoVO> empleados = consultas.listaDeEmpleados();

		/********************** Creando La tabla **************************************/
		JTable tabla = new JTable();
		String[] columnas = { "Codigo", "Cedula", "Nombre", "Apellido", "Cargo", "Años Servicio","Salario", "Telefono",
				"Direccion" };

		final DefaultTableModel modelo = new DefaultTableModel();
		JScrollPane desplazamiento = new JScrollPane(tabla);

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);

		// Barras de desplazamiento
		desplazamiento
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Propiedades de la tabla
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setModel(modelo);
		
		//Llenando la tabla
		for (EmpleadoVO empleado : empleados) {
			modelo.addRow(new Object[] { empleado.getCodemp(),
					empleado.getCid(), empleado.getNombre(), empleado.getApellido(),
					empleado.getCargo(), empleado.getAnosserv(),
					empleado.getSalario(),
					empleado.getTelef(), empleado.getDireccion() });
		}

		// Agregando elementos a la ventana

		config.gridx = 1;
		config.gridy = 4;
		config.gridheight = 3;
		config.gridwidth = 7;
		config.weighty = 1;
		config.weightx = 1;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(desplazamiento, config);

		/*********************** Creando El Formulario *******************/
		
	/*	JLabel etiqueta1 = new JLabel("Codigo");
		config.gridx = 1;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta1, config);
		
		final JTextField txtCodigo = new JTextField(null);
		config.gridx = 1;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtCodigo, config);*/

		JLabel etiqueta2 = new JLabel("Cedula");
		config.gridx = 2;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta2, config);

//		final JTextField txtCedula = new JTextField("");
//		config.gridx = 2;
//		config.gridy = 8;
//		config.gridheight = 1;
//		config.gridwidth = 1;
//		config.weighty = 0;
//		config.fill = GridBagConstraints.HORIZONTAL;
//		getContentPane().add(txtCedula, config);
		
		final JFormattedTextField txtCedula = new JFormattedTextField("");
		config.gridx = 2;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
        txtCedula.setColumns(20);
        try {
            MaskFormatter formatter = new MaskFormatter("U-########");
            //formatter.setValidCharacters("VvEeJjNn");
            formatter.setPlaceholderCharacter('_');
            formatter.install(txtCedula);
        } catch (ParseException | java.text.ParseException ex) {
           // Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        getContentPane().add(txtCedula, config);
		

		JLabel etiqueta3 = new JLabel("Nombre");
		config.gridx = 3;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weightx=0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta3, config);

		final JTextField txtNombre = new JTextField("");
		config.gridx = 3;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weighty=0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtNombre, config);

		JLabel etiqueta4 = new JLabel("Apellido");
		config.gridx = 4;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta4, config);

		final JTextField txtApellido = new JTextField("");
		config.gridx = 4;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtApellido, config);
		
		JLabel etiquetacargo = new JLabel("Cargo");
		config.gridx = 5;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiquetacargo, config);
		
		final JTextField txtCargo = new JTextField("");
		config.gridx = 5;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtCargo, config);
		
		JLabel etiquetaanosserv = new JLabel("Años Servicio");
		config.gridx = 2;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiquetaanosserv, config);
		
		final JTextField txtAnosServ = new JTextField("0");
		config.gridx = 2;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		txtAnosServ.setDocument(new FixedSizeIntNumberDocument(txtAnosServ,2));
		getContentPane().add(txtAnosServ, config);

		JLabel etiqueta5 = new JLabel("Telefono");
		config.gridx = 3;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta5, config);

	/*	final JTextField txtTelefono = new JTextField("");
		config.gridx = 3;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtTelefono, config);*/
		
		final JFormattedTextField txtTelefono = new JFormattedTextField("");
		config.gridx = 3;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
        txtTelefono.setColumns(20);
        try {
            MaskFormatter formatter = new MaskFormatter("0###-#######");
            //formatter.setValidCharacters("VvEeJjNn");
            formatter.setPlaceholderCharacter('_');
            formatter.install(txtTelefono);
        } catch (ParseException | java.text.ParseException ex) {
           // Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        getContentPane().add(txtTelefono, config);

		JLabel etiqueta6 = new JLabel("Direccion");
		config.gridx = 4;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta6, config);

		final JTextField txtDireccion = new JTextField("");
		config.gridx = 4;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtDireccion, config);
		
		JLabel etiquetasalario = new JLabel("Salario");
		config.gridx = 5;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiquetasalario, config);
		
		/*final JFormattedTextField txtSalario = new JFormattedTextField("");
		config.gridx = 5;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtSalario, config);*/
		
		 
		final JFormattedTextField txtSalario = new JFormattedTextField("");
		config.gridx = 5;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
        txtSalario.setColumns(20);
        try {
            MaskFormatter formatter = new MaskFormatter("*************");
            formatter.setValidCharacters("1234567890.");
            formatter.install(txtSalario);
        } catch (ParseException | java.text.ParseException ex) {
           // Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        getContentPane().add(txtSalario, config);
		

		/*********************** Creando los botones *******************/

		// boton para agregar un producto
		final JButton botonAgregar = new JButton("Agregar");
		config.gridx = 2;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonAgregar, config);

		final JButton botonActualizar = new JButton("Actualizar");
		config.gridx = 3;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonActualizar, config);

		// boton para eliminar un producto
		final JButton botonEliminar = new JButton("Eliminar");
		config.gridx = 4;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonEliminar, config);

		// Boton para volver
		final JButton botonVolver = new JButton("Volver");
		config.gridx = 5;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonVolver, config);

		/*********************** logo de la aplicacion *******************/

		ImageIcon imagen = new ImageIcon("Assets/logoPeq.png");
		JLabel imagenLabel = new JLabel();
		imagenLabel.setIcon(imagen);
		config.gridx = 8;
		config.gridy = 8;
		config.gridheight = 4;
		config.gridwidth = 4;
		config.weightx = 0;
		config.weighty = 0;
		config.anchor = GridBagConstraints.WEST;
		getContentPane().add(imagenLabel, config);

		/*********************** Manejando eventos *******************/

		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				//obteniendo los datos de la ventana
				EmpleadoVO empleado= new EmpleadoVO();
				
				//empleado.setCodemp(txtCodigo.getText());
				empleado.setCargo(txtCargo.getText());
				empleado.setAnosserv(NumberUtils.toInt(txtAnosServ.getText(),0));
				empleado.setSalario(NumberUtils.toFloat(txtSalario.getText(),0));
				empleado.setCid(txtCedula.getText());
				empleado.setNombre(txtNombre.getText());
				empleado.setApellido(txtApellido.getText());
				empleado.setTelef(txtTelefono.getText());
				empleado.setDireccion(txtDireccion.getText());
				
				
				Object obj = evt.getSource();
				if (obj == botonAgregar){
					botonAgregarActionPerformed(evt, empleado);
					
					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);	

					}

					ArrayList<EmpleadoVO> empleadosnew = consultas
							.listaDeEmpleados();
					for (EmpleadoVO empleadoaux : empleadosnew) {
						modelo.addRow(new Object[] { empleadoaux.getCodemp(),
								empleadoaux.getCid(), empleadoaux.getNombre(), empleadoaux.getApellido(),
								empleadoaux.getCargo(), empleadoaux.getAnosserv(),
								empleadoaux.getSalario(),
								empleadoaux.getTelef(), empleadoaux.getDireccion()  });
					}
					
					
				}
				else if (obj == botonEliminar){
					botonEliminarActionPerformed(evt, empleado);
					
					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);	

					}

					ArrayList<EmpleadoVO> empleadosnew = consultas
							.listaDeEmpleados();
					for (EmpleadoVO empleadoaux : empleadosnew) {
						modelo.addRow(new Object[] { empleadoaux.getCodemp(),
								empleadoaux.getCid(), empleadoaux.getNombre(), empleadoaux.getApellido(),
								empleadoaux.getCargo(), empleadoaux.getAnosserv(),
								empleadoaux.getSalario(),
								empleadoaux.getTelef(), empleadoaux.getDireccion()  });
					}
					
				}else if (obj== botonActualizar){
					botonActualizarActionPerformed(evt, empleado);
					
					
					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);	

					}

					ArrayList<EmpleadoVO> empleadosnew = consultas
							.listaDeEmpleados();
					for (EmpleadoVO empleadoaux : empleadosnew) {
						modelo.addRow(new Object[] { empleadoaux.getCodemp(),
								empleadoaux.getCid(), empleadoaux.getNombre(), empleadoaux.getApellido(),
								empleadoaux.getCargo(), empleadoaux.getAnosserv(),
								empleadoaux.getSalario(),
								empleadoaux.getTelef(), empleadoaux.getDireccion() });
						
					}
				}
				else if (obj == botonVolver)
					botonVolverActionPerformed(evt);
			}
		};
		
		
		botonAgregar.addActionListener(al);
		botonEliminar.addActionListener(al);
		botonActualizar.addActionListener(al);
		botonVolver.addActionListener(al);

	}

	// acciones al presionar los botones
	private void botonAgregarActionPerformed(ActionEvent evt, EmpleadoVO empleado) {
		
		if(empleado.getCid().contentEquals("")||empleado.getCid().contentEquals("_-________"))
		{	
			JOptionPane.showMessageDialog(null,"No hay datos para registrar (Cedula Obligatoria)");
		}
		else{
			
			EmpleadoDAO empleadoBD = new EmpleadoDAO();
			empleadoBD.registrarEmpleado(empleado);
		}

	

	}

	private void botonEliminarActionPerformed(ActionEvent evt,EmpleadoVO empleado) {
		
		if(empleado.getCid().contentEquals("")||empleado.getCid().contentEquals("_-________"))
		{	
			JOptionPane.showMessageDialog(null,"No hay datos para eliminar (Cedula Obligatoria)");
		}
		else{
			
			EmpleadoDAO empleadoBD = new EmpleadoDAO();
			empleadoBD.eliminarEmpleado(empleado.getCid());
		}
		
		

	}
	
	private void botonActualizarActionPerformed(ActionEvent evt, EmpleadoVO empleado) {
		
		if(empleado.getCid().contentEquals("")||empleado.getCid().contentEquals("_-________"))
		{	
			JOptionPane.showMessageDialog(null,"No hay datos para actualizar (Cedula Obligatoria)");
		}
		else{
			
			EmpleadoDAO empleadoBD = new EmpleadoDAO();
			empleadoBD.actualizarEmpleado(empleado);
		}
		
		
		


	}

	private void botonVolverActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
		this.dispose();

	}
	
	
	
	private class FixedSizeIntNumberDocument extends PlainDocument
	{
	    private JTextComponent owner;
	    private int fixedSize;

	    public FixedSizeIntNumberDocument(JTextComponent owner, int fixedSize)
	    {
	        this.owner = owner;
	        this.fixedSize = fixedSize;
	    }

	    @Override
	    public void insertString(int offs, String str, AttributeSet a)
	            throws BadLocationException
	    {
	        if (getLength() + str.length() > fixedSize) {
	            str = str.substring(0, fixedSize - getLength());
	            this.owner.getToolkit().beep();
	        }

	        try {
	            Integer.parseInt(str);
	        } catch (NumberFormatException e) {
	            // inserted text is not a number
	            this.owner.getToolkit().beep();
	            return;
	        }

	        super.insertString(offs, str, a);
	    }               
	}
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		VentanaVendedores ventana;
		ventana = new VentanaVendedores();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
