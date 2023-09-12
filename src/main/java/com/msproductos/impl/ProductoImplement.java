package com.msproductos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msproductos.entity.Productos;
import com.msproductos.exception.BussinesException;
import com.msproductos.exception.ResourceNotFoundException;
import com.msproductos.generic.ProductoGeneric;
import com.msproductos.repository.DepartamentoRepository;
import com.msproductos.repository.ProductoRepository;
import com.msproductos.request.ProductosRequest;
import com.msproductos.service.ProductoService;

//SEGUNDA CAPA
@Service // lo utilizamos cuando hay logica de programacion implicada,LOGICA DE NEGOCIO
//por ejemplo  validacion de algun  credito,edad
public class ProductoImplement implements ProductoService {

	// Inyeccion de dependencias(no son las dependencias del pom)
	// decide en que momento instanciar el objeto
	// va hacia la capa 5,solo cuandose necesite

	// Inyeccion de dependencias
	@Autowired // trae el componente hasta que lo necesite
	ProductoRepository repo;// el que sabe como hacer la operacion de delte,guardar etc..
	
	@Autowired
	DepartamentoRepository dRepo;
	// cuantos tipos de inyecciones(formas) de dependencias hay?
	// hay 3
	// mediante atributo,
	// mediante setter,
	// por constructor

	// YA NO TENEMOS QUE HACER consultas nativas de sql
	
	public void validation(ProductosRequest request, Productos p) {
		// validar que el depto exista
		if (!dRepo.findById(request.getDeptoID()).isPresent()) {
			System.out.println("El depa no existe");
			throw new ResourceNotFoundException("El depa no existe");
		} else if (!(request.getRefrigerado().equals("1") || request.getRefrigerado().equals("0"))) {

			System.out.println("Refrigerado solo puede ser 1 o 0");
			throw new ResourceNotFoundException("Refrigerado solo puede ser 1 o 0");
		} else {
			// vamos poniendo los geters los valor al objeto vacio(productos)
			p.setNombre(request.getNombre());
			p.setDeptoID(request.getDeptoID());
			p.setFecha_cad(request.getFecha_cad());
			p.setPrecio_compra(request.getPrecio_compra());
			p.setPrecio_venta(request.getPrecio_venta());
			p.setRefrigerado(request.getRefrigerado());

			repo.save(p);// necesita una entidad de argumento
		}
		
	}

	@Override
	public Productos guardar(ProductosRequest request) {// mediante atributo es el tipo de inyeccion que estamos
														// utilizando

		// ProductosRequest
		Productos p = new Productos();// Objeto vacio
   // System.out.println("MIRAR AQUI>>>>>>>>>>"+request.getDeptoID());
		// VALIDACIONES PROPIAS DEL NEGOCIO
		validation(request,p);
                
		return p;
	}
	
	@Override
	public ProductoGeneric save(ProductosRequest request) {
		System.out.println("checar aqui>>>>>>");
		ProductoGeneric c= new ProductoGeneric(); 
		repo.saveAll(request.getLisProductos());
		return c;
	}
	
	
	
	@Override
	public Productos actualizar(ProductosRequest request) {

		
		//
		if(!repo.findById(request.getProductoId()).isPresent()) {
			throw new ResourceNotFoundException("El Id producto no existe");
			
		}
		
		Productos p = repo.findById(request.getProductoId()).get();// con este metodo va a la BD a buscar el id
		// opcional ,regresa un objeto opcional,si existe lo trae
		
//		if (!repo.findById(request.getProductoId()).isPresent()) {
//			System.out.println("El Id producto no existe");
//			throw new ResourceNotFoundException("El Id producto no existe");
//		}
		
			//validation(request,p);
//		if (!(request.getRefrigerado().equals("1") || request.getRefrigerado().equals("0"))) {
//			throw new ResourceNotFoundException("Refrigerado solo puede ser 1 o 0");
//			
//		}else {
//			p.setNombre(request.getNombre());
//			p.setDeptoID(request.getDeptoID());
//			p.setFecha_cad(request.getFecha_cad());
//			p.setPrecio_compra(request.getPrecio_compra());
//			p.setPrecio_venta(request.getPrecio_venta());
//			p.setRefrigerado(request.getRefrigerado());
//
//			repo.save(p);// necesita una entidad de argumento
//		}
//	
		validation(request,p);
		return p;

	}

	@Override
	public Productos buscar(int id) {
		
		if(!repo.findById(id).isPresent()) {
			throw new BussinesException("No existe el id");
		}
		
		return repo.findById(id).get();
	}

//	@Override
//	public Productos buscar(String nombre) {
//
//		return null;
//	}
	
	@Override
	public List<Productos> buscar(String nombre) {
		List<Productos> c = null;
			c=repo.getfindNombres(nombre);
			return c;
		
	}

	@Override
	public String eliminar(int id) {
		
		if(!repo.findById(id).isPresent()) {
			throw new BussinesException("No existe el id a eliminar");
		}
		
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List mostrar() {

		return repo.findAll();
	}

}
