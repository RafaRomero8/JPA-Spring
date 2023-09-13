package com.msproductos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.msproductos.entity.Productos;
//DAO

//ESTA INTERFAZ ES EL DAO 
//LA QUE ENGLOBA LAS CONSULTAS
@Repository//componente de acceso a datos o de algun repositorio donde vamos a extraer informacion
public interface ProductoRepository extends JpaRepository<Productos,Integer>{
	
	//JpaRepository parametrizado con 2 parametros,la entidad con la que se va a trabjar
	//y el tipo de dato del ID(PRIMARY KEY de la tabla) del producto se le pasa un Integer(no usa datso primitivos)
	
	//Con JPQL
	@Query("SELECT c FROM Productos c WHERE c.nombre LIKE %:name%")
	//Optional<CustomerEntity> findByName(@Param("name")String name);
	List<Productos> getfindNombres(@Param("name")String name);
	
	//Con SQL 
	@Query(value = "SELECT * FROM PRODUCTOS WHERE PRODUCTOS.NOMBRE LIKE %:name%",
			nativeQuery = true)
	List<Productos> getfindNombresSQL(@Param("name") String name);
	
	@Query (value="SELECT * FROM PRODUCTOS  WHERE PRODUCTOS.PRECIO_VENTA>=?1",
			 nativeQuery = true )
	List<Productos> getfindPrecioVenta(@Param("precio_venta") double precio_venta);
	
}
