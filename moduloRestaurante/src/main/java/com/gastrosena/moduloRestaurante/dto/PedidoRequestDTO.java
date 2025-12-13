package com.gastrosena.moduloRestaurante.dto;

import com.gastrosena.moduloRestaurante.entity.EstadoPedido;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoRequestDTO {

    private String idMesa;
    private String idMesero;
    private EstadoPedido estado;
    private String observaciones;

    private List<DetallePedidoRequestDTO> detalles;
}
