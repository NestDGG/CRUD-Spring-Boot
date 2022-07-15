package com.Backend.Models;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@ApiModel(description = "Categorias de productos")
@Table(name = "Categorias")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String tipo;
	
	private String descripcion;
	

	public CategoriaModel() {}
	
	public CategoriaModel(String tipo, String descripcion) {
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	
}
