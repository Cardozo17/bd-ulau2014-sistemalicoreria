package com.Proyecto.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class VentanaCaja  extends JFrame implements ActionListener {

	public VentanaCaja() {

	initGUI();
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Gestor de licoreria");

	setSize(800,600);
	setVisible(true);
	setResizable(false);

	}
	
	private void initGUI() {

		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		GridBagConstraints config = new GridBagConstraints();
		
		JLabel etiqueta1 = new JLabel(" Caja Registradora");
		etiqueta1.setFont(new java.awt.Font("Arial",Font.BOLD, 34));
		config.gridx=1;
		config.gridy=1;
		config.gridheight=3;
		config.gridwidth=1;
		config.weighty=0;
		config.weightx=0;
		config.fill=GridBagConstraints.BOTH;
		config.anchor=GridBagConstraints.NORTHWEST;
		getContentPane().add(etiqueta1,config);
	
		/********************** Creando La tabla**************************************/
		JTable tabla=new JTable();
		   String[] columnas = {"Nombre", "Cantidad","Precio"};
		      
		   DefaultTableModel modelo = new DefaultTableModel();
		   JScrollPane desplazamiento = new JScrollPane(tabla);
		   
	        //int id, consola, obtenido,cantidad,catidadMin;
	        //float precio,presentacion;
	        //String nombre;
	        
	        // Modelo de la tabla
	        modelo.setColumnIdentifiers(columnas);
	        
	        // Barras de desplazamiento
	        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        
	        // Propiedades de la tabla
	        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        tabla.setFillsViewportHeight(true);        
	        tabla.setModel(modelo);
	        
	     // Agregando elementos a la ventana
	        
	    config.gridx=1;
		config.gridy=8;
		config.gridheight=3;
		config.gridwidth=4;
		config.weighty=1;
		config.weightx=1;
		config.fill=GridBagConstraints.BOTH;
		config.anchor=GridBagConstraints.NORTHWEST;
		getContentPane().add(desplazamiento,config);
		
		
		/*********************** Creando El Formulario*******************/
		
		JLabel etiqueta2 = new JLabel("Cedula Cliente");
		config.gridx=7;
		config.gridy=4;
		config.gridheight=1;
		config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.BOTH;
		getContentPane().add(etiqueta2,config);
		
		JTextField txtCedula = new JTextField("");
		config.gridx=7;
		config.gridy=5;
		config.gridheight=1;
		config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtCedula,config);
		
		
		JLabel etiqueta3 = new JLabel("Codigo ");
		config.gridx=6;
		config.gridy=7;
		config.gridheight=1;
		config.gridwidth=1;
		config.weightx=0;
		config.fill=GridBagConstraints.BOTH;
		getContentPane().add(etiqueta3,config);
		
		JTextField txtNombre = new JTextField("");
		config.gridx=6;
		config.gridy=8;
		config.gridheight=1;
		config.gridwidth=1;
		//config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtNombre,config);
		
		JLabel etiqueta4 = new JLabel("Nombre Producto");
		config.gridx=7;
		config.gridy=7;
		config.gridheight=1;
		config.gridwidth=1;
		//config.weightx=0;
		config.fill=GridBagConstraints.BOTH;
		getContentPane().add(etiqueta4,config);
		
		JTextField txtNombreProd = new JTextField("");
		config.gridx=7;
		config.gridy=8;
		config.gridheight=1;
		config.gridwidth=1;
		//config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtNombreProd,config);
		
		JLabel etiqueta5 = new JLabel("Cantidad");
		config.gridx=7;
		config.gridy=9;
		config.gridheight=1;
		config.gridwidth=1;
		//config.weightx=0;
		config.fill=GridBagConstraints.BOTH;
		getContentPane().add(etiqueta5,config);
		
		JTextField txtCantidad = new JTextField("");
		config.gridx=7;
		config.gridy=10;
		config.gridheight=1;
		config.gridwidth=1;
		//config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtCantidad,config);
		
		
		/*********************** Creando los botones*******************/
		
		//boton para Buscar Cliente
		JButton botonBuscarCliente = new JButton("Buscar Cliente");
		config.gridx=8;
		config.gridy=5;
		config.gridheight=1;
		config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonBuscarCliente,config);
		
		JButton botonBuscarProd = new JButton("Buscar Producto");
		config.gridx=8;
		config.gridy=9;
		config.gridheight=1;
		config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonBuscarProd,config);
		
		JButton botonAgregarProd = new JButton("Agregar Producto");
		config.gridx=8;
		config.gridy=8;
		config.gridheight=1;
		config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonAgregarProd,config);
		
		//boton para eliminar un producto
		JButton botonEliminarProd = new JButton("Eliminar Producto");
		config.gridx=8;
		config.gridy=10;
		config.gridheight=1;
		config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonEliminarProd,config);
		
		
		JButton botonImprimir = new JButton("Imprimir Factura");
		config.gridx=4;
		config.gridy=14;
		config.gridheight=1;
		config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonImprimir,config);
		
		// Boton para volver
		JButton botonVolver = new JButton("Volver");
		config.gridx=5;
		config.gridy=14;
		config.gridheight=1;
		config.gridwidth=1;
		config.weighty=0;
		config.fill=GridBagConstraints.HORIZONTAL;
		getContentPane().add(botonVolver,config);
		
		
		/*********************** logo de la aplicacion*******************/

		ImageIcon imagen = new ImageIcon("Assets/logoPeq.png"); 
		JLabel imagenLabel = new JLabel();
		imagenLabel.setIcon(imagen);
		config.gridx=8;
		config.gridy=14;
		config.gridheight=4;
		config.gridwidth=4;
		config.weightx=0;
		config.weighty=0;
		config.anchor=GridBagConstraints.WEST;
		getContentPane().add(imagenLabel,config);
		
		/*********************** Manejando eventos *******************/

	      ActionListener al = new ActionListener() 
	      { 
	         public void actionPerformed(ActionEvent evt) 
	         { 
	            Object obj = evt.getSource(); 
	            if (obj == botonBuscarCliente) 
	            	botonBuscarClienteActionPerformed(evt); 
	            else if (obj == botonEliminarProd) 
	            	botonEliminarProdActionPerformed(evt); 
	            else if (obj == botonVolver) 
	            	botonVolverActionPerformed(evt); 
	         } 
	      }; 
	      botonBuscarCliente.addActionListener(al); 
	      botonEliminarProd.addActionListener(al); 
	      botonVolver.addActionListener(al); 

        
}
	
	
	//acciones al precionar los botones
	   private void botonBuscarClienteActionPerformed(ActionEvent evt) 
	   { 

	   } 

	   private void botonEliminarProdActionPerformed(ActionEvent evt) 
	   { 

	   } 

	   private void botonVolverActionPerformed(ActionEvent evt) 
	   { 
			// TODO Auto-generated method stub
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.setVisible(true);
			this.dispose();

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