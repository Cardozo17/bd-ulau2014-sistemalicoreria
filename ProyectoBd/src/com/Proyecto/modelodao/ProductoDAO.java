package com.Proyecto.modelodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Proyecto.conexionBD.DBConnection;
import com.Proyecto.modelovo.ProductoVO;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ProductoDAO {

	 /**
	  * Permite agregar un producto
	  * @param producto
	  */
	
	 public boolean agregarProducto(ProductoVO producto) 
	 {
	  DBConnection conex= new DBConnection();
	  try {
	   Statement estatuto = (Statement) conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO producto VALUES ('"+producto.getIdproduc()+"', '" +producto.getNombreprod()+"', '"
	   +producto.getCodprov()+"', '"+producto.getCantidadexist()+"', '"+producto.getPreciounit()+"')");
	   JOptionPane.showMessageDialog(null, "Se ha agregado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
	   estatuto.close();
	   conex.desconectar();
	    
	  } catch (SQLException e) {
	   System.out.println(e.getMessage());
	   JOptionPane.showMessageDialog(null, "No se pudo agregar el producto");
	   return false;
	  }
	  
	  return true;
	 }
	 
	 /**
	  * Permite eliminar un producto
	  * @param codigo
	  */
	 
	 public boolean eliminarProducto (String codigo)
	 {
		 DBConnection conex= new DBConnection();
		 try {
			   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("DELETE FROM producto WHERE idproduc = ? ");
			   consulta.setString(1, codigo);
			   consulta.execute();

			   JOptionPane.showMessageDialog(null, "Se ha  eliminado el  producto con exito\n"); 	
			   		   consulta.close();
			          conex.desconectar();
			    
			  } catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto\n"+e);
			   return false;
			  }
		 
		 return true;
	 }
	    
	/**
	 * permite consultar un producto asociado codigo enviado
	 * como parametro 
	 * @param codigo 
	 * @return
	 */
	public ArrayList<ProductoVO> consultarProducto(String codigo) {
	  ArrayList<ProductoVO> miProducto = new ArrayList<ProductoVO>();
	  DBConnection conex= new DBConnection();
	    
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM producto where idproduc = ? ");
	   consulta.setString(1, codigo);
	   ResultSet res = consulta.executeQuery();
	    
	  if(res.next()){
	    ProductoVO producto= new ProductoVO();
	    producto.setIdproduc(res.getString("idproduc"));
	    producto.setNombreprod(res.getString("nombreprod"));
	    producto.setCodprov(res.getString("codproov"));
	    producto.setCantidadexist(Integer.valueOf(res.getString("cantidadexist")));
	    producto.setPreciounit(Float.valueOf(res.getString("preciounit")));
	    miProducto.add(producto);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "No se pudo consultar el producto\n"+e);
	  }
	  return miProducto;
	 }
	 
	
	public ProductoVO consultarUnProducto(String codigo) {
		  DBConnection conex= new DBConnection();
		  ProductoVO producto= new ProductoVO();
		  try {
		   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM producto where idproduc = ? ");
		   consulta.setString(1, codigo);
		   ResultSet res = consulta.executeQuery();
		    
		  if(res.next()){
		   
		    producto.setIdproduc(res.getString("idproduc"));
		    producto.setNombreprod(res.getString("nombreprod"));
		    producto.setCodprov(res.getString("codproov"));
		    producto.setCantidadexist(Integer.valueOf(res.getString("cantidadexist")));
		    producto.setPreciounit(Float.valueOf(res.getString("preciounit")));
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		    
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "No se pudo consultar el producto\n"+e);
		  }
		  return producto;
		 }
	/**
	 * permite consultar la lista de productos
	 * @return
	 */
	public ArrayList< ProductoVO> listaDeProductos() {
	  ArrayList<ProductoVO> miProducto = new ArrayList< ProductoVO>();
	  DBConnection conex= new DBConnection();
	     
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM producto");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    ProductoVO producto= new ProductoVO();
	    producto.setIdproduc(res.getString("idproduc"));
	    producto.setNombreprod(res.getString("nombreprod"));
	    producto.setCodprov(res.getString("codproov"));
	    producto.setCantidadexist(Integer.valueOf(res.getString("cantidadexist")));
	    producto.setPreciounit(Float.valueOf(res.getString("preciounit")));
	    miProducto.add(producto);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "No se pudo consultar la lista  de productos\n"+e);
	  }
	  return miProducto;
	 }
	
	/**
	 * permite actualizar un producto asociado codigo enviado y un producto
	 * como parametro 
	 * @param idviejo producto
	 * @return
	 */
	public boolean actualizarProducto(ProductoVO producto) {
	  DBConnection conex= new DBConnection();
	    
	  try {
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("UPDATE producto SET idproduc= ?,nombreprod= ?, codproov= ?, cantidadexist= ?, preciounit= ? " + " WHERE idproduc = ? ");
	   consulta.setString(1,producto.getIdproduc());
	   consulta.setString(2, producto.getNombreprod());
	   consulta.setString(3, producto.getCodprov());
	   consulta.setString(4,Integer.toString(producto.getCantidadexist()));
	   consulta.setString(5, Float.toString(producto.getPreciounit()));
	   consulta.setString(6,producto.getIdproduc());
	   consulta.execute();
	    
	   JOptionPane.showMessageDialog(null, "Se ha  actualizado el  producto con exito\n"); 
	   consulta.close();
	   conex.desconectar();	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "No se pudo actualizar el producto\n"+e);
	   	return false;
	  }
	  return true;
	 }
}
