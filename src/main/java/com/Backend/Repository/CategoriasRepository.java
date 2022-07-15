package com.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.Models.CategoriaModel;

public interface CategoriasRepository extends JpaRepository<CategoriaModel, Long> {

}
