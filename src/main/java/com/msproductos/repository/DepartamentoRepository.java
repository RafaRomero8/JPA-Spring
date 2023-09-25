package com.msproductos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msproductos.dto.Product_DepaDTO;
import com.msproductos.entity.Departamento;
import com.msproductos.entity.Productos;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Integer> {
	
	// Departamento findByDepartamento(String nombre);

}
