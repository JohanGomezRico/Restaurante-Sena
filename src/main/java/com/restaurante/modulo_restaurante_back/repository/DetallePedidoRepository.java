package com.restaurante.modulo_restaurante_back.repository;

import com.restaurante.modulo_restaurante_back.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}

