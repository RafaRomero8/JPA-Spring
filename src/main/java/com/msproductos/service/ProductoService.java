package com.msproductos.service;

import java.util.List;

import com.msproductos.entity.Productos;
import com.msproductos.exception.BussinesException;
import com.msproductos.exception.ResourceNotFoundException;
import com.msproductos.request.ProductosRequest;

//Interface de negocio
public interface ProductoService {
	//se tiene una lista de metodos abtsracto sq qeu refleja las operaciones
	//operaciones del proyecto
	//metodos que hacen algo en la entidad
	Productos guardar(ProductosRequest request) throws ResourceNotFoundException;
	Productos actualizar(ProductosRequest request)throws ResourceNotFoundException;
	Productos buscar(int id) throws BussinesException;
	Productos buscar(String nombre) throws BussinesException;;
	String eliminar(int id) throws BussinesException;
	List mostrar();

}
