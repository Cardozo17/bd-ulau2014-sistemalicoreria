package com.Proyecto.modelovo;

import java.sql.Date;

public class ProveedorVO {
	
	private String codproov;
	private String rifprov;
	private String nombreprov;
	private String dirprov;
	private String telfprov;
	
	private Date diadedespacho;
	
	public String getCodproov() {
		return codproov;
	}
	public void setCodproov(String codproov) {
		this.codproov = codproov;
	}
	public String getRifprov() {
		return rifprov;
	}
	public void setRifprov(String rifprov) {
		this.rifprov = rifprov;
	}
	public String getNombreprov() {
		return nombreprov;
	}
	public void setNombreprov(String nombreprov) {
		this.nombreprov = nombreprov;
	}
	public String getDirprov() {
		return dirprov;
	}
	public void setDirprov(String dirprov) {
		this.dirprov = dirprov;
	}
	
	public String getTelfprov() {
		return telfprov;
	}
	public void setTelfprov(String telfprov) {
		this.telfprov = telfprov;
	}
	
	public Date getDiadedespacho() {
		return diadedespacho;
	}
	public void setDiadedespacho(Date diadedespacho) {
		this.diadedespacho = diadedespacho;
	} 
	

}
