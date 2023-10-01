package com.msproductos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.msproductos.dto.Product_DepaDTO;
import com.msproductos.entity.Departamento;



@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Integer> {


	@Query(value="SELECT * "
			+ "FROM DEPARTAMENTO E "
			+ "INNER JOIN PRODUCTOS D ON E.DEPTO_ID=D.DEPTO_ID" ,nativeQuery = true)
	List<Departamento> getDepaProductos();
	
	// Departamento findByDepartamento(String nombre);
	
	//List<Departamento> getByDepa(String nombre);

}
