package com.Backend.Services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.Backend.Models.ProductoModel;
import com.Backend.Repository.ProductosRepository;

@Service
public class ProductosServices {
	
	
	@Autowired
	private ProductosRepository repository;
	
	
	
	public List<ProductoModel> todosLosProductos(){
		return repository.findAll();
	}
	
	
	public Optional<ProductoModel> obtenerPorId(long id) {
		return repository.findById(id);
	}
	
	
	public ProductoModel nuevoProducto( ProductoModel producto) {
		return repository.save(producto);
	}
	
	public ProductoModel actualizarProducto(long id, ProductoModel nuevo) throws NotFoundException{
		
		
	/*ProductoModel actual = repository.findById(id).orElseThrow(() -> new NotFoundException());
		
		actual.setNombre(nuevo.getNombre());
		actual.setPrecio(nuevo.getPrecio());
		actual.setCategoria(nuevo.getCategoria());
		
		return repository.save(actual);*/
		
		return repository.save(nuevo);
		
	}

	public void eliminarProducto(long id) {
		repository.deleteById(id);
	}	
}
