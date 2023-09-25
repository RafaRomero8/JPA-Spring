package com.msproductos.service;

import java.util.List;
import com.msproductos.entity.Ventas;


public interface VentasService {
	
	
//	Productos guardar(ProductosRequest request) throws ResourceNotFoundException;
//	Productos actualizar(ProductosRequest request)throws ResourceNotFoundException;
//	String eliminar(int id) throws BussinesException;
//	Productos buscar(int id) throws BussinesException;
//	List mostrar();
    public List<Ventas> listarVentas();
    public void guardar(Ventas venta);
    public void eliminar(Ventas venta);
    public Ventas encontrarVneta(Ventas venta);
    
}
