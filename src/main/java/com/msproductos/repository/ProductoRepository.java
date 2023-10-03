package com.msproductos.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.msproductos.dto.Product_DepaDTO;
import com.msproductos.dto.Product_DepaDTO2;
import com.msproductos.entity.Productos;
//DAO

//ESTA INTERFAZ ES EL DAO 
//LA QUE ENGLOBA LAS CONSULTAS
@Repository//componente de acceso a datos o de algun repositorio donde vamos a extraer informacion
public interface ProductoRepository extends JpaRepository<Productos,Integer>{

	 
	@Query("FROM Productos WHERE depa.nombre =:nombre")
     List<Productos> getByDepa(@Param("nombre")String nombre);
	
	//JpaRepository parametrizado con 2 parametros,la entidad con la que se va a trabjar
	//y el tipo de dato del ID(PRIMARY KEY de la tabla) del producto se le pasa un Integer(no usa datso primitivos)
	
	//Con JPQL
	@Query("SELECT c FROM Productos c WHERE c.nombre LIKE %:name%")
	//Optional<CustomerEntity> findByName(@Param("name")String name);
	List<Productos> getfindNombres(@Param("name")String name);
	
	//@Query("SELECT c FROM Productos c WHERE c.refrigerado =:refrigerado"))
	//List<Productos> findByName(@Param("nombre") String nombre);
	
	//Con SQL 
	@Query(value = "SELECT * FROM PRODUCTOS WHERE PRODUCTOS.NOMBRE LIKE %:name%",
			nativeQuery = true)
	List<Productos> getfindNombresSQL(@Param("name") String name);
	
	@Query (value="SELECT * FROM PRODUCTOS  WHERE PRODUCTOS.PRECIO_VENTA>=?1",
			 nativeQuery = true )
	List<Productos> getfindPrecioVenta(@Param("precio_venta") double precio_venta);
	

//	@Query(value="SELECT * "
//			+ "FROM DEPARTAMENTO E "
//			+ "INNER JOIN PRODUCTOS D ON E.DEPTO_ID=D.DEPTO_ID "
//			+ "WHERE E.NOMBRE =:nombreDepa" ,nativeQuery = true)
	@Query(value="SELECT * "
			+ "FROM PRODUCTOS E "
			+ "INNER JOIN  DEPARTAMENTO D ON D.DEPTO_ID=E.DEPTO_ID "
			+ "WHERE D.NOMBRE =:nombreDepa" ,nativeQuery = true)
	List<Productos> getDepaProductosbyName(@Param("nombreDepa") String nombreDepa);
	
//	@Query(value="SELECT * "
//			+ "FROM DEPARTAMENTO E "
//			+ "INNER JOIN PRODUCTOS D ON E.DEPTO_ID=D.DEPTO_ID" ,nativeQuery = true)
	 //@Query("SELECT * FROM Departamento d INNER JOIN d.products p")
	@Query(value="SELECT * "
			+ "FROM PRODUCTOS E "
			+ "INNER JOIN  DEPARTAMENTO D ON E.DEPTO_ID=D.DEPTO_ID" ,nativeQuery = true)
	List<Productos> getDepaProductos();
	
	
//	@Query(value="SELECT * "
//			+ "FROM PRODUCTOS E "
//			+ "INNER JOIN  DEPARTAMENTO D ON D.DEPTO_ID=E.DEPTO_ID "
//			+ "WHERE D.NOMBRE =:nombreDepa" ,nativeQuery = true)
//	List<Productos> getTupleDepaProductosbyName(@Param("nombreDepa") String nombreDepa);
	
	@Query(value="SELECT * "
			+ "FROM PRODUCTOS E "
			+ "INNER JOIN  DEPARTAMENTO D ON D.DEPTO_ID=E.DEPTO_ID",nativeQuery = true)
	List<Productos> getTupleDepaProductosbyName();
	
	
	@Query("select c.nombre,c.precio_compra from Productos c where c.nombre= ?1")
	String getNameProduct(String nombre);
	
	
	
	@Query(value="SELECT E.NOMBRE,D.NOMBRE_DEPA,E.FECHA_CAD,E.REFRIGERADO,E.PRECIO_COMPRA "
			+ "FROM PRODUCTOS E "
			+ "INNER JOIN  DEPARTAMENTO D ON D.DEPTO_ID=E.DEPTO_ID "
			+ "WHERE D.NOMBRE_DEPA =:nombreDepa",nativeQuery = true)
	List<Tuple> getTupleName(@Param("nombreDepa") String nombreDepa);
	
	@Query(value="SELECT E.NOMBRE,D.NOMBRE_DEPA,E.FECHA_CAD,E.REFRIGERADO,E.PRECIO_COMPRA "
			+ "FROM PRODUCTOS E "
			+ "INNER JOIN  DEPARTAMENTO D ON D.DEPTO_ID=E.DEPTO_ID",nativeQuery = true)
	List<Tuple> getTupleName2();




	
}
