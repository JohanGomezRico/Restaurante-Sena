package com.gastrosena.moduloRestaurante.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class DetallePedidoResponseDTO {
    private Long idDetalle;
    private String idProducto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
