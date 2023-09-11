package com.saveAll.mssaveAll.Service;

import java.util.List;

import com.saveAll.mssaveAll.CustomerGeneric.CustomerGeneric;
import com.saveAll.mssaveAll.Entity.CustomerEntity;
import com.saveAll.mssaveAll.Request.CustomerRequest;



public interface CustomerService {
	
	CustomerGeneric  guardar(CustomerRequest request);
	CustomerGeneric actualizar(CustomerRequest request);
	CustomerEntity buscar(int id);
	List<CustomerEntity> buscar(String nombre);
	String eliminar(int id);
	List mostrar();
}
