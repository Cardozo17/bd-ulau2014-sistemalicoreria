package com.Proyecto.modelodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Proyecto.conexionBD.DBConnection;
import com.Proyecto.modelovo.DatosEmpresaVO;
import com.Proyecto.modelovo.PersonaVO;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DatosEmpresaDAO {


	public DatosEmpresaVO consultarUnaEmpresa() {
		  DBConnection conex= new DBConnection();
		  DatosEmpresaVO empresa= new DatosEmpresaVO();
		  try {
		   PreparedStatement consulta = (PreparedStatement) conex.getConnection().prepareStatement("SELECT * FROM datosempresa");
		  // consulta.setString(1,"");
		   ResultSet res = consulta.executeQuery();
		    
		  if(res.next()){
		   
		    empresa.setNombre(res.getString("nombre"));
		    empresa.setRif((res.getString("rif")));
		    empresa.setDiremp((res.getString("diremp")));
		    empresa.setTelefono(res.getString("telefono"));
	
		
		      }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		    
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la Empresa\n"+e);
		  }
		  return empresa;
		 }
	
}
