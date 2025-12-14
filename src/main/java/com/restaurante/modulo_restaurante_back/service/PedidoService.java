package com.restaurante.modulo_restaurante_back.service;

import com.restaurante.modulo_restaurante_back.model.EstadoPedido;
import com.restaurante.modulo_restaurante_back.model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido crearPedido(Pedido pedido);

    Pedido obtenerPedidoPorId(Long idPedido);

    List<Pedido> listarPedidos();

    Pedido cambiarEstado(Long idPedido, EstadoPedido nuevoEstado);

    Pedido cancelarPedido(Long idPedido);
}
