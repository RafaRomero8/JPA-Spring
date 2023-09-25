package com.msproductos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msproductos.entity.Productos;
import com.msproductos.entity.Ventas;
import com.msproductos.repository.VentasRepository;

import lombok.extern.slf4j.Slf4j;


@RestController//cuando hay comunicacion entre una vista y una logica de negocio
@RequestMapping("ventas/")
@Slf4j
public class VentasController {
	
	
	@Autowired
	private VentasRepository ventaDao;
	
	
//	@GetMapping
//	public String mostrar(Model model) {
//		List<Ventas> venta= (List<Ventas>) ventaDao.findAll();
//		 model.addAttribute("venta",ventas);
//		 return "mostrado"
//	}
//	
	
	

}
