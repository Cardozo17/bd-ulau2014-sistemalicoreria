package com.Proyecto.modelovo;

public class ProductoVO {
	
	private String idproduc;
	private String nombreprod;
	private String codprov;
	private String cantidadexist;
	private String preciounit;
	
	public ProductoVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductoVO(String idproduc, String nombreprod, String codprov,
			String cantidadexist, String preciounit) {
		super();
		this.idproduc = idproduc;
		this.nombreprod = nombreprod;
		this.codprov = codprov;
		this.cantidadexist = cantidadexist;
		this.preciounit = preciounit;
	}


	public String getIdproduc() {
		return idproduc;
	}
	public void setIdproduc(String idproduc) {
		this.idproduc = idproduc;
	}
	public String getNombreprod() {
		return nombreprod;
	}
	public void setNombreprod(String nombreprod) {
		this.nombreprod = nombreprod;
	}
	public String getCodprov() {
		return codprov;
	}
	public void setCodprov(String codprov) {
		this.codprov = codprov;
	}
	public String getCantidadexist() {
		return cantidadexist;
	}
	public void setCantidadexist(String cantidadexist) {
		this.cantidadexist = cantidadexist;
	}
	public String getPreciounit() {
		return preciounit;
	}
	public void setPreciounit(String preciounit) {
		this.preciounit = preciounit;
	}

}
