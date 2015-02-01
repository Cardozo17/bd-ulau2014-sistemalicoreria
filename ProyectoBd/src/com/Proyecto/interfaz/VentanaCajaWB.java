package com.Proyecto.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class VentanaCajaWB {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCajaWB window = new VentanaCajaWB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCajaWB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 257, 215);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("New label");
		panel.add(label);
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(305, 57, 87, 16);
		frame.getContentPane().add(toolBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(265, 105, 136, 80);
		frame.getContentPane().add(panel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(315, 26, 28, 20);
		frame.getContentPane().add(comboBox);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
