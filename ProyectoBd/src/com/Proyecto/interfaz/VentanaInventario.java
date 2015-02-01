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

import com.Proyecto.modelodao.ProductoDAO;
import com.Proyecto.modelodao.ProveedorDAO;
import com.Proyecto.modelovo.ProductoVO;
import com.Proyecto.modelovo.ProveedorVO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@SuppressWarnings("serial")
public class VentanaInventario extends JFrame implements ActionListener {

	@SuppressWarnings("unused")
	public VentanaInventario() {

		initGUI();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestor de Licoreria");
		Toolkit tk= Toolkit.getDefaultToolkit();

		setSize(800, 600);
		//setSize((int)(tk.getScreenSize().getWidth()), (int)(tk.getScreenSize().getHeight()));
		setVisible(true);
		setResizable(true);

	}

	private void initGUI() {

		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);

		// Declaraciones
		GridBagConstraints config = new GridBagConstraints();

		JLabel etiqueta1 = new JLabel(" Gestor de Inventario");
		JLabel etiqueta2 = new JLabel("Id");
		JLabel etiqueta3 = new JLabel("Nombre");
		JLabel etiqueta4 = new JLabel("Proveedor");
		JLabel etiqueta6 = new JLabel("Precio Unitario");
		JLabel etiqueta7 = new JLabel("Cantidad");
		JLabel imagenLabel = new JLabel();
		JLabel etiquetaexp = new JLabel("Sí desea actualizar ingrese todos los datos, ");
		JLabel etiquetaexp2= new JLabel("Sí desea eliminar ingrese el Id y luego presione eliminar");
		JLabel etiquetaexp3 = new JLabel("Antes de Agregar un Producto Debe Registrar el Proveedor");

		final JTextField txtId = new JTextField("");
		final JTextField txtNombre = new JTextField("");
		final JTextField txtProveedor = new JTextField("");
		final JFormattedTextField txtPrecio = new JFormattedTextField("");
		final JTextField txtCantidad = new JTextField("");
		//final JFormattedTextField txtCantidad = new JFormattedTextField("");

		final JButton botonAgregar = new JButton("Agregar");
		final JButton botonActualizar = new JButton("Actualizar");
		final JButton botonEliminar = new JButton("Eliminar");
		final JButton botonLimpiar = new JButton ("Limpiar");
		final JButton botonVolver = new JButton("Volver");

		JTable tabla = new JTable();
		String[] columnas = { "Id", "Nombre", "Proveedor", "Cantidad",
				"Precio Unitario" };// columnas de la tabla
		final DefaultTableModel modelo = new DefaultTableModel();
		JScrollPane desplazamiento = new JScrollPane(tabla);

		final ProductoDAO consultas = new ProductoDAO();// bd
		ArrayList<ProductoVO> productos = consultas.listaDeProductos();// arreglo
																		// para
																		// llenar
																		// la
																		// tabla
		final ProveedorDAO consultas2 = new ProveedorDAO();
		final ArrayList<ProveedorVO> proveedores = consultas2.listaDeProveedores();
		
		

		ImageIcon imagen = new ImageIcon("Assets/logoPeq.png");

		/********************** Configurando la interfaz **************************************/
		// agregando la etiqueta principal de titulo
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

		/*-------------------Tabla configuracion------------*/
		
		
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

		// Agregando la tabla a la ventana
		config.gridx = 1;
		config.gridy = 4;
		config.gridheight = 3;
		config.gridwidth = 7;
		config.weighty = 1;
		config.weightx = 1;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(desplazamiento, config);

		// llenando la tabla
		for (ProductoVO producto : productos) {
			modelo.addRow(new Object[] { producto.getIdproduc(),
					producto.getNombreprod(), producto.getCodprov(),
					producto.getCantidadexist(), producto.getPreciounit() });
		}

		// Agregando a la interfaz la etiqueta de ID y el campo de texto ID
		config.gridx = 2;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta2, config);

		config.gridx = 2;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtId, config);

		// Agregando a la interfase la etiqueta de Nombre y El campo de texto
		// Nombre
		config.gridx = 3;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weightx=0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta3, config);

		config.gridx = 3;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weighty=0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtNombre, config);

		// Agregando a la interfaz la etiqueta de Proveedor y el campo de texto
		// Proveedor
		config.gridx = 4;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta4, config);

		config.gridx = 4;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtProveedor, config);

		// Agregando a la interfaz la etiqueta de Precio y El campo de texto
		// Precio
		config.gridx = 2;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta6, config);

/*		config.gridx = 2;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtPrecio, config);*/
		
		
		config.gridx = 2;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
        txtPrecio.setColumns(20);
        try {
            MaskFormatter formatter = new MaskFormatter("*************");
            formatter.setValidCharacters("1234567890.");
            formatter.install(txtPrecio);
        } catch (ParseException | java.text.ParseException ex) {
           // Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        getContentPane().add(txtPrecio, config);

		// Agregando a la interfaz la etiqueta de Cantidad y El campo de texto
		// Cantidad
		config.gridx = 3;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta7, config);
        
       /* config.gridx = 3;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
        txtCantidad.setColumns(20);
        try {
            MaskFormatter formatter = new MaskFormatter("##");
            //formatter.setValidCharacters("1234567890.");
            formatter.install(txtCantidad);
        } catch (ParseException | java.text.ParseException ex) {
           // Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        getContentPane().add(txtCantidad, config);*/

		config.gridx = 3;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		txtCantidad.setDocument(new FixedSizeIntNumberDocument(txtCantidad,5));
		getContentPane().add(txtCantidad, config);
		
		config.gridx = 1;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(etiquetaexp, config);
		
		config.gridx = 1;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(etiquetaexp2, config);
		
		config.gridx = 1;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(etiquetaexp3, config);

		// Boton para agregar un producto
		config.gridx = 2;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonAgregar, config);

		// Boton para actualizar un producto
		config.gridx = 3;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonActualizar, config);

		// Boton para eliminar un producto
		config.gridx = 4;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonEliminar, config);
		
		//Boton para limpiar
		config.gridx = 1;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonLimpiar, config);

		// Boton para volver
		config.gridx = 5;
		config.gridy = 11;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonVolver, config);

		// logo de la aplicacion
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
				

				// obteniendo los datos de la ventana
			
					ProductoVO p = new ProductoVO(txtId.getText(),
					txtNombre.getText(), txtProveedor.getText(),
					 NumberUtils.toInt(txtCantidad.getText(),0),
					 NumberUtils.toFloat(txtPrecio.getText(),0));
					
								
				Object obj = evt.getSource();
				if (obj == botonAgregar) {
					
					// validador
					boolean validador=false;
					
					for(ProveedorVO  proveedoraux: proveedores)
					{	
						if (p.getCodprov().contentEquals(proveedoraux.getCodproov()))
						{	
							botonAgregarActionPerformed(evt, p);
							validador=true;
						}		
					}
					if (validador==false)
						JOptionPane.showMessageDialog(null,"El proveedor no existe o Esta Dejando Campos Vacios");	
					
					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);
				

					}

					ArrayList<ProductoVO> productosnew = consultas
							.listaDeProductos();
					for (ProductoVO producto : productosnew) {
						modelo.addRow(new Object[] { producto.getIdproduc(),
								producto.getNombreprod(),
								producto.getCodprov(),
								producto.getCantidadexist(),
								producto.getPreciounit() });
					}

				} else if (obj == botonEliminar) {
					botonEliminarActionPerformed(evt, p);

					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);
					}

					ArrayList<ProductoVO> productosnew = consultas
							.listaDeProductos();
					for (ProductoVO producto : productosnew) {
						modelo.addRow(new Object[] { producto.getIdproduc(),
								producto.getNombreprod(),
								producto.getCodprov(),
								producto.getCantidadexist(),
								producto.getPreciounit() });
					}

				} else if (obj == botonActualizar) {
					
					// validador
					boolean validador=false;
					
					for(ProveedorVO  proveedoraux: proveedores)
					{	
						if (p.getCodprov().contentEquals(proveedoraux.getCodproov())){
							
							botonActualizarActionPerformed(evt, p);
							validador=true;
						}
						
					}
					if (validador==false)
						JOptionPane.showMessageDialog(null,"El proveedor no existe ó Esta Dejando Campos Vacios");

					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);
					}

					ArrayList<ProductoVO> productosnew = consultas
							.listaDeProductos();
					for (ProductoVO producto : productosnew) {
						modelo.addRow(new Object[] { producto.getIdproduc(),
								producto.getNombreprod(),
								producto.getCodprov(),
								producto.getCantidadexist(),
								producto.getPreciounit() });
					}
				}
				else if(obj==botonLimpiar){
					
					txtId.setText("");
					txtNombre.setText("");
					txtProveedor.setText("");
					//txtPrecio.setText("");
					//txtCantidad.setText("");
				}
				else if (obj == botonVolver)
					botonVolverActionPerformed(evt);
				
				
			}
			

		};

		// agregando los listeners
		botonAgregar.addActionListener(al);
		botonEliminar.addActionListener(al);
		botonActualizar.addActionListener(al);
		botonLimpiar.addActionListener(al);
		botonVolver.addActionListener(al);
		

		

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
	

	// acciones al presionar los botones
	private void botonAgregarActionPerformed(ActionEvent evt,
			ProductoVO producto) {
		if(producto.getIdproduc().contentEquals(""))
		{	
			JOptionPane.showMessageDialog(null,"No hay datos para registrar (Codigo Obligatorio)");
		}
		else{
			
			ProductoDAO productoBD = new ProductoDAO();
			productoBD.agregarProducto(producto);
			
		}
		
	}

	private void botonActualizarActionPerformed(ActionEvent evt,
			ProductoVO producto) {
		// TODO Auto-generated method stub
		if(producto.getIdproduc().contentEquals(""))
		{	
			JOptionPane.showMessageDialog(null,"No hay datos para actualizar (Codigo Obligatorio)");
		}
		else{
			
			ProductoDAO productoBD = new ProductoDAO();
			productoBD.actualizarProducto(producto);
		}
		

	}
	

	private void botonEliminarActionPerformed(ActionEvent evt,
			ProductoVO producto) {
		
		if(producto.getIdproduc().contentEquals(""))
		{	
			JOptionPane.showMessageDialog(null,"No hay datos para eliminar (Codigo Obligatorio)");
		}
		else{
			
			ProductoDAO productoBD = new ProductoDAO();
			productoBD.eliminarProducto(producto.getIdproduc());
		}
		
		
	}
	


	private void botonVolverActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
		this.dispose();
	}
	

	// Main de pruebas
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		VentanaInventario ventana;
		ventana = new VentanaInventario();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
