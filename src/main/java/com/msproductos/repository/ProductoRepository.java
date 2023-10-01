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
	

	@Query(value="SELECT * "
			+ "FROM DEPARTAMENTO E "
			+ "INNER JOIN PRODUCTOS D ON E.DEPTO_ID=D.DEPTO_ID "
			+ "WHERE E.NOMBRE =:nombreDepa" ,nativeQuery = true)
	List<Productos> getDepaProductosbyName(String nombreDepa);
	
	@Query(value="SELECT * "
			+ "FROM DEPARTAMENTO E "
			+ "INNER JOIN PRODUCTOS D ON E.DEPTO_ID=D.DEPTO_ID" ,nativeQuery = true)
	List<Productos> getDepaProductos();
	
	
//	@Query("FROM Productos  WHERE depa.nombre = :nombre")
//	   List<Productos> getfindDepartamento(@Param("nombre")String nombre);
//	

//@Query(value="SELECT p.nombre,p.\r\n" + 
//					"FROM Productos p\r\n" + 
//					"INNER JOIN p.depa d\r\n" +
//					"WHERE d.nombre = :nombre")
//	   List<Productos> getfindDepartamento(@Param("nombre")String nombre);
//	
	
//@Query(value="SELECT p FROM Product_DepaDTO WHERE nombre =:nombre ")
//List<Product_DepaDTO> getfindDepartamento(@Param("nombre")String nombre);

//	@Query(
//			
//			value="SELECT PRODUCTOS0_.NOMBRE AS nombre1_1_,PRODUCTOS0_.FECHA_CAD AS fecha_cad2_1_,PRODUCTOS0_.REFRIGERADO AS refrigerado3_1_ FROM PRODUCTOS PRODUCTOS0_ INNER JOIN DEPARTAMENTO DEPA1_ ON PRODUCTOS0_.DEPTO_ID=DEPA1_.DEPTO_ID WHERE DEPA1_.NOMBRE  = (?1)",
//			nativeQuery = true)
//	   List<Productos> getfindDepartamento(@Param("nombre")String nombre);
	
}
