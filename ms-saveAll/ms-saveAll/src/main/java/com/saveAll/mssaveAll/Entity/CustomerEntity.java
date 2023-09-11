package com.saveAll.mssaveAll.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;

@Entity
@Table(name = "CUSTOMERS")
public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custoAuto")
	@SequenceGenerator(name = "custoAuto", sequenceName = "SQ_CUSTOMERS", allocationSize = 1)
	@Column(name = "CUSTOMER_ID", columnDefinition = "NUMBER")
	private int customerId;
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(15)")
	private String nombre;
	@Column(name = "FECHA_NAC", columnDefinition = "DATE")
	private LocalDateTime fecha_nac;
	@Column(name = "DOMICILIO", columnDefinition = "NVARCHAR2(40)")
	private String domicilio;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDateTime getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(LocalDateTime fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
