package com.msproductos.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msproductos.dto.Product_DepaDTO;
import com.msproductos.dto.Product_DepaDTO2;
import com.msproductos.entity.Departamento;
import com.msproductos.entity.Productos;
import com.msproductos.exception.BussinesException;
import com.msproductos.exception.ResourceNotFoundException;
import com.msproductos.generic.ProductoGeneric;
import com.msproductos.repository.DepartamentoRepository;
import com.msproductos.repository.ProductoRepository;
import com.msproductos.request.ProductosRequest;
import com.msproductos.service.ProductoService;
import com.msproductos.util.ConvertEntityToDTO;


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
	
	@Autowired
	private ConvertEntityToDTO dtoEntity;
	
	@Autowired
	private ModelMapper modelmapper;
	
	
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

	
	@Override
	public List<Productos> search(String nombre) throws BussinesException {
		
		List<Productos> c = null;
		c=repo.getfindNombresSQL(nombre);
		return c;
		
	}
	
	@Override
	public List<Productos> precio_venta(double precio_venta) throws ResourceNotFoundException {
		
		List<Productos> c = null;
		c=repo.getfindPrecioVenta(precio_venta);
		return c;
		
	}

	@Override
	public List<Product_DepaDTO> getDepaById() throws BussinesException {
		
		List<Product_DepaDTO> list = null;
		List<Productos> productos = repo.findAll();
		list = productos.stream().map(param -> dtoEntity.convertDTO(param)).collect(Collectors.toList());
		
		//dtoEntity
		return list;
	}
	
//	@Override
//	public List<Productos> getDepaProduct(String nombre) throws BussinesException {
//		return repo.getByDepa(nombre);
//	}

	@Override
	public List<Product_DepaDTO> getDepaProduct() throws BussinesException {
		
		return repo.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	

	
//	private  Product_DepaDTO convertEntityToDto(Productos product) {
//		
//		//Departamento depa = new Departamento();
//		Product_DepaDTO productoDTO = new Product_DepaDTO();
//		
//		productoDTO.setNombre(product.getNombre());
//		productoDTO.setFecha_cad(product.getFecha_cad());
//		productoDTO.setRefrigerado(product.getRefrigerado());
//		return productoDTO;
//	}
//	
	private  Product_DepaDTO convertEntityToDto(Productos product) {
		//SIMPLIFICADO
		Product_DepaDTO productoDTO = new Product_DepaDTO();
		
		productoDTO = modelmapper.map(product,Product_DepaDTO.class);
		
	
		return productoDTO;
	}
	
	
	private  Product_DepaDTO convertEntityToDtos(Productos product,Departamento dep) {
		//SIMPLIFICADO
	//	Product_DepaDTO productoDTO = new Product_DepaDTO();
		
		//productoDTO = modelmapper.map(product,Product_DepaDTO.class);
		
		ModelMapper modelMapper = new ModelMapper();
		Product_DepaDTO dto= modelMapper.map(product,Product_DepaDTO.class);
		//This will add additional values to the dto.
		modelMapper.map(dep, dto);
		
	
		
//		ntegratorDTO dto= modelMapper.map(details, IntegratorDTO.class);
//		//This will add additional values to the dto.
//		modelMapper.map(integratorChannelDetails, dto);
		
		return dto;
	}


	
//	@Override
//	public List<Product_DepaDTO> getDepaProductos(String nombre) throws BussinesException {
//		
//		return repo.findAll().stream()
//				.map(this::convertEntityToDtos)
//				.collect(Collectors.toList());
//	}
	
//	@Override
//	public Product_DepaDTO  getDepaProductos(String nombre){
//		
//		Optional<Productos> product = repo.getDepaProductos(nombre);
//		
//		 Departamento depa = dRepo.getDepaProductos(nombre);
//		 
//		 Productos productos = product.get();
//		
//		  List<Product_DepaDTO> dto =  new Product_DepaDTO();
//		
//
//		
//		return  Product_DepaDTO;
//	
//		
//	}
	
	
//	@Override
//	public List<Product_DepaDTO> getDepaProducts() throws BussinesException {
//        final Optional<List<Productos>> productos = Optional.ofNullable(repo.getDepaProductos());
//         final Optional<List<Departamento>> departamentos = Optional.empty();
//
//        final List<Productos> p = productos.get();
//       final List<Departamento> d = departamentos.get();
//       List<Product_DepaDTO> dto = new ArrayList<Product_DepaDTO>();
//        
//       for (int i = 0; i < p.size(); i++) {
//			Product_DepaDTO pd_dto = new Product_DepaDTO();
//			pd_dto.setNombre(p.get(i).getNombre());
//			for (int j = 0; j < d.size(); j++) {
//				pd_dto.setNombreDepa(d.get(j).getNombre());
//			}
//			pd_dto.setFecha_cad(p.get(i).getFecha_cad());
//			pd_dto.setRefrigerado(p.get(i).getRefrigerado());
//	
//		}
//          
//           		
//   return dto;
//
//        	//return	new List<Product_DepaDTO>(p.getNombre(),d.getNombre(),p.getFecha_cad(),p.getRefrigerado());
//}

	
	
	@Override
	public List<Product_DepaDTO> getDepaProductos() throws BussinesException {
		
		List<Productos> p= repo.getDepaProductos();   
		List<Departamento> d= dRepo.getDepaProductos();   
		List<Product_DepaDTO> dto =  new ArrayList<>();  
       
		for (int i = 0; i < p.size(); i++) {
			//Product_DepaDTO pd_dto = new Product_DepaDTO();
			
//			pd_dto.setNombre(p.get(i).getNombre());
//			pd_dto.setFecha_cad(p.get(i).getFecha_cad());
//			pd_dto.setRefrigerado(p.get(i).getRefrigerado());
//			pd_dto.setPrecio_compra(p.get(i).getPrecio_compra());
//			for (int j = 0; j < d.size(); j++) {
//				pd_dto.setNombreDepa(d.get(j).getNombre());
//				//dto.add(pd_dto);
//			}
//			dto.add(pd_dto);
			
			Product_DepaDTO pd_dto = modelmapper.map(p.get(i),Product_DepaDTO.class);
			for (int j = 0; j < d.size(); j++) {
				pd_dto.setNombreDepa(d.get(j).getNombre());
				
			}
		
			     dto.add(pd_dto);
			    
		}
		
	
		return dto;
        

}

	
	@Override
	public List<Product_DepaDTO> getDepaProductosDTOByName(String nombreDepa) throws BussinesException {
		
		List<Productos> p= repo.getDepaProductosbyName(nombreDepa);   
		List<Departamento> d= dRepo.getDepaProductosbyName(nombreDepa);   
		List<Product_DepaDTO> dto =  new ArrayList<>();  
       
		for (int i = 0; i < p.size(); i++) {
			
			Product_DepaDTO pd_dto = new Product_DepaDTO();
			
			pd_dto.setNombre(p.get(i).getNombre());
			pd_dto.setFecha_cad(p.get(i).getFecha_cad());
			pd_dto.setRefrigerado(p.get(i).getRefrigerado());
			pd_dto.setPrecio_compra(p.get(i).getPrecio_compra());
			for (int j = 0; j < d.size(); j++) {
				pd_dto.setNombreDepa(d.get(j).getNombre());
				//dto.add(pd_dto);
			}
			dto.add(pd_dto);
	
		}
		return dto;
        

}

	


}
