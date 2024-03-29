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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.Proyecto.modelodao.UsuarioDAO;
import com.Proyecto.modelovo.UsuarioVO;

@SuppressWarnings("serial")
public class VentanaLogin extends JFrame implements ActionListener {

	public VentanaLogin() {

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

		JLabel etiqueta1 = new JLabel("Gestor de Licoreria");
		etiqueta1.setFont(new java.awt.Font("Arial", Font.BOLD, 34));
		config.gridx = 0;
		config.gridy = 0;
		config.gridheight = 3;
		config.gridwidth = 1;
		config.weighty = 1;
		config.weightx = 1;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(etiqueta1, config);

		JLabel etiqueta2 = new JLabel("Ingreso de usuario ");
		etiqueta2.setFont(new java.awt.Font("Arial", Font.BOLD, 22));
		config.gridx = 1;
		config.gridy = 1;
		config.gridheight = 2;
		config.gridwidth = 2;
		config.weighty = 0.05;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta2, config);

		JLabel etiqueta3 = new JLabel("Usuario");
		etiqueta3.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
		config.gridx = 1;
		config.gridy = 4;
		config.gridheight = 1;
		config.gridwidth = 2;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		getContentPane().add(etiqueta3, config);

		final JTextField txtUsuario = new JTextField("");
		config.gridx = 1;
		config.gridy = 5;
		config.gridheight = 1;
		config.gridwidth = 2;
		// config.weighty=0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtUsuario, config);

		JLabel etiqueta4 = new JLabel("Contraseña");
		etiqueta4.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
		config.gridx = 1;
		config.gridy = 6;
		config.gridheight = 1;
		config.gridwidth = 2;
		config.weightx = 0;

		getContentPane().add(etiqueta4, config);

		final JPasswordField txtContrasena = new JPasswordField("");
		config.gridx = 1;
		config.gridy = 7;
		config.gridheight = 1;
		config.gridwidth = 2;
		// config.weighty=0;
		config.weightx = 0;
		config.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(txtContrasena, config);

		final JButton botonAceptar = new JButton("Aceptar");
		config.gridx = 1;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		//botonAceptar.getActionForKeyStroke(KeyStroke.getKeyStroke("ENTER"));

		getContentPane().add(botonAceptar, config);

		final JButton botonSalir = new JButton("Salir");
		config.gridx = 2;
		config.gridy = 8;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 0;
		getContentPane().add(botonSalir, config);

		JLabel LabelEspaciadorIzq = new JLabel();
		config.gridx = 1;
		config.gridy = 9;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 1;
		getContentPane().add(LabelEspaciadorIzq, config);

		JLabel LabelEspaciadorDer = new JLabel();
		config.gridx = 3;
		config.gridy = 0;
		config.gridheight = 1;
		config.gridwidth = 1;
		config.weighty = 1;
		getContentPane().add(LabelEspaciadorDer, config);

		ImageIcon imagen = new ImageIcon("Assets/logoMed.png");
		JLabel imagenLabel = new JLabel();
		imagenLabel.setIcon(imagen);
		config.gridx = 5;
		config.gridy = 6;
		config.gridheight = 4;
		config.gridwidth = 4;
		config.weighty = 0;
		config.weightx = 0;
		config.fill = GridBagConstraints.BOTH;
		config.anchor = GridBagConstraints.WEST;
		getContentPane().add(imagenLabel, config);

		class FormListener implements java.awt.event.ActionListener {
			FormListener() {
			}	
	

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource() == botonAceptar) {
					
					UsuarioVO usuario = new UsuarioVO();
					usuario.setLogin(txtUsuario.getText());
					usuario.setClave(txtContrasena.getText());
					
					String login = usuario.getLogin();
					String clave= usuario.getClave();
					
					System.out.println(usuario.getLogin());
					System.out.println(usuario.getClave());
					
					
					boolean validacion= false;
					UsuarioDAO usuariosbd= new UsuarioDAO();
					ArrayList<UsuarioVO> listadeusuarios = usuariosbd.listaDeUsuarios();
					
					
					for (UsuarioVO usuarioaux : listadeusuarios) {
						
							
						System.out.println(usuarioaux.getLogin());
						System.out.println(usuarioaux.getClave());
						
						
						String loginaux= usuarioaux.getLogin();
						String claveaux= usuarioaux.getClave();
								
								if((clave.contentEquals(claveaux) && (login.contentEquals(loginaux))))
								{
									validacion= true;
									VentanaLogin.this.botonAceptarActionPerformed(evt);
									break;
								}
					}
							if (validacion != true)
								JOptionPane.showMessageDialog(null, "Error de Usuario O Clave","Información",JOptionPane.INFORMATION_MESSAGE);		
						
				}
				else if(evt.getSource()== botonSalir){
					
					VentanaLogin.this.botonSalirActionPerformed(evt);
					
				}
			}
		}

		FormListener formListener = new FormListener();
		botonAceptar.addActionListener(formListener);
		botonSalir.addActionListener(formListener);
	
		
	}
	
	
	public void botonAceptarActionPerformed(ActionEvent evt){
		// TODO Auto-generated method stub
		
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
		this.dispose();
		
	}
	
	public void botonSalirActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		VentanaLogin ventana;
		ventana = new VentanaLogin();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
