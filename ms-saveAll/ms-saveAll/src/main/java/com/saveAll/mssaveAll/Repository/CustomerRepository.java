package com.saveAll.mssaveAll.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saveAll.mssaveAll.Entity.CustomerEntity;

@Repository
public interface CustomerRepository  extends JpaRepository<CustomerEntity,Integer> {

	//@Query("SELECT * FROM Customers c WHERE c.nombre like %:name%")
	@Query("SELECT c FROM CustomerEntity c WHERE c.nombre LIKE %:name%")
	//Optional<CustomerEntity> findByName(@Param("name")String name);
	List<CustomerEntity> getfindNombres(@Param("name")String name);
	
	
}
