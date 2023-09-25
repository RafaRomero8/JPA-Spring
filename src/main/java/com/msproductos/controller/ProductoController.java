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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msproductos.dto.Product_DepaDTO;
import com.msproductos.entity.Productos;
import com.msproductos.generic.ProductoGeneric;
import com.msproductos.impl.ProductoImplement;
import com.msproductos.request.ProductosRequest;

//es casi al equivalente a la clase Service de los otros proyectos de hibernete y JDDBC
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
	
	
//	@GetMapping("/")
//	public String inicio() {
//		return "Hola mundo"
//		
//	}
	
	//http://localhost:8090/marca 
	@PostMapping
	ResponseEntity<Productos> guardar(@Valid @RequestBody ProductosRequest request){
		//el @RequestBody quiere decir que el JSON  que viene va hacer match con los atributos
		//que estan indicados en la clase y asi obtener los datos
		Productos prod = logic.guardar(request); 
		return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}//---------------
	
	
	@PostMapping("save")
	String save(@RequestBody ProductosRequest request) {
		System.out.println("checar aqui>>>>>>");
		ProductoGeneric c = logic.save(request);
		c.setMensaje("Exitoso");
		return c.toString();	
	}
	
	
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
	
	@GetMapping("buscar-por-nombre/{name}")
	ResponseEntity <List<Productos>> buscar(@PathVariable String name) {
		List<Productos> prod = logic.buscar(name);
		return new ResponseEntity<List<Productos>>(prod, HttpStatus.OK);
	}
	
	
	@DeleteMapping("eliminar/{id}")
	ResponseEntity<String> eliminar(@PathVariable int id){
		String mensaje = logic.eliminar(id);
		return new ResponseEntity<String>(mensaje,HttpStatus.OK);
	}
	
	
	@GetMapping("search/{name}")
	ResponseEntity <List<Productos>> search(@PathVariable String name) {
		List<Productos> prod = logic.search(name);
		return new ResponseEntity<List<Productos>>(prod, HttpStatus.OK);
	}
	
	@GetMapping("precio_venta/{precio}")
	ResponseEntity <List<Productos>> precio_venta(@PathVariable double precio) {
		List<Productos> prod = logic.precio_venta(precio);
		return new ResponseEntity<List<Productos>>(prod, HttpStatus.OK);
	}
	
	
	
	@GetMapping("product_depa")
	ResponseEntity <List<Product_DepaDTO>>  getDepaById(){
		

		List<Product_DepaDTO> prod = null;
		prod = logic.getDepaById();
		
		return new ResponseEntity<List<Product_DepaDTO>>(prod, HttpStatus.OK);
	}
	
//	@GetMapping("search")   //@RequestParam 
//	public ResponseEntity<?> search(@RequestParam  String name){
//		
//		try {
////			System.out.println("checar eltry del controller");
//			return  ResponseEntity.status(HttpStatus.OK).body(logic.search(name));
//			
////			List<Productos> prod = logic.buscar(name);
////			return new ResponseEntity<List<Productos>>(prod, HttpStatus.OK);
//			
//		} catch (Exception e) {
//			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \ "" + getMessage() +"\"}" ));
//			//return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND);
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//			
//		}
//		
//	}
	
	

}
