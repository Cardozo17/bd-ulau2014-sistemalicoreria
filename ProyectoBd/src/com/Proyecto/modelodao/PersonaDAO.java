package com.Proyecto.modelodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Proyecto.conexionBD.DBConnection;
import com.Proyecto.modelovo.PersonaVO;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Clase que permite el acceso a la base de datos
 *
 */

public class PersonaDAO {
	 
	 /**
	  * Permite registrar una persona
	  * @param persona
	  */
	 public void registrarPersona(PersonaVO persona) 
	 {
	  DBConnection conex= new DBConnection();
	  try {
	   Statement estatuto = (Statement) conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO persona VALUES ('"+persona.getCid()+"', '"
	     +persona.getNombre()+"', '"+persona.getApellido()+"', '"+persona.getTelefono()+"', '"
	     +persona.getDireccion()+"')");
	   JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
	   estatuto.close();
	   conex.desconectar();
	    
	  } catch (SQLException e) {
	            System.out.println(e.getMessage());
	   JOptionPane.showMessageDialog(null, "No se Registro la persona");
	  }
	 }
	 
	 public void actualizarPersona(PersonaVO persona, String idproduc) 
	 {
	  DBConnection conex= new DBConnection();
	  try {
	   PreparedStatement estatuto = (PreparedStatement) conex.getConnection().prepareStatement("UPDATE persona SET cid= ?, nombre= ?, apellido= ?, telf= ?, " +
	   		"direccion= ? WHERE cid = ?");
	   estatuto.setString(1, persona.getCid());
	   estatuto.setString(2, persona.getNombre());
	   estatuto.setString(3, persona.getApellido());
	   estatuto.setString(4, persona.getTelefono());
	   estatuto.setString(5, persona.getDireccion());
	   estatuto.setString(6, idproduc);
	   
	   estatuto.execute(); 
	  
	  
	   JOptionPane.showMessageDialog(null, "Se ha actualizado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
	   estatuto.close();
	   conex.desconectar();
	    
	  } catch (SQLException e) {
	            System.out.println(e.getMessage());
	   JOptionPane.showMessageDialog(null, "No se actualizo la persona");
	  }
	 }
	 
	 public void eliminarPersona (String documento)
	 {
		 //ArrayList<PersonaVO> miPersona = new ArrayList<PersonaVO>();
		 DBConnection conex= new DBConnection();
		 try {
			   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("DELETE FROM persona WHERE cid = ? ");
			   consulta.setString(1, documento);
			  // ResultSet res = consulta.executeQuery();
			   
			   if(consulta.execute()==false)
			   	JOptionPane.showMessageDialog(null, "No existe el registro que desea eliminar\n");
			   
			 
			  /*if(res.next()){
			    PersonaVO persona= new PersonaVO();
			    persona.setCid(res.getString("cid"));
			    persona.setNombre(res.getString("nombre"));
			    persona.setApellido(res.getString("apellido"));
			    persona.setTelefono(res.getString("telf"));
			    persona.setDireccion(res.getString("direccion"));
			    miPersona.add(persona);
			          }*/
			          //res.close();
			          consulta.close();
			          conex.desconectar();
			    
			  } catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "no se pudo eliminar la Persona\n"+e);
			  }
		 
		 
	 }
	    
	/**
	 * permite consultar la persona asociada al documento enviado
	 * como parametro 
	 * @param documento 
	 * @return
	 */
	public ArrayList<PersonaVO> consultarPersona(String documento) {
	  ArrayList<PersonaVO> miPersona = new ArrayList<PersonaVO>();
	  DBConnection conex= new DBConnection();
	    
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM persona where cid = ? ");
	   consulta.setString(1, documento);
	   ResultSet res = consulta.executeQuery();
	    
	  if(res.next()){
	    PersonaVO persona= new PersonaVO();
	    persona.setCid(res.getString("cid"));
	    persona.setNombre(res.getString("nombre"));
	    persona.setApellido(res.getString("apellido"));
	    persona.setTelefono(res.getString("telf"));
	    persona.setDireccion(res.getString("direccion"));
	    miPersona.add(persona);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
	  }
	  return miPersona;
	 }
	 
	/**
	 * permite consultar la lista de empleados
	 * @return
	 */
	public ArrayList< PersonaVO> listaDePersonas() {
	  ArrayList<PersonaVO> miEmpleado = new ArrayList< PersonaVO>();
	  DBConnection conex= new DBConnection();
	     
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM persona");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    PersonaVO persona= new PersonaVO();
	    persona.setCid(res.getString("cid"));
	    persona.setNombre(res.getString("nombre"));
	    persona.setApellido(res.getString("apellido"));
	    persona.setTelefono(res.getString("telf"));
	    persona.setDireccion(res.getString("direccion"));
	    miEmpleado.add(persona);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "No se pudo consultar la lista de personas\n"+e);
	  }
	  return miEmpleado;
	 }

}
