package com.Backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.Backend.Models.CategoriaModel;
import com.Backend.Repository.CategoriasRepository;

@Service
public class CategoriasServices {
	
	@Autowired
	CategoriasRepository repository;
	
	public List<CategoriaModel> todasLasCategorias(){
		return repository.findAll();
	}
	
	public Optional<CategoriaModel> obtenerPorId(long id) {
		return repository.findById(id);
	}
	
	public CategoriaModel nuevaCategoria(CategoriaModel nuevaCategoria) {
		return repository.save(nuevaCategoria);
	}
	
	public CategoriaModel actualizarCategoria ( Long id,  CategoriaModel nueva ) throws NotFoundException{
		
		/*CategoriaModel actual = repository.findById(id).orElseThrow(() -> new NotFoundException());
		
		actual.setTipo(nueva.getTipo());
		actual.setDescripcion(nueva.getDescripcion());
	
		return repository.save(actual);*/
		return repository.save(nueva);
			
	}
	
	public void eliminarCategoria(Long id) {
		repository.deleteById(id);
	}

}
