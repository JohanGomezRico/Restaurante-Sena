package com.gastrosena.moduloRestaurante.dto;

import lombok.Data;

@Data
public class DetallePedidoRequestDTO {
    private String idProducto;
    private Integer cantidad;
    private String notas;
}
