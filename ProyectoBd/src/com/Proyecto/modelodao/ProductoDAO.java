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
	
	 public void agregarProducto(ProductoVO producto) 
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
	  }
	 }
	 
	 public void eliminarProducto (String codigo)
	 {
		 DBConnection conex= new DBConnection();
		 try {
			   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("DELETE FROM producto WHERE idproduc = ? ");
			   consulta.setString(1, codigo);
			   consulta.execute();

			          consulta.close();
			          conex.desconectar();
			    
			  } catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "no se pudo eliminar la producto\n"+e);
			  }
		 
		 
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
	    producto.setCodprov(res.getString("codprov"));
	    producto.setCantidadexist(res.getString("cantidadexist"));
	    producto.setPreciounit(res.getString("preciounit"));
	    miProducto.add(producto);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo consultar la producto\n"+e);
	  }
	  return miProducto;
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
	    producto.setCodprov(res.getString("codprov"));
	    producto.setCantidadexist(res.getString("cantidadexist"));
	    producto.setPreciounit(res.getString("preciounit"));
	    miProducto.add(producto);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo consultar el producto\n"+e);
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
	   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("UPDATE producto SET idproduc= ?,nombreprod= ?, codprov= ?, cantidadexist= ?, preciounit= ? " + " WHERE idproduc = ? ");
	   consulta.setString(1,producto.getIdproduc());
	   consulta.setString(2, producto.getNombreprod());
	   consulta.setString(3, producto.getCodprov());
	   consulta.setString(4,producto.getCantidadexist());
	   consulta.setString(5, producto.getPreciounit());
	   consulta.setString(6,producto.getIdproduc());
	   consulta.execute();
	    
	   consulta.close();
	   conex.desconectar();	    
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo eliminar la producto\n"+e);
	   	return false;
	  }
	  return true;
	 }
}
