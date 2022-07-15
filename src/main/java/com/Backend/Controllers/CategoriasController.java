package com.Backend.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Models.CategoriaModel;
import com.Backend.Services.CategoriasServices;

import io.swagger.annotations.ApiOperation;

@RestController
public class CategoriasController {
	
	@Autowired
	CategoriasServices categoriasServices;
	
	@ApiOperation(value = "Listar todas las categorias.")
	@GetMapping("/categorias")
	public List<CategoriaModel> todasLasCategorias(){
		return categoriasServices.todasLasCategorias();
	}
	
	@ApiOperation(value = "Buscar categoria por ID.")
	@GetMapping("/categorias/{id}")
	public Optional<CategoriaModel> obtenerCategoriaPorId(@PathVariable long id) {
		return categoriasServices.obtenerPorId(id);
	}
	
	@ApiOperation(value = "Agregar una nueva categoria a la lista.")
	@PostMapping("/categorias")
	public CategoriaModel nuevaCategoria(@RequestBody CategoriaModel categoria) {
		return categoriasServices.nuevaCategoria(categoria);
	}
	
	@ApiOperation(value = "Actualizar la informacion de una categoria.")
	@PutMapping("/categorias/{id}")
	public CategoriaModel actualizarCategoria(@RequestBody CategoriaModel categoria, @PathVariable long id) throws NotFoundException {
		return categoriasServices.actualizarCategoria(id, categoria);
	}
	
	@ApiOperation(value = "Eliminar una categoria por ID.")
	@DeleteMapping("/categorias/{id}")
	public void borrarCategoria(@PathVariable long id) {
		categoriasServices.eliminarCategoria(id);
	}

}
