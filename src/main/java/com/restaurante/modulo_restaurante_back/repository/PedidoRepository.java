package com.restaurante.modulo_restaurante_back.repository;

import com.restaurante.modulo_restaurante_back.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Métodos personalizados se agregan SOLO si el Service lo necesita
}
