package com.gastrosena.moduloRestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastrosena.moduloRestaurante.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
