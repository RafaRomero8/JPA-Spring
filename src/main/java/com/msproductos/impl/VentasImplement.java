package com.msproductos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msproductos.entity.Ventas;
import com.msproductos.service.VentasService;


@Service//para que sprint reconozca que es una clase de servicio agregamos la notacion de Service
//para poder inyectar la clase dentro del controlador de sprint
public class VentasImplement implements VentasService {

	
	//inyectar una instancia de la clase Ventas(el DAO)
	//@Autowired
	//private VentasRepository ventaDao;//aqui conectamos nuestra capa de servicio con nuestra capa de datos
	//utilizando nuestra variable ventaDao
	
//	@Override
//	public List<Ventas> listarVentas() {
//		
//
//		return (List<Ventas>)ventaDao.findAll();
//	}

	@Override
	public void guardar(Ventas venta) {
	
		
	}

	@Override
	public void eliminar(Ventas venta) {
	
		
	}

	@Override
	public Ventas encontrarVneta(Ventas venta) {
		
		return null;
	}

	@Override
	public List<Ventas> listarVentas() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
