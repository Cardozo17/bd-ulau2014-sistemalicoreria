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
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.Proyecto.modelodao.ClienteDAO;
import com.Proyecto.modelovo.ClienteVO;

public class VentanaClientes extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaClientes() {

		initGUI();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestor de Licoreria");

		setSize(800, 600);
		setVisible(true);
		setResizable(false);

	}

	private void initGUI() {
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		GridBagConstraints config = new GridBagConstraints();

		JLabel etiqueta1 = new JLabel(" Gestor de Clientes");
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
		
		final ClienteDAO consultas = new ClienteDAO();// bd
		ArrayList<ClienteVO> clientes = consultas.listaDeClientes();

		/********************** Creando La tabla **************************************/
		JTable tabla = new JTable();
		String[] columnas = { "Cedula", "Nombre", "Apellido", "Telefono",
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
				for (ClienteVO cliente : clientes) {
					modelo.addRow(new Object[] { cliente.getCid(),
							cliente.getNombre(), cliente.getApellido(),
							cliente.getTelf(), cliente.getDireccion() });
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

		JLabel etiqueta2 = new JLabel("Cedula");
		config.gridx = 2;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta2, config);

		final JTextField txtCedula = new JTextField("");
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

	
		JLabel etiqueta5 = new JLabel("Telefono");
		config.gridx = 3;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta5, config);

		final JTextField txtTelefono = new JTextField("");
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

		final JTextField txtDireccion = new JTextField("");
		config.gridx = 2;
		config.gridy = 10;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtDireccion, config);

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
				ClienteVO cliente= new ClienteVO();
				
				cliente.setCid(txtCedula.getText());
				cliente.setNombre(txtNombre.getText());
				cliente.setApellido(txtApellido.getText());
				cliente.setTelf(txtTelefono.getText());
				cliente.setDireccion(txtDireccion.getText());
				
				
				Object obj = evt.getSource();
				if (obj == botonAgregar){
					botonAgregarActionPerformed(evt,cliente);
					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);
						

					}

					ArrayList<ClienteVO> clientesnew = consultas
							.listaDeClientes();
					for (ClienteVO clienteaux : clientesnew) {
						modelo.addRow(new Object[] { clienteaux.getCid(),
								clienteaux.getNombre(),
								clienteaux.getApellido(),
								clienteaux.getTelf(),
								clienteaux.getDireccion() });
					}
				}
				else if (obj == botonEliminar){
					botonEliminarActionPerformed(evt,cliente);
					

					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);
					}

					ArrayList<ClienteVO> clientesnew = consultas
							.listaDeClientes();
					for (ClienteVO clienteaux : clientesnew) {
						modelo.addRow(new Object[] { clienteaux.getCid(),
								clienteaux.getNombre(),
								clienteaux.getApellido(),
								clienteaux.getTelf(),
								clienteaux.getDireccion() });
			
					}
				}else if (obj == botonActualizar) {
					botonActualizarActionPerformed(evt, cliente);

					while (modelo.getRowCount() != 0) {
						modelo.removeRow(0);
					}

					ArrayList<ClienteVO> clientesnew = consultas
							.listaDeClientes();
					for (ClienteVO clienteaux : clientesnew) {
						modelo.addRow(new Object[] { clienteaux.getCid(),
								clienteaux.getNombre(),
								clienteaux.getApellido(),
								clienteaux.getTelf(),
								clienteaux.getDireccion() });
					}
				}	
				else if (obj == botonVolver)
					botonVolverActionPerformed(evt);
				
				txtCedula.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtTelefono.setText("");
				txtDireccion.setText("");
				
			}

		
		};
		
		
		//agregando los listeners
		botonAgregar.addActionListener(al);
		botonEliminar.addActionListener(al);
		botonActualizar.addActionListener(al);
		botonVolver.addActionListener(al);

	}

	// acciones al presionar los botones
	private void botonAgregarActionPerformed(ActionEvent evt, ClienteVO cliente) {
		ClienteDAO clienteBD = new ClienteDAO();
		clienteBD.registrarCliente(cliente);
		

	}

	private void botonEliminarActionPerformed(ActionEvent evt, ClienteVO cliente){
		ClienteDAO clienteBD = new ClienteDAO();
		clienteBD.eliminarCliente(cliente.getCid());
	}
	
	private void botonActualizarActionPerformed(ActionEvent evt,
			ClienteVO cliente) {
		// TODO Auto-generated method stub
		ClienteDAO clienteBD = new ClienteDAO();
		clienteBD.actualizarCliente(cliente);
	}


	private void botonVolverActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
		this.dispose();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		VentanaClientes ventana;
		ventana = new VentanaClientes();

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
