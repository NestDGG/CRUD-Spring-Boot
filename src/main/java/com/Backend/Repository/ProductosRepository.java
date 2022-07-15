package com.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.Models.ProductoModel;

public interface ProductosRepository extends JpaRepository<ProductoModel, Long> {

}
