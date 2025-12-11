package com.gastrosena.moduloRestaurante.DTO;

import com.gastrosena.moduloRestaurante.Entity.EstadoPedido;
import com.gastrosena.moduloRestaurante.Entity.Pedido;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoRequestDTO {

    private Long idMesa;
    private Long idMesero;
    private String cliente;
    private EstadoPedido estado;
    private String observaciones;

    private List<PlatoDTO> platos;
}
