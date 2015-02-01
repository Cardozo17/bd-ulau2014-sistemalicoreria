package com.Proyecto.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.Proyecto.modelodao.ProductoDAO;
import com.Proyecto.modelovo.ProductoVO;

public class VentanaVentas extends JFrame implements ActionListener {

	public VentanaVentas() {

	initGUI();
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Gestor de Licoreria");

	setSize(800,600);
	setVisible(true);
	setResizable(false);

	}
	
	private void initGUI() {
		
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		
		// Declaraciones
		GridBagConstraints config = new GridBagConstraints();
		
		JLabel etiqueta1 = new JLabel("Gestor de Ventas");
		JLabel etiqueta2 = new JLabel("Id");
		JLabel etiqueta3 = new JLabel("Fecha");
		JLabel etiqueta4 = new JLabel("totalventa");
		JLabel etiqueta6 = new JLabel("Idcliente");
		JLabel imagenLabel = new JLabel();
		
		final JTextField txtId = new JTextField("");
		final JTextField txtNombre = new JTextField("");
		final JTextField txtProveedor= new JTextField("");
		final JTextField txtPrecio = new JTextField("");
		final JTextField txtCantidad = new JTextField("");
		
		final JButton botonAgregar = new JButton("Consultar");
		final JButton botonVolver = new JButton("Volver");
		
		JTable tabla=new JTable();
		   String[] columnas = {"id", "Cliente", "Fecha", "Total Venta"};//columnas de la tabla
		   final DefaultTableModel modelo = new DefaultTableModel();
		   JScrollPane desplazamiento = new JScrollPane(tabla);
	
		final ProductoDAO consultas=new ProductoDAO();//bd
			ArrayList<ProductoVO> productos =consultas.listaDeProductos();//arreglo para llenar la tabal 
		
		ImageIcon imagen = new ImageIcon("Assets/logoPeq.png"); 
		
/********************** Configurando la interfaz**************************************/	
		//agregando la etiqueta principal de titulo
		etiqueta1.setFont(new java.awt.Font("Arial",Font.BOLD, 34));
		config.gridx=1;config.gridy=1;
		config.gridheight=3;config.gridwidth=1;
		config.weighty=0;config.weightx=0;
		config.fill=GridBagConstraints.BOTH;config.anchor=GridBagConstraints.NORTHWEST;
		getContentPane().add(etiqueta1,config);
	
		/*-------------------Tabla configuracion------------*/
	        // Modelo de la tabla
	        modelo.setColumnIdentifiers(columnas);
	        // Barras de desplazamiento
	        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        
	        // Propiedades de la tabla
	        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        tabla.setFillsViewportHeight(true);        
	        tabla.setModel(modelo);
	        
	    // Agregando la tabla a la ventana
	    config.gridx=1;	config.gridy=4;
		config.gridheight=3;config.gridwidth=7;
		config.weighty=1;config.weightx=1;
		config.fill=GridBagConstraints.BOTH;config.anchor=GridBagConstraints.NORTHWEST;
		getContentPane().add(desplazamiento,config);
		
		//llenando la tabla
		for(ProductoVO producto : productos){
			 modelo.addRow( new Object[] {producto.getIdproduc(),producto.getNombreprod(),producto.getCodprov(),producto.getCantidadexist(),producto.getPreciounit()} );    
		}
		
		//Agregando a la interfase la etiqueta de ID y El campo de texto ID
		config.gridx=2;config.gridy=7;
		config.gridheight=1;config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.BOTH;
		getContentPane().add(etiqueta2,config);
				
		config.gridx=2;config.gridy=8;
		config.gridheight=1;config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtId,config);
		
		
		//Agregando a la interfase la etiqueta de Nombre y El campo de texto Nombre
		config.gridx=3;config.gridy=7;
		config.gridheight=1;config.gridwidth=1;
		//config.weightx=0;
		config.fill=GridBagConstraints.BOTH;
		getContentPane().add(etiqueta3,config);
		
		
		config.gridx=3;config.gridy=8;
		config.gridheight=1;config.gridwidth=1;
		//config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtNombre,config);
		
		//Agregando a la interfase la etiqueta de Proveedor y El campo de texto Proveedor
		config.gridx=4;config.gridy=7;
		config.gridheight=1;config.gridwidth=1;
		config.weightx=0;
		config.fill=GridBagConstraints.BOTH;
		getContentPane().add(etiqueta4,config);
		
		config.gridx=4;config.gridy=8;
		config.gridheight=1;config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtProveedor,config);
	
		//Agregando a la interfase la etiqueta de Precio y El campo de texto Precio
		config.gridx=2;config.gridy=9;
		config.gridheight=1;config.gridwidth=1;
		config.weightx=0;
		config.fill=GridBagConstraints.BOTH;
		getContentPane().add(etiqueta6,config);
		
		config.gridx=2;config.gridy=10;
		config.gridheight=1;config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtPrecio,config);

		
		//boton para agregar un producto 
		config.gridx=2;config.gridy=11;
		config.gridheight=1;config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonAgregar,config);
		
		
		// Boton para volver
		config.gridx=5;config.gridy=11;
		config.gridheight=1;config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonVolver,config);
		
		// logo de la aplicacion
		imagenLabel.setIcon(imagen);
		config.gridx=8;config.gridy=8;
		config.gridheight=4;config.gridwidth=4;
		config.weightx=0;config.weighty=0;
		config.anchor=GridBagConstraints.WEST;
		getContentPane().add(imagenLabel,config);
		

		
		/*********************** Manejando eventos *******************/
		
	      ActionListener al = new ActionListener() 
	      { 
	         public void actionPerformed(ActionEvent evt) 
	         { 
	        //agarrando los datos de la ventana
	         ProductoVO p=new ProductoVO(txtId.getText(), txtNombre.getText(),txtProveedor.getText(), txtPrecio.getText(),txtCantidad.getText());
	          
	         	Object obj = evt.getSource(); 
	            if (obj == botonAgregar){ 
	            	botonAgregarActionPerformed(evt,p);
	            			while(modelo.getRowCount()!=0){
	            				modelo.removeRow(0);
	            			}
	            				
	            				ArrayList<ProductoVO> productosnew =consultas.listaDeProductos();
	            				for(ProductoVO producto : productosnew){
	            					modelo.addRow( new Object[] {producto.getIdproduc(),producto.getNombreprod(),producto.getCodprov(),producto.getCantidadexist(),producto.getPreciounit()} );    
	            				}
	       		
	            }
	            	
	            else if (obj == botonVolver) 
	            	botonVolverActionPerformed(evt); 
	         } 


	      }; 
	      
	      //agregando los lisenteners
	      botonAgregar.addActionListener(al); 
	      botonVolver.addActionListener(al); 

	 } 
	

	
	//acciones al presionar los botones
	    private void botonAgregarActionPerformed(ActionEvent evt,ProductoVO producto) 
	   { 
		   ProductoDAO productoBD=new ProductoDAO();
		   productoBD.agregarProducto(producto);
	   } 
	   

	   private void botonVolverActionPerformed(ActionEvent evt) 
	   { 
			// TODO Auto-generated method stub
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.setVisible(true);
			this.dispose();
	   } 
		
	//Main de pruebas
	@SuppressWarnings("unused")
	public static void main(String[] args) {
			
			VentanaVentas ventana;
			ventana = new VentanaVentas();
		
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
