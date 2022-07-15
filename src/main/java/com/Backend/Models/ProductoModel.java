package com.Backend.Models;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@ApiModel(description = "Productos existentes.")
@Table(name="Productos")
public class ProductoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	private String precio;
	
	private String categoria;
	
	public ProductoModel() {}
	
	public ProductoModel(String nombre, String precio, String categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

}
