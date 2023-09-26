package com.msproductos.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Product_DepaDTO2 implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private String nombre;
	//private String nombreDepa;
	private LocalDateTime fecha_cad;
	private String refrigerado;
	
	
	 public Product_DepaDTO2(){};
	public Product_DepaDTO2(String nombre, LocalDateTime fecha_cad, String refrigerado) {
		//super();
		this.nombre = nombre;
		this.fecha_cad = fecha_cad;
		this.refrigerado = refrigerado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public String getNombreDepa() {
//		return nombreDepa;
//	}
//	public void setNombreDepa(String nombreDepa) {
//		this.nombreDepa = nombreDepa;
//	}
	public LocalDateTime getFecha_cad() {
		return fecha_cad;
	}
	public void setFecha_cad(LocalDateTime fecha_cad) {
		this.fecha_cad = fecha_cad;
	}
	public String getRefrigerado() {
		return refrigerado;
	}
	public void setRefrigerado(String refrigerado) {
		this.refrigerado = refrigerado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
