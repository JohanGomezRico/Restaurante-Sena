package com.gastrosena.moduloRestaurante.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastrosena.moduloRestaurante.Entity.Pedido;
import com.gastrosena.moduloRestaurante.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
