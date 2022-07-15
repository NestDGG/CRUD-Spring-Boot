package com.Backend.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import com.Backend.Models.ProductoModel;
import com.Backend.Services.ProductosServices;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductosController {
	
	@Autowired
	ProductosServices productoServices;
	
	@ApiOperation(value = "Listar todos los productos.")
	@GetMapping("/productos")
	public List<ProductoModel> obtenerProductos(){
		return productoServices.todosLosProductos();
	}
	
	@ApiOperation(value = "Buscar producto por ID.")
	@GetMapping("/productos/{id}")
	public Optional<ProductoModel> obtenerProductoPorId(@PathVariable long id) {
		return productoServices.obtenerPorId(id);
	}
	
	@ApiOperation(value = "Agregar un nuevo producto a la lista.")
	@PostMapping("/productos")
	public ProductoModel nuevoProducto(@RequestBody ProductoModel nuevo) {
		return productoServices.nuevoProducto(nuevo);
	}
	
	@ApiOperation(value = "Actualizar la informacion de un producto.")
	@PutMapping("/productos/{id}")
	public ProductoModel actualizarProducto(@RequestBody ProductoModel producto, @PathVariable long id) throws NotFoundException {
		return productoServices.actualizarProducto(id, producto);
	}
	
	@ApiOperation(value = "Eliminar un producto de la lista.")
	@DeleteMapping("/productos/{id}")
	public void borrarProducto(@PathVariable long id) {
		productoServices.eliminarProducto(id);
	}
	
	
}
