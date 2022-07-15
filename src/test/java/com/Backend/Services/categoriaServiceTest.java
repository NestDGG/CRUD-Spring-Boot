package com.Backend.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Backend.Models.CategoriaModel;
import com.Backend.Repository.CategoriasRepository;

public class categoriaServiceTest {
	
	@Mock
	CategoriasRepository repository;
	
	@InjectMocks
	private CategoriasServices categoriasServices;
	
	
	private CategoriaModel cat1;
	private CategoriaModel cat2;
	private List<CategoriaModel> categoriasList = new ArrayList<CategoriaModel>();
	
	
	
	@BeforeEach
	void setUp() {
		
		MockitoAnnotations.initMocks(this);
		
		//primera categoria
		cat1 = new CategoriaModel();
		cat1.setId(1);
		cat1.setTipo("TD");
		cat1.setDescripcion("Tarjeta de debito");
		//Segunda categoria
		cat2 = new CategoriaModel();
		cat2.setId(2);
		cat2.setTipo("TC");
		cat2.setDescripcion("Tarjeta de credito");
		
		categoriasList.add(cat1);
		categoriasList.add(cat2);
				
	}
	
	
	@Test
	void todasLasCategorias() {
		when(repository.findAll()).thenReturn(categoriasList);
		assertNotNull(categoriasServices.todasLasCategorias());
	}


	@Test
	void obtenerPorId() {
		when(repository.getOne((long)1)).thenReturn(cat1);
		assertNotNull(categoriasServices.obtenerPorId(1));
	}
		
	@Test
	void nuevaCategoria() {
		when(repository.save(any(CategoriaModel.class))).thenReturn(cat1);
		assertNotNull(categoriasServices.nuevaCategoria(cat1));
	}

	
	@Test
	void actualizarCAtegoria() {
		when(repository.save(any(CategoriaModel.class))).thenReturn(cat2);
		assertNotNull(categoriasServices.nuevaCategoria(cat2));
	}
	
	@Test
	void eliminarCategoria() {
		categoriasServices.eliminarCategoria(cat1.getId());
		verify(repository, times(1)).deleteById(cat1.getId());
	}

}


