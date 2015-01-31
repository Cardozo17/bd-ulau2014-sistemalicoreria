package com.Proyecto.modelovo;

public class EmpleadoVO {
	
	private String codemp;
	private String cargo;
	private int anosserv;
	private float salario;
	private String cid;
	private String nombre;
	private String apellido;
	private String telef;
	
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
	public String getCodemp() {
		return codemp;
	}
	public void setCodemp(String codemp) {
		this.codemp = codemp;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getAnosserv() {
		return anosserv;
	}
	public void setAnosserv(int anosserv) {
		this.anosserv = anosserv;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelef() {
		return telef;
	}
	public void setTelef(String telef) {
		this.telef = telef;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	private String direccion; 
	

}
