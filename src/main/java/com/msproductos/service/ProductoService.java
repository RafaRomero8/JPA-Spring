package com.msproductos.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.msproductos.dto.Product_DepaDTO;
import com.msproductos.dto.Product_DepaDTO2;
import com.msproductos.entity.Productos;
import com.msproductos.exception.BussinesException;
import com.msproductos.exception.ResourceNotFoundException;
import com.msproductos.generic.ProductoGeneric;
import com.msproductos.request.ProductosRequest;

//Interface de negocio
public interface ProductoService {
	//se tiene una lista de metodos abtsracto sq qeu refleja las operaciones
	//operaciones del proyecto
	//metodos que hacen algo en la entidad
	Productos guardar(ProductosRequest request) throws ResourceNotFoundException;
	Productos actualizar(ProductosRequest request)throws ResourceNotFoundException;
	ProductoGeneric save(ProductosRequest request);
	Productos buscar(int id) throws BussinesException;
	List<Productos> buscar(String nombre) throws BussinesException;
	List<Productos> search(String nombre) throws BussinesException;
	List<Productos> precio_venta(double precio_venta)throws ResourceNotFoundException;
	String eliminar(int id) throws BussinesException;
	List<Productos> mostrar();
	
	
	
	//ModelMapper
	//List<Product_DepaDTO> getDepaProduct(String refrigerado)throws BussinesException;
	List<Product_DepaDTO> getDepaProduct();
	//List<Product_DepaDTO> getDepaProduct(String nombre);
	

	//Con dos entidades dtos-----------------
	List<Product_DepaDTO> getDepaProductos();
	List<Product_DepaDTO> getDepaProductosDTOByName(String nombreDepa);
	List<Product_DepaDTO> getTupleDTOByName();
	List<Product_DepaDTO> getTupleDTO(String nombreDepa);//utiliza un Tuple
	List<Product_DepaDTO> getTupleDTO2();//utiliza un Tuple
	//----------------------------------------------
	
	
	List<Product_DepaDTO> getDepaById() throws BussinesException;
	//List<Product_DepaDTO> getRefrigerado(String nombre) throws BussinesException;
	
	String getName(String nombre);
	
	
	
	
}
