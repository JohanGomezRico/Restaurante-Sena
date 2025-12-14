package com.restaurante.modulo_restaurante_back.repository;

import com.restaurante.modulo_restaurante_back.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
