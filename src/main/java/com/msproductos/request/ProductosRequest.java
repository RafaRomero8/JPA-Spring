package com.msproductos.request;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.*;//lo usamos para validar que ele campo no este vacio y va arriba del atributo nombre

import com.msproductos.entity.Productos;



//NO LLEVA ANOTACIONES,pero se ocupar notaciones para validar
//AQUI HACEMOS VALIDACIONES
//CHECAR VALIDACIONES DE NEGOCIOS
///SI LLEVA ATRIBUTOS,CONSTRUCTORES,GET YSET
public class ProductosRequest {
//AQUI VALIDAMOS LO QUE LLEGA DEL CLIENTE EN ESTA CLASE U OBJETO
	//SE TIENEN QUE ACTIVAR LAS VALIDACIONES EN CONTROLLER	
    private int productoId;

	private int  deptoID;
	@NotBlank(message="El  atributo nombre no puede estar vacio ni quedar en blanco")
	private String nombre;
	@Future(message="La fecha de caducidad debe ser mayor a la fecha actual")//checar que la fecha se mayor al actual
	private String fecha_cad;
	@Digits(integer = 3/*precision*/, fraction = 2 /*scale*/)
	private double precio_compra;
	@Digits(integer = 3 /*precision*/, fraction = 2 /*scale*/)
	private double precio_venta;
	
	private String refrigerado;//esta validacion se pone en productoImplement
	//ya que no hay anotacion para este 
	
	private List<Productos> lisProductos;
	
	public List<Productos> getLisProductos() {
		return lisProductos;
	}

	public void setLisProductos(List<Productos> lisProductos) {
		this.lisProductos = lisProductos;
	}

	public ProductosRequest() {}
	

	
	public int getProductoId() {
		return productoId;
	}

	public ProductosRequest(int productoId, int deptoID, String nombre, String fecha_cad,
			double precio_compra, double precio_venta, String refrigerado, List<Productos> lisProductos) {
		
		//super();
		this.productoId = productoId;
		this.deptoID = deptoID;
		this.nombre = nombre;
		this.fecha_cad = fecha_cad;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.refrigerado = refrigerado;
		this.lisProductos = lisProductos;
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

	public String getFecha_cad() {
		return fecha_cad;
	}

	public void setFecha_cad(String fecha_cad) {
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
	
	
	
	
}
