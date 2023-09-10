package com.msproductos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus.Series;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msproductos.entity.Productos;
import com.msproductos.impl.ProductoImplement;
import com.msproductos.request.ProductosRequest;

//es casi al equivalente a la clase Service de los otros proyecto s de hibernete y JDDBC
//Solo que cambian las notaciones

@RestController//cuando hay comunicacion entre una vista y una logica de negocio
@RequestMapping("productos/")
public class ProductoController {
	
	@Autowired//para que no te genere todas las instancias
	//lo que necesita  Autowired una implementacion una instancia de ProductoImplement
	//al ponerlo el rendimiento es mejor
	//SINGLETON se refiere a que toma solo una instancia,hace refernecia a la misma instancia
	//en toda la aplicacion,si tengo 1000 peticiones solo toma 1 peticion
	ProductoImplement logic;//
	
	//http://localhost:8090/marca 
	@PostMapping
	ResponseEntity<Productos> guardar(@Valid @RequestBody ProductosRequest request){
		//el @RequestBody quiere decir que el JSON  que viene va hacer match con los atributos
		//que estan indicados en la clase y asi obtener los datos
		Productos prod = logic.guardar(request); 
		return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}//---------------
	
	//http://localhost:8090/marca PUT   pasarle el id
	@PutMapping
	ResponseEntity<Productos> actualizar(@RequestBody ProductosRequest request){
		Productos prod = logic.actualizar(request);
		return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}
	
	//http://localhost:8090/marca 
	@GetMapping
	ResponseEntity<List<Productos>> mostar(){
		
		List<Productos> productos = logic.mostrar();
		return new ResponseEntity<List<Productos>>(productos,HttpStatus.OK);
	}
	
	@GetMapping("buscar-por-id/{id}")
	ResponseEntity<Productos> buscar(@PathVariable int id){
		Productos prod = logic.buscar(id);
		
	      return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}
	
	
	@DeleteMapping("eliminar/{id}")
	ResponseEntity<String> eliminar(@PathVariable int id){
		String mensaje = logic.eliminar(id);
		return new ResponseEntity<String>(mensaje,HttpStatus.OK);
	}
	
	

}
