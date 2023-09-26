package com.msproductos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msproductos.entity.Departamento;


@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Integer> {
	
	// Departamento findByDepartamento(String nombre);
	
	//List<Departamento> getByDepa(String nombre);

}
