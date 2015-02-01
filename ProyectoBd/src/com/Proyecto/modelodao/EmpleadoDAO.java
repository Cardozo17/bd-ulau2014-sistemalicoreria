package com.Proyecto.modelodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Proyecto.conexionBD.DBConnection;
import com.Proyecto.modelovo.EmpleadoVO;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class EmpleadoDAO {
	
	/**
	  * Permite registrar un empleado
	  * @param persona
	  */
	 public void registrarEmpleado(EmpleadoVO empleado) 
	 {
	  DBConnection conex= new DBConnection();
	  try {
	   Statement estatuto = (Statement) conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO empleado (cargo, anosserv, salario, cid, nombre, apellido, telf, direccion) VALUES ('"
	     +empleado.getCargo()+"', "+empleado.getAnosserv()+", "+empleado.getSalario()+", '"
	     +empleado.getCid()+"', '"+empleado.getNombre()+"', '"+empleado.getApellido()+"', '"+empleado.getTelef()+"', '"+empleado.getDireccion()+"');");
	   JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
	   estatuto.close();
	   conex.desconectar();
	    
	  } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se registro el empleado");
	           
	  }
	  
	 }
	 
		/**
	  * Permite actualizar un empleado
	  * @param persona
	  */
	 
	 public boolean actualizarEmpleado(EmpleadoVO empleado) {
		  DBConnection conex= new DBConnection();
		    
		  try {
		   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("UPDATE empleado SET cargo= ?, anosserv= ?, salario= ?, cid= ?,  nombre= ?, apellido= ?, telf= ?, direccion= ?  " + " WHERE cid = ? ");
		   consulta.setString(1, empleado.getCargo());
		   consulta.setString(2, Integer.toString(empleado.getAnosserv()));
		   consulta.setString(3,Float.toString(empleado.getSalario()));
		   consulta.setString(4, empleado.getCid());
		   consulta.setString(5,empleado.getNombre());
		   consulta.setString(6,empleado.getApellido());
		   consulta.setString(7,empleado.getTelef());
		   consulta.setString(8,empleado.getDireccion());
		   consulta.setString(9,empleado.getCid());
		   consulta.execute();
		    
		   JOptionPane.showMessageDialog(null, "Se ha  actualizado el  empleado con exito\n"); 
		   consulta.close();
		   conex.desconectar();	    
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "No se pudo actualizar el empleado\n"+e);
		   	return false;
		  }
		  return true;
		 }
	 
	 /**
	  * Permite eliminar un empleado
	  * @param codigo
	  */
	 
	 public void eliminarEmpleado (String codigo)
	 {
		 DBConnection conex= new DBConnection();
		 try {
			   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("DELETE FROM empleado WHERE cid = ? ");
			   consulta.setString(1, codigo);
			   consulta.execute();

			   JOptionPane.showMessageDialog(null, "Se ha eliminado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);	
			          consulta.close();
			          conex.desconectar();
			    
			  } catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "No se pudo eliminar el empleado\n"+e);
			  }
		 
		 
	 }
	    
	/**
	 * permite consultar el empleado asociada al documento enviado
	 * como parametro 
	 * @param documento 
	 * @return
	 */
	public ArrayList<EmpleadoVO> consultarEmpleado(String documento) {
	  ArrayList<EmpleadoVO> miEmpleado = new ArrayList<EmpleadoVO>();
	  DBConnection conex= new DBConnection();
	    
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM empleado where cid = ? ");
	   consulta.setString(1, documento);
	   ResultSet res = consulta.executeQuery();
	    
	  if(res.next()){
	    EmpleadoVO empleado= new EmpleadoVO();
	    empleado.setCodemp(res.getString("codemp"));
	    empleado.setAnosserv(Integer.valueOf(res.getString("anosserv")));
	    empleado.setSalario(Float.valueOf(res.getString("salario")));
	    empleado.setCid(res.getString("cid"));
	    empleado.setNombre(res.getString("nombre"));
	    empleado.setApellido(res.getString("apellido"));
	    empleado.setTelef(res.getString("telf"));
	    empleado.setDireccion(res.getString("direccion"));
	    miEmpleado.add(empleado);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "No se pudo consultar el empleado\n"+e);
	  }
	  return miEmpleado;
	 }
	 
	/**
	 * permite consultar la lista de empleados
	 * @return
	 */
	public ArrayList< EmpleadoVO> listaDeEmpleados() {
	  ArrayList<EmpleadoVO> miEmpleado = new ArrayList< EmpleadoVO>();
	  DBConnection conex= new DBConnection();
	     
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM empleado");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    EmpleadoVO empleado= new EmpleadoVO();
	    empleado.setCodemp(res.getString("codemp"));
	    empleado.setCargo(res.getString("cargo"));
	    empleado.setAnosserv(Integer.valueOf(res.getString("anosserv")));
	    empleado.setSalario(Float.valueOf(res.getString("salario")));
	    empleado.setCid(res.getString("cid"));
	    empleado.setNombre(res.getString("nombre"));
	    empleado.setApellido(res.getString("apellido"));
	    empleado.setTelef(res.getString("telf"));
	    empleado.setDireccion(res.getString("direccion"));
	    miEmpleado.add(empleado);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "No se pudo consultar la lista de empleados\n"+e);
	  }
	  return miEmpleado;
	 }

}
