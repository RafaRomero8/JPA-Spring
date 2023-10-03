package com.msproductos.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.msproductos.entity.Departamento;

public class Product_DepaDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private String nombre;
	//private LocalDateTime fecha_cad;
	private String fecha_cad;
	private String refrigerado;
	private double precio_compra;
	private String nombreDepa;
	//private int empleadoId;
	
	
	public Product_DepaDTO() {}
	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}









public Product_DepaDTO(String nombre, String fecha_cad, String refrigerado, double precio_compra,
			String nombreDepa) {
		//super();
		this.nombre = nombre;
		this.fecha_cad = fecha_cad;
		this.refrigerado = refrigerado;
		this.precio_compra = precio_compra;
		this.nombreDepa = nombreDepa;
	}



public String getFecha_cad() {
		return fecha_cad;
	}



	public void setFecha_cad(String fecha_cad) {
		this.fecha_cad = fecha_cad;
	}



public String getNombreDepa() {
	return nombreDepa;
}



public void setNombreDepa(String nombreDepa) {
	this.nombreDepa = nombreDepa;
}



public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio_compra() {
		return precio_compra;
	}



	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	
	public String getRefrigerado() {
		return refrigerado;
	}
	public void setRefrigerado(String refrigerado) {
		this.refrigerado = refrigerado;
	}
	
	

}
