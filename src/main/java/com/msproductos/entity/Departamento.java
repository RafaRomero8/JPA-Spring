package com.msproductos.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTAMENTO")
//@PrimaryKeyJoinColumn(referencedColumnName="DEPTO_ID")
public class Departamento implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="depAuto")
	@SequenceGenerator(name="depAuto",sequenceName="SQ_DEPARTAMENTO",allocationSize=1)
	
	@Column(name="DEPTO_ID",columnDefinition="NUMBER")
	private int deptoId;
	@Column(name="EMPLEADO_ID",columnDefinition="NUMBER")
   private int empleadoId;
	
	@Column(name="NOMBRE",columnDefinition="NVARCHAR2(20)")
	private String nombre;
	
	
	@OneToMany(mappedBy = "depa")
	List<Productos> products;
	

	
	Departamento(){}
	
	public int getDeptoId() {
		return deptoId;
	}

	public void setDeptoId(int deptoId) {
		this.deptoId = deptoId;
	}

	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

		
	
}
