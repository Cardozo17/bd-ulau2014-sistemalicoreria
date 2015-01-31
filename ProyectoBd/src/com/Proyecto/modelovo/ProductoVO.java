package com.Proyecto.modelovo;

public class ProductoVO {
	
	private String idproduc;
	private String nombreprod;
	private String codproov;
	private int cantidadexist;
	private float preciounit;
	
	public ProductoVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductoVO(String idproduc, String nombreprod, String codproov,
			int cantidadexist, float preciounit) {
		super();
		this.idproduc = idproduc;
		this.nombreprod = nombreprod;
		this.codproov = codproov;
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
		return codproov;
	}
	public void setCodprov(String codproov) {
		this.codproov = codproov;
	}
	public int getCantidadexist() {
		return cantidadexist;
	}
	public void setCantidadexist(int cantidadexist) {
		this.cantidadexist = cantidadexist;
	}
	public float getPreciounit() {
		return preciounit;
	}
	public void setPreciounit(float preciounit) {
		this.preciounit = preciounit;
	}

}
