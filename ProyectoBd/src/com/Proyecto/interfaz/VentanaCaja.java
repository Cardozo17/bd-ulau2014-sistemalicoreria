package com.Proyecto.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

import com.Proyecto.modelodao.ClienteDAO;
import com.Proyecto.modelodao.DatosEmpresaDAO;
import com.Proyecto.modelodao.ProductoDAO;
import com.Proyecto.modelovo.ClienteVO;
import com.Proyecto.modelovo.DatosEmpresaVO;
import com.Proyecto.modelovo.ProductoVO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class VentanaCaja extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public VentanaCaja() {

		initGUI();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestor de licoreria");
		Toolkit tk = Toolkit.getDefaultToolkit();

		setSize(1200, 750);
		//setSize((int) (tk.getScreenSize().getWidth()),
		//		(int) (tk.getScreenSize().getHeight()));
		setVisible(true);
		setResizable(true);

	}

	private void initGUI() {

		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		GridBagConstraints config = new GridBagConstraints();
		
		final List<ProductoVO> listaDeCompras = new ArrayList<ProductoVO>();
		DatosEmpresaVO datosEmp;
		DatosEmpresaDAO consultarDatosEmp = new DatosEmpresaDAO();
		datosEmp = consultarDatosEmp.consultarUnaEmpresa();

		JLabel etiqueta1 = new JLabel(" Caja Registradora");
		etiqueta1.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 1;
		config.gridy = 1;
		config.gridheight = 2;
		config.gridwidth = 1;
		config.weighty = 0;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(etiqueta1, config);

		JLabel etiquetaEmpresa = new JLabel(datosEmp.getNombre());
		etiqueta1.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 1;
		config.gridy = 3;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(etiquetaEmpresa, config);
		
		JLabel etiquetaDirEmp = new JLabel(datosEmp.getDiremp());
		etiqueta1.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 2;
		config.gridy = 3;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(etiquetaDirEmp, config);
		
		JLabel etiquetaRif = new JLabel(datosEmp.getRif());
		etiqueta1.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 1;
		config.gridy = 4;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(etiquetaRif, config);
		
		JLabel etiquetaTelf = new JLabel(datosEmp.getTelefono());
		etiqueta1.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 2;
		config.gridy = 4;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(etiquetaTelf, config);

		/********************** Creando La tabla **************************************/
		JTable tabla = new JTable();
		String[] columnas = { "Nombre", "Cantidad", "Precio Unitario","Precio" };

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

		// Agregando elementos a la ventana

		config.gridx = 1;
		config.gridy = 8;
		config.gridheight = 3;
		config.gridwidth = 4;
		config.weighty = 1;
		config.weightx = 1;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(desplazamiento, config);

		/*********************** Creando El Formulario *******************/

		JLabel etiqueta0 = new JLabel("Nombre Cliente");
		etiqueta0.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 6;
		config.gridy = 4;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta0, config);

		final JLabel etiquetaNombrePersona = new JLabel("");
		etiquetaNombrePersona.setFont(new java.awt.Font("Arial", Font.BOLD, 30));
		config.gridx = 6;
		config.gridy = 5;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiquetaNombrePersona, config);

		JLabel etiqueta2 = new JLabel("Cedula Cliente");
		etiqueta2.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 7;
		config.gridy = 4;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta2, config);
		
		final JFormattedTextField txtCedula = new JFormattedTextField("");
		config.gridx = 7;
		config.gridy = 5;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
        try {
            MaskFormatter formatter = new MaskFormatter("U-########");
            //formatter.setValidCharacters("VvEeJjNn");
            formatter.setPlaceholderCharacter('_');
            formatter.install(txtCedula);
        } catch (ParseException | java.text.ParseException ex) {
           // Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        getContentPane().add(txtCedula, config);	

	/*	final JTextField txtCedula = new JTextField("");
		config.gridx = 7;
		config.gridy = 5;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtCedula, config);*/

		JLabel etiqueta3 = new JLabel("Codigo ");
		etiqueta3.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 7;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta3, config);

		final JTextField txtCodigo = new JTextField("");
		config.gridx = 7;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weighty=0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtCodigo, config);

		JLabel etiqueta4 = new JLabel("Nombre Producto");
		etiqueta4.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 6;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weightx=0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta4, config);

		final JLabel etiquetaNombreProducto = new JLabel("");
		etiquetaNombreProducto.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 6;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weighty=0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(etiquetaNombreProducto, config);

		JLabel etiqueta5 = new JLabel("Cantidad");
		etiqueta5.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 7;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weightx=0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta5, config);

		final JTextField txtCantidad = new JTextField("");
		config.gridx = 7;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weighty=0;
		config.fill = GridBagConstraints.HORIZONTAL;
		txtCantidad.setDocument(new FixedSizeIntNumberDocument(txtCantidad,5));
		getContentPane().add(txtCantidad, config);

		/*********************** Creando los botones *******************/

		// boton para Buscar Cliente
		final JButton botonBuscarCliente = new JButton("Buscar Cliente");
		config.gridx = 8;
		config.gridy = 5;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonBuscarCliente, config);

		final JButton botonBuscarProd = new JButton("Buscar Producto");
		config.gridx = 8;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonBuscarProd, config);

		final JButton botonAgregarProd = new JButton("Agregar Producto");
		config.gridx = 8;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonAgregarProd, config);

		// boton para eliminar un producto
		final JButton botonEliminarProd = new JButton("Eliminar Producto");
		config.gridx = 8;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonEliminarProd, config);

		final JButton botonProcesar = new JButton("Procesar Compra");
		config.gridx = 3;
		config.gridy = 16;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonProcesar, config);

		// Boton para volver
		final JButton botonVolver = new JButton("Volver");
		config.gridx = 8;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonVolver, config);
		
		JLabel etiqueta6 = new JLabel("Bs");
		etiqueta1.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 3;
		config.gridy = 14;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weightx=0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta6, config);
		
		JLabel etiqueta7 = new JLabel("Total");
		etiqueta7.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		config.gridx = 1;
		config.gridy = 14;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weightx=0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta7, config);
		
		final JLabel etiquetaTotal = new JLabel("0.0");
		etiquetaTotal.setFont(new java.awt.Font("Arial", Font.BOLD, 34));
		config.gridx = 2;
		config.gridy = 14;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weightx=0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiquetaTotal, config);

		/*********************** logo de la aplicacion *******************/

		ImageIcon imagen = new ImageIcon("Assets/logoPeq.png");
		JLabel imagenLabel = new JLabel();
		imagenLabel.setIcon(imagen);
		config.gridx = 8;
		config.gridy = 14;
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

				String codigoProd = txtCodigo.getText();
				String codigoPersona=txtCedula.getText();
			

				Object obj = evt.getSource();
				if (obj == botonAgregarProd) {
					
					ProductoVO prodConsultado;
					prodConsultado = botonBuscarProdActionPerformed(evt,codigoProd);
					Float totalAux;
					if(txtCantidad.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Indique una cantidad de producto\n"); 
					}else{
						if(prodConsultado.getCantidadexist() >= Integer.parseInt(txtCantidad.getText()) && !estaEnLista(listaDeCompras, prodConsultado)){
					
								while (modelo.getRowCount() != 0) { 
									modelo.removeRow(0);
								}
					  
								prodConsultado.setCantidadexist(Integer.parseInt(txtCantidad.getText()));
								listaDeCompras.add(prodConsultado);
							//ReDibujando la tabla
								for (ProductoVO producto :listaDeCompras) { modelo.addRow(new Object[] { 
											producto.getNombreprod(),producto.getCantidadexist(),
											producto.getPreciounit(),(producto.getPreciounit()*producto.getCantidadexist())});
											totalAux=Float.parseFloat(etiquetaTotal.getText())+(producto.getPreciounit()*producto.getCantidadexist());
											etiquetaTotal.setText(totalAux.toString());
								}
								txtCantidad.setText("");
								txtCodigo.setText("");
						}else{
							if(prodConsultado.getCantidadexist() < Integer.parseInt(txtCantidad.getText())){
								JOptionPane.showMessageDialog(null, "No hay suficiente producto\n"); 			
							}
						}
					
					}
				} else if (obj == botonEliminarProd) {
					Float totalAux;
						for (ProductoVO productoNew :listaDeCompras) { 
							if(productoNew.getIdproduc().contentEquals(codigoProd) ){
								totalAux=Float.parseFloat(etiquetaTotal.getText()) - (productoNew.getPreciounit()*productoNew.getCantidadexist());
								etiquetaTotal.setText(totalAux.toString());
								listaDeCompras.remove(productoNew);
							}
						}
				//ReDibujando la tabla
					
						while (modelo.getRowCount() != 0) { 
							modelo.removeRow(0);
						}
				  				
						for (ProductoVO producto :listaDeCompras) { modelo.addRow(new Object[] { 
									producto.getNombreprod(),producto.getCantidadexist(),
									producto.getPreciounit(),(producto.getPreciounit()*producto.getCantidadexist())}); 
						}
				
					

				} else if (obj == botonBuscarProd) {
					
					ProductoVO prodConsultado;
					prodConsultado = botonBuscarProdActionPerformed(evt,codigoProd);
					etiquetaNombreProducto.setText(prodConsultado.getNombreprod());
				
				}else if(obj == botonBuscarCliente){
				
					if(codigoPersona.isEmpty() || !existePersona(codigoPersona) ){
						JOptionPane.showMessageDialog(null, "Debe ingresar un cliente valido\n");
					}
					else{
							ClienteVO personaConsultada;
							personaConsultada =botonBuscarClienteActionPerformed(evt, codigoPersona);
							etiquetaNombrePersona.setText(personaConsultada.getNombre()); 
					}
													
				}else if(obj == botonProcesar){
					if(existePersona(codigoPersona)){
							ProductoDAO prodActualizador = new ProductoDAO();
							ProductoVO prodAux;
						
							for (ProductoVO productoNew :listaDeCompras) { 
								prodAux = prodActualizador.consultarUnProducto(productoNew.getIdproduc());
								prodAux.setCantidadexist(prodAux.getCantidadexist() - productoNew.getCantidadexist());
								prodActualizador.actualizarProducto(prodAux);
							}
						listaDeCompras.clear();
						//limpiado Interfaz
							while (modelo.getRowCount() != 0) { 
								modelo.removeRow(0);
							}
							
							txtCantidad.setText("");
							txtCedula.setText("");
							txtCodigo.setText("");
							etiquetaTotal.setText("0.0");
							
						//Mensaje De operacion Finalizada
							JOptionPane.showMessageDialog(null, "Se ha  procesado la transaccion con exito\n"); 
					}else{
						JOptionPane.showMessageDialog(null, "Se debe introducir un cliente\n"); 
					}
				}

				else if (obj == botonVolver)
					botonVolverActionPerformed(evt);

			}

		};

		// agregando los listeners
		botonAgregarProd.addActionListener(al);
		botonEliminarProd.addActionListener(al);
		botonBuscarProd.addActionListener(al);
		botonBuscarCliente.addActionListener(al);
		botonProcesar.addActionListener(al);
		botonVolver.addActionListener(al);

	}
	
	@SuppressWarnings("serial")
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

	protected void botonEliminarProdActionPerformed(ActionEvent evt,
			ProductoVO p) {
		// TODO Auto-generated method stub

	}

	protected ProductoVO botonBuscarProdActionPerformed(ActionEvent evt,
			String codigo) {
		ProductoDAO productoBD = new ProductoDAO();
		return productoBD.consultarUnProducto(codigo);

	}


	// acciones al precionar los botones
	private ClienteVO botonBuscarClienteActionPerformed(ActionEvent evt,String codigo) {
		ClienteDAO personaBD = new ClienteDAO();
		return personaBD.consultarUnCliente(codigo);
	}


	private void botonVolverActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
		this.dispose();

	}
	
	private boolean estaEnLista(List<ProductoVO> listaDeCompras,ProductoVO producto){
		
		
		for (ProductoVO productoNew :listaDeCompras) { 
			if(productoNew.getIdproduc().contentEquals(producto.getIdproduc()) ){
				return true;
				
			}
		}
		return false;
	}
	
	private boolean existePersona(String codigo){
		ClienteDAO personaBD = new ClienteDAO();
		ClienteVO personaConsultada=personaBD.consultarUnCliente(codigo);
		
		if (personaConsultada.getCid().contains(codigo))
			return true;
		
	return false;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		VentanaCaja ventana;
		ventana = new VentanaCaja();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}