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

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements ActionListener {

	@SuppressWarnings("unused")
	public VentanaPrincipal() {

		initGUI();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestor de Licoreria");
		Toolkit tk= Toolkit.getDefaultToolkit();
		setSize(1200, 600);
		//setSize((int)(tk.getScreenSize().getWidth()), (int)(tk.getScreenSize().getHeight()));
		setVisible(true);
		setResizable(true);
		repaint();
	}

	private void initGUI() {

		getContentPane().setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		GridBagConstraints config = new GridBagConstraints();

		JLabel etiqueta1 = new JLabel("Software de Manejo Licoreria La Barca UNO S.R.L");
		etiqueta1.setFont(new java.awt.Font("Arial", Font.BOLD, 34));
		config.gridx = 0;
		config.gridy = 0;
		config.gridheight = 1;
		config.gridwidth = 2;
		config.weighty = 1;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta1, config);

		final JButton botonCaja = new JButton("Caja");
		config.gridx = 0;
		config.gridy = 1;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 1;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(botonCaja, config);

		final JButton botonClientes = new JButton("Clientes");
		config.gridx = 0;
		config.gridy = 2;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 1;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(botonClientes, config);

		final JButton botonVendedores = new JButton("Empleados");
		config.gridx = 0;
		config.gridy = 3;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 1;
		config.fill = GridBagConstraints.BOTH;

		getContentPane().add(botonVendedores, config);

		final JButton botonInventario = new JButton("Inventario");
		config.gridx = 0;
		config.gridy = 4;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 1;
		config.fill = GridBagConstraints.BOTH;

		getContentPane().add(botonInventario, config);

		final JButton botonProeveedores = new JButton("Proveedores");
		config.gridx = 0;
		config.gridy = 5;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 1;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(botonProeveedores, config);

		final JButton botonSalir = new JButton("Salir");
		config.gridx = 0;
		config.gridy = 6;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 1;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(botonSalir, config);

		JLabel labelEspaciador = new JLabel();
		config.gridx = 1;
		config.gridy = 1;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weightx = 1;
		getContentPane().add(labelEspaciador, config);

		ImageIcon imagen = new ImageIcon("Assets/logo.png");
		JLabel imagenLabel = new JLabel();
		imagenLabel.setIcon(imagen);
		config.gridx = 2;
		config.gridy = 1;
		config.gridheight = 6;
		config.gridwidth = 3;
		config.weightx = 1;
		config.anchor = GridBagConstraints.WEST;
		getContentPane().add(imagenLabel, config);
		

		// Listener de botones

		class FormListener implements java.awt.event.ActionListener {
			FormListener() {
			}

			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource() == botonClientes) {
					VentanaPrincipal.this.botonClientesActionPerformed(evt);
				} else {
					if (evt.getSource() == botonVendedores) {
						VentanaPrincipal.this
								.botonVendedoresActionPerformed(evt);
					} else {
						if (evt.getSource() == botonInventario) {
							VentanaPrincipal.this
									.botonInventarioActionPerformed(evt);
						} else {
							if (evt.getSource() == botonProeveedores) {
								VentanaPrincipal.this
										.botonProeveedoresActionPerformed(evt);
							} else {
								if (evt.getSource() == botonCaja) {
									VentanaPrincipal.this
											.botonCajaActionPerformed(evt);
								} else {
									if (evt.getSource() == botonSalir) {
										VentanaPrincipal.this
												.botonSalirActionPerformed(evt);
									}
								}

							}
						}
					}
				}
			}
		}
		FormListener formListener = new FormListener();

		botonClientes.addActionListener(formListener);
		botonVendedores.addActionListener(formListener);
		botonInventario.addActionListener(formListener);
		botonProeveedores.addActionListener(formListener);
		botonCaja.addActionListener(formListener);
		botonSalir.addActionListener(formListener);
	}

	public void botonClientesActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		VentanaClientes ventanaClientes = new VentanaClientes();
		ventanaClientes.setVisible(true);
		this.dispose();
	}

	public void botonVendedoresActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		VentanaVendedores ventanaVendedores = new VentanaVendedores();
		ventanaVendedores.setVisible(true);
		this.dispose();
	}

	public void botonInventarioActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		VentanaInventario ventanaInventario = new VentanaInventario();
		ventanaInventario.setVisible(true);
		this.dispose();
	}

	@SuppressWarnings("unused")
	public void botonProeveedoresActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		VentanaProveedores ventanaProveedores = new VentanaProveedores();
		// ventanaProveedores.setVisible(true);
		this.dispose();
	}

	public void botonCajaActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		VentanaCaja ventanaCaja = new VentanaCaja();
		ventanaCaja.setVisible(true);
		this.dispose();
	}

	public void botonSalirActionPerformed(ActionEvent evt) {
		this.dispose();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		VentanaPrincipal ventana;
		ventana = new VentanaPrincipal();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
