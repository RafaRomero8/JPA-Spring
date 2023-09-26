package com.msproductos.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msproductos.dto.Product_DepaDTO;
import com.msproductos.entity.Productos;

@Component("convertEntityToDTO")
public class ConvertEntityToDTO {
	
	@Autowired
	private ModelMapper modelMapper;//para mapear el DTO
	
	public Product_DepaDTO convertDTO(Productos productos) {
		
		Product_DepaDTO productoDto = null;
		if(productos != null) {
			productoDto = modelMapper.map(productos,Product_DepaDTO.class);
		}
		
		return productoDto;
		
	}
	

}
