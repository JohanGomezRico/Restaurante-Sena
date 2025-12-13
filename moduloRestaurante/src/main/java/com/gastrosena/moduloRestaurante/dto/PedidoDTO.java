package com.gastrosena.moduloRestaurante.dto;

import com.gastrosena.moduloRestaurante.entity.EstadoPedido;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PedidoDTO {

    //aqui vamos hacer los datos que se veran en el frontend

    private Long idPedido;
    private String idMesa;
    private String idMesero;
    private BigDecimal totalFinal;
    private EstadoPedido estado;
    private String observaciones;



}
