package com.Proyecto.modelodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Proyecto.conexionBD.DBConnection;
import com.Proyecto.modelovo.UsuarioVO;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UsuarioDAO {

	/**
	 * Permite agregar un usuario
	 * 
	 * @param producto
	 */

	public void registrarUsuario(UsuarioVO usuario) {
		DBConnection conex = new DBConnection();
		try {
			Statement estatuto = (Statement) conex.getConnection()
					.createStatement();
			estatuto.executeUpdate("INSERT INTO  usuario VALUES ('"
					+ usuario.getLogin() + "', '" + usuario.getClave() + "')");
			JOptionPane.showMessageDialog(null,
					"Se ha agregado el usuario exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo agregar el usuario");
		}
	}

	/**
	 * Permite eliminar un producto
	 * 
	 * @param codigo
	 */

	public void eliminarUsuario(String login) {
		DBConnection conex = new DBConnection();
		try {
			PreparedStatement consulta = (PreparedStatement) conex
					.getConnection().prepareStatement(
							"DELETE FROM usuario WHERE login = ? ");
			consulta.setString(1, login);
			consulta.execute();

			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo eliminar el usuario\n" + e);
		}

	}

	/**
	 * permite consultar un usuario asociado, el login es enviado como parametro
	 * 
	 * @param login
	 * @return
	 */
	public ArrayList<UsuarioVO> consultarUsuario(String login) {
		ArrayList<UsuarioVO> miUsuario = new ArrayList<UsuarioVO>();
		DBConnection conex = new DBConnection();

		try {
			PreparedStatement consulta = (PreparedStatement) conex
					.getConnection().prepareStatement(
							"SELECT * FROM usuario where login = ? ");
			consulta.setString(1, login);
			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				UsuarioVO usuario = new UsuarioVO();
				usuario.setLogin(res.getString("login"));
				usuario.setClave(res.getString("clave"));
				miUsuario.add(usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo consultar el usuario\n" + e);
		}
		return miUsuario;
	}

	/**
	 * permite consultar la lista de usuarios
	 * 
	 * @return
	 */
	public ArrayList<UsuarioVO> listaDeUsuarios() {
		ArrayList<UsuarioVO> miUsuario = new ArrayList<UsuarioVO>();
		DBConnection conex = new DBConnection();

		try {
			PreparedStatement consulta = (PreparedStatement) conex
					.getConnection().prepareStatement("SELECT * FROM usuario");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				UsuarioVO usuario = new UsuarioVO();
				usuario.setLogin(res.getString("login"));
				usuario.setClave(res.getString("clave"));
				miUsuario.add(usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo consultar la lista de usuarios\n" + e);
		}
		return miUsuario;
	}

	/**
	 * permite actualizar un usuario asociado a un login enviado y un login
	 * enviado como parametro
	 * 
	 * @param idviejo
	 *            producto
	 * @return
	 */
	public boolean actualizarUsuario(UsuarioVO usuario) {
		DBConnection conex = new DBConnection();

		try {
			PreparedStatement consulta = (PreparedStatement) conex
					.getConnection().prepareStatement(
							"UPDATE producto SET login= ?,clave= ?");
			consulta.setString(1, usuario.getLogin());
			consulta.setString(2, usuario.getClave());
			consulta.execute();

			consulta.close();
			conex.desconectar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo eliminar el usuario\n" + e);
			return false;
		}
		return true;
	}

}