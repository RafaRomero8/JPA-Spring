package com.msproductos.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="VENTAS")
public class Ventas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="prodVentas")
	@SequenceGenerator(name="prodVentas",sequenceName="SQ_VENTAS",allocationSize=1)
	@Column(name="VENTA_ID",columnDefinition="NUMBER")
	private int ventaId;
	
//	@ManyToOne
//	@JoinColumn(name="EMPLEADO_ID",columnDefinition="NUMBER")
//	private Empleados  empleado;//cambiamos a tipo Empleados ya no es int
//	//lo hacemos para hacer el ManytoOne etc.. las relaciones
//	
//	@ManyToOne
//	@JoinColumn(name="CUSTOMER_ID",columnDefinition="NUMBER")
//	private Customers  customer;//esta variable se enlaza al OneToMany de la clase customer
//	
	@Column(name="FECHA_VENTA",columnDefinition="DATE")
	private LocalDateTime  fecha;
	
	@Column(name="SUBTOTAL",columnDefinition="NUMBER(5,2)")
	private double  subtotal;
	
	@Column(name="TOTAL",columnDefinition="NUMBER(5,2)")
	private double  total;

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

//	
//	public Empleados getEmpleado() {
//		return empleado;
//	}
//
//	public void setEmpleado(Empleados empleado) {
//		this.empleado = empleado;
//	}
//
//	public Customers getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customers customer) {
//		this.customer = customer;
//	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
