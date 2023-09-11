package com.saveAll.mssaveAll.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.saveAll.mssaveAll.CustomerGeneric.CustomerGeneric;
import com.saveAll.mssaveAll.Entity.CustomerEntity;
import com.saveAll.mssaveAll.Impl.CustomerImplement;
import com.saveAll.mssaveAll.Request.CustomerRequest;

@RestController
@RequestMapping("Customers/")
public class CustomerController {

	@Autowired 
    CustomerImplement logic;
	
	@PostMapping
	String guardar(@RequestBody CustomerRequest request) {
		CustomerGeneric c = logic.guardar(request);
		c.setMensaje("Exitoso");
		return c.toString();	
	}
	

	@GetMapping
	ResponseEntity <List<CustomerEntity>> mostrar() {
		List<CustomerEntity> prod = logic.mostrar();
		return new ResponseEntity<List<CustomerEntity>>(prod, HttpStatus.OK);
	}
	

	@GetMapping("buscar-por-nombre/{name}")
	ResponseEntity <List<CustomerEntity>> buscar(@PathVariable String name) {
		List<CustomerEntity> prod = logic.buscar(name);
		return new ResponseEntity<List<CustomerEntity>>(prod, HttpStatus.OK);
	}
	
	

}
