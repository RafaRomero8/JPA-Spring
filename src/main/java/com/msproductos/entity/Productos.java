package com.msproductos.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


//PRIMERA CAPA

@Entity
@Table(name="PRODUCTOS")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Productos implements Serializable {
//
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//implementa serilizacion
	//lo que significa tomar los objetos y lo desintegramos en bytes,vamos a dividirlos,y es lo que viaja a traves de la red
	//cada ves que el cliente hace un peticion se vuelve a reconstruir el objeto
	//el cliente lo desceliariza(lo vuelve a construir)
	//en el backend se desintegra en bytes(celiarización)
	//1L es como un long
	
	//NECESITAMOS MAPEAR LA TABLA DEL SQL
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="prodAuto")
	@SequenceGenerator(name="prodAuto",sequenceName="SQ_PRODUCTOS",allocationSize=1)
	@Column(name="PRODUCTO_ID ",columnDefinition="NUMBER")
	private int productoId;
	
	@Column(name="DEPTO_ID",columnDefinition="NUMBER")
	private int  deptoID;
	
	@Column(name="NOMBRE",columnDefinition="NVARCHAR2(20)")
	private String nombre;
	
	@Column(name="FECHA_CAD",columnDefinition="DATE")
	private LocalDateTime fecha_cad;
	
	@Column(name="PRECIO_COMPRA",columnDefinition="NUMBER(5,2)")
	private double precio_compra;
	
	@Column(name="PRECIO_VENTA",columnDefinition="NUMBER(5,2)")
	private double precio_venta;
	
	@Column(name="REFRIGERADO",columnDefinition="CHAR(1)")
	private String refrigerado;
	
	
	//@Transient
	
	
	@ManyToOne
	@JoinColumn(name="DEPTO_ID",insertable = false, updatable = false)
//	@JoinTable(name="precio_depa",
//               joinColumns = @JoinColumn(name="deptoId"),
//               inverseJoinColumns = @JoinColumn(name="productoId"))
	private Departamento depa;
	
	
	//@Transient
	
	
	
	
	public int getProductoId() {
		return productoId;
	}
	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}
	public int getDeptoID() {
		return deptoID;
	}
	public void setDeptoID(int deptoID) {
		this.deptoID = deptoID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDateTime getFecha_cad() {
		return fecha_cad;
	}
	public void setFecha_cad(LocalDateTime fecha_cad) {
		this.fecha_cad = fecha_cad;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
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
