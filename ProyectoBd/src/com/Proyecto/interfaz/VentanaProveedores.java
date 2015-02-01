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
import javax.swing.text.MaskFormatter;

import com.Proyecto.modelodao.ProveedorDAO;
import com.Proyecto.modelovo.ProveedorVO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@SuppressWarnings("serial")
public class VentanaProveedores extends JFrame implements ActionListener {

	@SuppressWarnings("unused")
	public VentanaProveedores() {

		initGUI();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestor de Licoreria");
		Toolkit tk = Toolkit.getDefaultToolkit();

		setSize(800, 600);
		// setSize((int)(tk.getScreenSize().getWidth()),
		// (int)(tk.getScreenSize().getHeight()));
		setVisible(true);
		setResizable(true);

	}

	private void initGUI() {

		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		GridBagConstraints config = new GridBagConstraints();

		JLabel etiqueta1 = new JLabel(" Gestor de Provedores");
		etiqueta1.setFont(new java.awt.Font("Arial", Font.BOLD, 34));
		config.gridx = 1;
		config.gridy = 1;
		config.gridheight = 3;
		config.gridwidth = 1;
		config.weighty = 0;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(etiqueta1, config);
		
		final ProveedorDAO consultas = new ProveedorDAO();// bd
		ArrayList<ProveedorVO> proveedores = consultas.listaDeProveedores();

		/********************** Creando La tabla **************************************/
		JTable tabla = new JTable();
		String[] columnas = { "Codigo","RIF", "Nombre", "Telefono",
				"Dirección",  "Dia de Despacho"};

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
				for (ProveedorVO proveedor : proveedores) {
					modelo.addRow(new Object[] { proveedor.getCodproov(),
							proveedor.getRifprov(), proveedor.getNombreprov(), proveedor.getTelfprov(),
							proveedor.getDirprov(),proveedor.getDiadedespacho() });
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

		JLabel etiqueta2 = new JLabel("Codigo");
		config.gridx = 2;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta2, config);

		final JTextField txtCodigo = new JTextField("");
		config.gridx = 2;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtCodigo, config);

		JLabel etiqueta3 = new JLabel("RIF");
		config.gridx = 3;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weightx=0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta3, config);

		/*final JTextField txtRIF = new JTextField("");
		config.gridx = 3;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weighty=0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtRIF, config);*/
		
		final JFormattedTextField txtRIF = new JFormattedTextField("");
		config.gridx = 3;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
        txtRIF.setColumns(20);
        try {
            MaskFormatter formatter = new MaskFormatter("U-########-#");
            //formatter.setValidCharacters("VvEeJjNn");
            formatter.setPlaceholderCharacter('_');
            formatter.install(txtRIF);
        } catch (ParseException | java.text.ParseException ex) {
           // Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        getContentPane().add(txtRIF, config);

		JLabel etiqueta4 = new JLabel("Nombre");
		config.gridx = 4;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta4, config);

		final JTextField txtNombre = new JTextField("");
		config.gridx = 4;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtNombre, config);

		
		JLabel etiqueta5 = new JLabel("Dirección");
		config.gridx = 3;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta5, config);

		final JTextField txtDireccion = new JTextField("");
		config.gridx = 3;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtDireccion, config);

		JLabel etiqueta6 = new JLabel("Telefono");
		config.gridx = 2;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta6, config);

	/*	final JTextField txtTelefono = new JTextField("");
		config.gridx = 2;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtTelefono, config);
*/
		final JFormattedTextField txtTelefono = new JFormattedTextField("");
		config.gridx = 2;
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
		
		
		JLabel etiqueta8 = new JLabel("Dia de despacho");
		config.gridx = 4;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta8, config);

	/*	final JTextField txtDia = new JTextField("0000-00-00");
		config.gridx = 4;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtDia, config);*/
		
		final JFormattedTextField txtDia = new JFormattedTextField("");
		config.gridx = 4;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;	
		txtDia.setColumns(20);
		  try {
	            MaskFormatter formatter = new MaskFormatter("##-##-####");
	            //formatter.setValidCharacters("VvEeJjNn");
	            formatter.setPlaceholderCharacter('_');
	            formatter.install(txtDia);
	        } catch (ParseException | java.text.ParseException ex) {
	           // Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        getContentPane().add(txtDia, config);
	        
	        JLabel etiquetafecha= new JLabel("(dd/MM/yyyy)");
	        config.gridx = 5;
			config.gridy = 10;
			config.gridheight = 1;
			config.gridwidth = 1;
			config.weighty = 0;
			config.fill = GridBagConstraints.HORIZONTAL;
			getContentPane().add(etiquetafecha, config);

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
				
				//Obteniendo los datos de la Ventana
				ProveedorVO proveedor= new ProveedorVO();
				
				proveedor.setCodproov(txtCodigo.getText());
				proveedor.setRifprov(txtRIF.getText());
				proveedor.setNombreprov(txtNombre.getText());
				proveedor.setDirprov(txtDireccion.getText());
				proveedor.setTelfprov(txtTelefono.getText());
				proveedor.setDiadedespacho(txtDia.getText());
			
				
				
				Object obj = evt.getSource();
				if (obj == botonAgregar){
					botonAgregarActionPerformed(evt,proveedor);
					
					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);
					}

					
					ArrayList<ProveedorVO> proveedornew = consultas
							.listaDeProveedores();
					for (ProveedorVO proveedoraux : proveedornew) {
						modelo.addRow(new Object[] { proveedoraux.getCodproov(),
								proveedoraux.getRifprov(), proveedoraux.getNombreprov(), 
								 proveedoraux.getTelfprov(), proveedoraux.getDirprov(),
								proveedoraux.getDiadedespacho()
										});		
					}
				}
				else if (obj == botonEliminar){
					botonEliminarActionPerformed(evt,proveedor);
					
					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);
					}

					
					ArrayList<ProveedorVO> proveedornew = consultas
							.listaDeProveedores();
					for (ProveedorVO proveedoraux : proveedornew) {
						modelo.addRow(new Object[] { proveedoraux.getCodproov(),
								proveedoraux.getRifprov(), proveedoraux.getNombreprov(), 
								 proveedoraux.getTelfprov(), proveedoraux.getDirprov(),
								proveedoraux.getDiadedespacho()
										});		
					}
				}
				else if (obj==botonActualizar){
					botonActualizarActionPerformed(evt, proveedor);
					
					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);
					}

					
					ArrayList<ProveedorVO> proveedornew = consultas
							.listaDeProveedores();
					for (ProveedorVO proveedoraux : proveedornew) {
						modelo.addRow(new Object[] { proveedoraux.getCodproov(),
								proveedoraux.getRifprov(), proveedoraux.getNombreprov(), 
								 proveedoraux.getTelfprov(), proveedoraux.getDirprov(),
								proveedoraux.getDiadedespacho()
										});		
					}
				}	
				else if (obj == botonVolver)
					botonVolverActionPerformed(evt,proveedor);
			}
		};
		
		botonAgregar.addActionListener(al);
		botonEliminar.addActionListener(al);
		botonActualizar.addActionListener(al);
		botonVolver.addActionListener(al);
				

	}

	// acciones al presionar los botones
	private void botonAgregarActionPerformed(ActionEvent evt, ProveedorVO pro) {
		if (pro.getCodproov().contentEquals("")) {
			JOptionPane.showMessageDialog(null,
					"No hay datos para registrar (Codigo Obligatorio");
		} else {

			ProveedorDAO proveedorBD = new ProveedorDAO();
			proveedorBD.registrarProveedor(pro);
		}

	}

	private void botonEliminarActionPerformed(ActionEvent evt, ProveedorVO pro) {

		if (pro.getCodproov().contentEquals("")) {
			JOptionPane.showMessageDialog(null,
					"No hay datos para eliminar (Codigo Obligatorio");
		} else {

			ProveedorDAO proveedorBD = new ProveedorDAO();
			proveedorBD.eliminarProveedor(pro.getCodproov());
		}

	}

	private void botonActualizarActionPerformed(ActionEvent evt, ProveedorVO pro) {

		if (pro.getCodproov().contentEquals("")) {
			JOptionPane.showMessageDialog(null,
					"No hay datos para actualizar (Codigo Obligatorio");
		} else {

			ProveedorDAO proveedorBD = new ProveedorDAO();
			proveedorBD.actualizarProveedor(pro);
		}

	}

	private void botonVolverActionPerformed(ActionEvent evt, ProveedorVO pro) {
		// TODO Auto-generated method stub
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
		this.dispose();

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		VentanaProveedores ventana;
		ventana = new VentanaProveedores();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}