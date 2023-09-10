package com.msproductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msproductos.entity.Productos;
//DAO

//ESTA INTERFAZ ES EL DAO 
//LA QUE ENGLOBA LAS CONSULTAS
@Repository//componente de acceso a datos o de algun repositorio donde vamos a extraer informacion
public interface ProductoRepository extends JpaRepository<Productos,Integer>{
	
	//JpaRepository parametrizado con 2 parametros,la entidad con la que se va a trabjar
	//y el tipo de dato del ID(PRIMARY KEY de la tabla) del producto se le pasa un Integer(no usa datso primitivos)

}
