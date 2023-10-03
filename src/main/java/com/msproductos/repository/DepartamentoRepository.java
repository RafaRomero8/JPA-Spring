package com.msproductos.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.msproductos.dto.Product_DepaDTO;
import com.msproductos.entity.Departamento;
import com.msproductos.entity.Productos;



@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Integer> {


//	@Query(value="SELECT * "
//			+ "FROM DEPARTAMENTO E "
//			+ "INNER JOIN PRODUCTOS D ON E.DEPTO_ID=D.DEPTO_ID "
//			+ "WHERE E.NOMBRE =:nombreDepa" ,nativeQuery = true)
	@Query(value="SELECT * "
			+ "FROM PRODUCTOS E "
			+ "INNER JOIN  DEPARTAMENTO D ON D.DEPTO_ID=E.DEPTO_ID "
			+ "WHERE D.NOMBRE =:nombreDepa" ,nativeQuery = true)
	List<Departamento> getDepaProductosbyName(@Param("nombreDepa") String nombreDepa);
	
	 
	@Query(value="SELECT * "
			+ "FROM PRODUCTOS E "
			+ "INNER JOIN  DEPARTAMENTO D ON E.DEPTO_ID=D.DEPTO_ID" ,nativeQuery = true)
	// @Query("SELECT * FROM Departamento d INNER JOIN d.products p")
	List<Departamento> getDepaProductos();
	
	
	@Query(value="SELECT * "
			+ "FROM PRODUCTOS E "
			+ "INNER JOIN  DEPARTAMENTO D ON D.DEPTO_ID=E.DEPTO_ID",nativeQuery = true)
	List<Departamento> getTupleDepaProductosbyName();
	


}
