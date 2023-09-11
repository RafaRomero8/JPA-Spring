package com.saveAll.mssaveAll.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.saveAll.mssaveAll.CustomerGeneric.CustomerGeneric;
import com.saveAll.mssaveAll.Entity.CustomerEntity;
import com.saveAll.mssaveAll.Repository.CustomerRepository;
import com.saveAll.mssaveAll.Request.CustomerRequest;
import com.saveAll.mssaveAll.Service.CustomerService;

@Service
public class CustomerImplement implements CustomerService {

	@Autowired
	CustomerRepository repo;
	
	@Override
	public CustomerGeneric guardar(CustomerRequest request) {
		CustomerGeneric c= new CustomerGeneric(); 
		repo.saveAll(request.getListCustomer());
		return c;
	}

	@Override
	public CustomerGeneric  actualizar(CustomerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerEntity buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *Buscar solo un dato
	@Override
	public CustomerEntity buscar(String nombre) {
		CustomerEntity c = null;
		if(repo.findByName(nombre).isPresent())
		{
			c=repo.findByName(nombre).get();
			return c;
		}else {
			System.out.println("No existe cliente");
			return c;
		}
	}*/
	//Mostrar el resultado de varios datos que vienen de las tablas
	@Override
	public List<CustomerEntity> buscar(String nombre) {
		List<CustomerEntity> c = null;
			c=repo.getfindNombres(nombre);
			return c;
		
	}

	@Override
	public String eliminar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List mostrar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	
}
