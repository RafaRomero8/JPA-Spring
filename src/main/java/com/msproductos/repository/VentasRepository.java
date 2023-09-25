package com.msproductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.msproductos.entity.Ventas;

public interface VentasRepository  extends CrudRepository<Ventas,Integer>{

}
