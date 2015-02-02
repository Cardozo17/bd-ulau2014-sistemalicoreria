package com.Proyecto.modelodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Proyecto.conexionBD.DBConnection;
import com.Proyecto.modelovo.ClienteVO;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Clase que permite el acceso a la base de datos
 *
 */

public class ClienteDAO {
	
	 
	 /**
	  * Permite registrar una persona
	  * @param persona
	  */
	 public void registrarCliente(ClienteVO cliente) 
	 {
	  DBConnection conex= new DBConnection();
	  try {
	   Statement estatuto = (Statement) conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO cliente VALUES ('"+cliente.getCid()+"', '"
	     +cliente.getNombre()+"', '"+cliente.getApellido()+"', '"+cliente.getTelf()+"', '"
	     +cliente.getDireccion()+"')");
	   JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
	   estatuto.close();
	   conex.desconectar();
	    
	  } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se registro el cliente");
	           
	  }
	  
	 }
	 
	 
	 public ClienteVO consultarUnCliente(String documento) {
		  DBConnection conex= new DBConnection();
		  ClienteVO Micliente= new ClienteVO();
		  try {
		   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM cliente where cid = ? ");
		   consulta.setString(1, documento);
		   ResultSet res = consulta.executeQuery();
		    
		  if(res.next()){
		    Micliente.setCid(res.getString("cid"));
		    Micliente.setNombre(res.getString("nombre"));
		    Micliente.setApellido(res.getString("apellido"));
		    Micliente.setTelf(res.getString("telf"));
		    Micliente.setDireccion(res.getString("direccion"));
		
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		    
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
		  }
		  return Micliente;
		 }
	 
	 public boolean actualizarCliente(ClienteVO cliente) {
		  DBConnection conex= new DBConnection();
		    
		  try {
		   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("UPDATE cliente SET cid= ?,nombre= ?, apellido= ?, telf= ?, direccion= ? " + " WHERE cid = ? ");
		   consulta.setString(1,cliente.getCid());
		   consulta.setString(2, cliente.getNombre());
		   consulta.setString(3, cliente.getApellido());
		   consulta.setString(4,cliente.getTelf());
		   consulta.setString(5, cliente.getDireccion());
		   consulta.setString(6,cliente.getCid());
		   consulta.execute();
		    
		   JOptionPane.showMessageDialog(null, "Se ha  actualizado el  cliente con exito\n"); 
		   consulta.close();
		   conex.desconectar();	    
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "No se pudo actualizar el cliente\n"+e);
		   	return false;
		  }
		  return true;
		 }
	 
	 public void eliminarCliente (String codigo)
	 {
		 DBConnection conex= new DBConnection();
		 try {
			   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("DELETE FROM cliente WHERE cid = ? ");
			   consulta.setString(1, codigo);
			   consulta.execute();

			   JOptionPane.showMessageDialog(null, "Se ha eliminado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);	
			          consulta.close();
			          conex.desconectar();
			    
			  } catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente\n"+e);
			  }
		 
		 
	 }
	    
	/**
	 * permite consultar la persona asociada al documento enviado
	 * como parametro 
	 * @param documento 
	 * @return
	 */
	public ArrayList<ClienteVO> consultarCliente(String documento) {
	  ArrayList<ClienteVO> miCliente = new ArrayList<ClienteVO>();
	  DBConnection conex= new DBConnection();
	    
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM cliente where cid = ? ");
	   consulta.setString(1, documento);
	   ResultSet res = consulta.executeQuery();
	    
	  if(res.next()){
	    ClienteVO cliente= new ClienteVO();
	    cliente.setCid(res.getString("cid"));
	    cliente.setNombre(res.getString("nombre"));
	    cliente.setApellido(res.getString("apellido"));
	    cliente.setTelf(res.getString("telf"));
	    cliente.setDireccion(res.getString("direccion"));
	    miCliente.add(cliente);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
	  }
	  return miCliente;
	 }
	 
	/**
	 * permite consultar la lista de empleados
	 * @return
	 */
	public ArrayList< ClienteVO> listaDeClientes() {
	  ArrayList<ClienteVO> miCliente = new ArrayList< ClienteVO>();
	  DBConnection conex= new DBConnection();
	     
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM cliente");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    ClienteVO cliente= new ClienteVO();
	    cliente.setCid(res.getString("cid"));
	    cliente.setNombre(res.getString("nombre"));
	    cliente.setApellido(res.getString("apellido"));
	    cliente.setTelf(res.getString("telf"));
	    cliente.setDireccion(res.getString("direccion"));
	    miCliente.add(cliente);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "No se pudo consultar la lista de cliente\n"+e);
	  }
	  return miCliente;
	 }
	
	

}
