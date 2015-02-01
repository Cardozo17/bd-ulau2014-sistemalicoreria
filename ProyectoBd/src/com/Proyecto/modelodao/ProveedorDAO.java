package com.Proyecto.modelodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Proyecto.conexionBD.DBConnection;
import com.Proyecto.modelovo.ProveedorVO;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ProveedorDAO {
	
	/**
	  * Permite registrar un proveedor
	  * @param proveedor
	  */
	 public void registrarProveedor(ProveedorVO proveedor) 
	 {
	  DBConnection conex= new DBConnection();
	  try {
	   Statement estatuto = (Statement) conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO proveedor VALUES ('"+proveedor.getCodproov()+"', '"
	     +proveedor.getRifprov()+"', '"+proveedor.getNombreprov()+"', '"+proveedor.getDirprov()+"', '"
	     +proveedor.getTelfprov()+"', '"+proveedor.getDiadedespacho()+"');");
	   JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
	   estatuto.close();
	   conex.desconectar();
	    
	  } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se registro el proveedor");
	           
	  }
	  
	 }
	 
		/**
	  * Permite actualizar un proveedor
	  * @param proveedor
	  */
	 
	 public boolean actualizarProveedor(ProveedorVO proveedor) {
		  DBConnection conex= new DBConnection();
		    
		  try {
		   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("UPDATE proveedor SET codproov= ?, rifprov= ?, nombreprov= ?, dirprov= ?, telfprov= ?,  diadedespacho= ?  " + " WHERE codproov = ? ");
		   consulta.setString(1,proveedor.getCodproov());
		   consulta.setString(2, proveedor.getRifprov());
		   consulta.setString(3, proveedor.getNombreprov());
		   consulta.setString(4, proveedor.getDirprov());
		   consulta.setString(5,proveedor.getTelfprov());
		   consulta.setString(6,proveedor.getDiadedespacho());
		   consulta.setString(7,proveedor.getCodproov());
		   
		   consulta.execute();
		    
		   JOptionPane.showMessageDialog(null, "Se ha  actualizado el proveedor con exito\n"); 
		   consulta.close();
		   conex.desconectar();	    
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "No se pudo actualizar el proveedor\n"+e);
		   	return false;
		  }
		  return true;
		 }
	 
	 /**
	  * Permite eliminar un empleado
	  * @param codigo
	  */
	 
	 public void eliminarProveedor (String codigo)
	 {
		 DBConnection conex= new DBConnection();
		 try {
			   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("DELETE FROM proveedor WHERE codproov = ? ");
			   consulta.setString(1, codigo);
			   consulta.execute();

			   JOptionPane.showMessageDialog(null, "Se ha eliminado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);	
			          consulta.close();
			          conex.desconectar();
			    
			  } catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "No se pudo eliminar el proveedor\n"+e);
			  }
		 
		 
	 }
	    
	/**
	 * permite consultar el proveedor asociada al codigo enviado
	 * como parametro 
	 * @param documento 
	 * @return
	 */
	public ArrayList<ProveedorVO> consultarProveedor(String documento) {
	  ArrayList<ProveedorVO> miProveedor = new ArrayList<ProveedorVO>();
	  DBConnection conex= new DBConnection();
	    
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM proveedor where codproov = ? ");
	   consulta.setString(1, documento);
	   ResultSet res = consulta.executeQuery();
	    
	  if(res.next()){
	    ProveedorVO proveedor= new ProveedorVO();
	    proveedor.setCodproov(res.getString("codproov"));
	    proveedor.setRifprov(res.getString("rifprov"));
	    proveedor.setNombreprov(res.getString("nombreprov"));
	    proveedor.setDirprov(res.getString("dirprov"));
	    proveedor.setTelfprov(res.getString("telfprov"));
	    proveedor.setDiadedespacho(res.getString("diadedespacho"));
	    miProveedor.add(proveedor);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "No se pudo consultar el proveedor\n"+e);
	  }
	  return miProveedor;
	 }
	 
	/**
	 * permite consultar la lista de proveedores
	 * @return
	 */
	public ArrayList< ProveedorVO> listaDeProveedores() {
	  ArrayList<ProveedorVO> miProveedor = new ArrayList< ProveedorVO>();
	  DBConnection conex= new DBConnection();
	     
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM proveedor");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
		   ProveedorVO proveedor= new ProveedorVO();
		    proveedor.setCodproov(res.getString("codproov"));
		    proveedor.setRifprov(res.getString("rifprov"));
		    proveedor.setNombreprov(res.getString("nombreprov"));
		    proveedor.setDirprov(res.getString("dirprov"));
		    proveedor.setTelfprov(res.getString("telfprov"));
		    proveedor.setDiadedespacho(res.getString("diadedespacho"));
		    miProveedor.add(proveedor);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "No se pudo consultar la lista de proveedores\n"+e);
	  }
	  return miProveedor;
	 }
	
	

}
