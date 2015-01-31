package com.Proyecto.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class VentanaProveedores extends JFrame implements ActionListener {

	public VentanaProveedores() {

		initGUI();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestor de licoreria");
		Toolkit tk= Toolkit.getDefaultToolkit();

		//setSize(800, 600);
		setSize((int)(tk.getScreenSize().getWidth()), (int)(tk.getScreenSize().getHeight()));
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

		/********************** Creando La tabla **************************************/
		JTable tabla = new JTable();
		String[] columnas = { "RIF", "Nombre", "Apellido", "Telefono",
				"Dirección", "Empresa", "Dia de Despacho" };

		DefaultTableModel modelo = new DefaultTableModel();
		JScrollPane desplazamiento = new JScrollPane(tabla);

		// int id, consola, obtenido,cantidad,catidadMin;
		// float precio,presentacion;
		// String nombre;

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
		config.gridy = 4;
		config.gridheight = 3;
		config.gridwidth = 7;
		config.weighty = 1;
		config.weightx = 1;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(desplazamiento, config);

		/*********************** Creando El Formulario *******************/

		JLabel etiqueta2 = new JLabel("RIF");
		config.gridx = 2;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta2, config);

		JTextField txtCedula = new JTextField("");
		config.gridx = 2;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtCedula, config);

		JLabel etiqueta3 = new JLabel("Nombre");
		config.gridx = 3;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		// config.weightx=0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta3, config);

		JTextField txtNombre = new JTextField("");
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

		JTextField txtPrecio = new JTextField("");
		config.gridx = 4;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtPrecio, config);

		// Combo Tipo de licor
		JLabel etiqueta5 = new JLabel("Telefono");
		config.gridx = 3;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta5, config);

		JTextField txtTelefono = new JTextField("");
		config.gridx = 3;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtTelefono, config);

		JLabel etiqueta6 = new JLabel("Direccion");
		config.gridx = 2;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta6, config);

		JTextField txtPresentacion = new JTextField("");
		config.gridx = 2;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtPresentacion, config);

//		JLabel etiqueta7 = new JLabel("Empresa");
//		config.gridx = 5;
//		config.gridy = 7;
//		config.gridheight = 1;
//		config.gridwidth = 1;
//		config.weightx = 0;
//		config.fill = GridBagConstraints.BOTH;
//		getContentPane().add(etiqueta7, config);
//
//		JTextField txtEmpresa = new JTextField("");
//		config.gridx = 5;
//		config.gridy = 8;
//		config.gridheight = 1;
//		config.gridwidth = 1;
//		config.weighty = 0;
//		config.fill = GridBagConstraints.HORIZONTAL;
//		getContentPane().add(txtEmpresa, config);

		JLabel etiqueta8 = new JLabel("Dia de despacho");
		config.gridx = 4;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta8, config);

		JTextField txtDia = new JTextField("");
		config.gridx = 4;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtDia, config);

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

		JButton botonActualizar = new JButton("Actualizar");
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
				Object obj = evt.getSource();
				if (obj == botonAgregar)
					botonAgregarActionPerformed(evt);
				else if (obj == botonEliminar)
					botonEliminarActionPerformed(evt);
				else if (obj == botonVolver)
					botonVolverActionPerformed(evt);
			}
		};
		botonAgregar.addActionListener(al);
		botonEliminar.addActionListener(al);
		botonVolver.addActionListener(al);

	}

	// acciones al precionar los botones
	private void botonAgregarActionPerformed(ActionEvent evt) {

	}

	private void botonEliminarActionPerformed(ActionEvent evt) {

	}

	private void botonVolverActionPerformed(ActionEvent evt) {
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