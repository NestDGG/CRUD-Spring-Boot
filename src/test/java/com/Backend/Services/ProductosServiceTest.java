package com.Backend.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.Backend.Models.ProductoModel;
import com.Backend.Repository.ProductosRepository;

public class ProductosServiceTest {
	
	@Mock
	 private ProductosRepository repository;
	
	@InjectMocks
	private ProductosServices productosServices; 
	
	
	private ProductoModel producto1;
	private ProductoModel producto2;
	private List<ProductoModel> productosList =  new ArrayList<ProductoModel>();
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
		//primer producto
		producto1 = new ProductoModel();
		producto1.setId(1);
		producto1.setNombre("Tarjeta Naranja");
		producto1.setCategoria("TC");
		producto1.setPrecio("Sin anualidad");
		
		//segundo producto
		producto2 = new ProductoModel();
		producto2.setId(2);
		producto2.setNombre("Tarjeta Platinum");
		producto2.setCategoria("TD");
		producto2.setPrecio("Sin anualidad");
		
		productosList.add(producto1);
		productosList.add(producto2);
		
	}
	
	@Test
	void  todosLosProductos() {
		when(repository.findAll()).thenReturn(productosList);
		assertNotNull(productosServices.todosLosProductos());
		
	}
	
	@Test
	void obtenerPorId() {
		when(repository.getOne((long)2)).thenReturn(producto2);
		assertNotNull(productosServices.obtenerPorId(2));
	}
	
	@Test
	void nuevoProducto() {
		when(repository.save(any(ProductoModel.class))).thenReturn(producto1);
		assertNotNull(productosServices.nuevoProducto(producto1));
	}
	
	
	@Test
	void actualizarProducto() throws NotFoundException {
		when(repository.save(any(ProductoModel.class))).thenReturn(producto1);
		assertNotNull(productosServices.nuevoProducto(producto1));
	}
	
	
	@Test
	void eliminarProducto() {
		productosServices.eliminarProducto(producto1.getId());
		verify(repository, times(1)).deleteById(producto1.getId());;
	}
	
	
	
	
	
	
	
	
	
	
	

}
