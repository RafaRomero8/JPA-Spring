package com.msproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication //a veces se edita esta notacion
public class MsProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProductosApplication.class, args);
		
	}
	
	@Bean
	public ModelMapper ModelMapper(){
		
		return  new ModelMapper();
	}

}
//capa 1 el mapeode la entidad