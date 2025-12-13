package com.gastrosena.moduloRestaurante.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
@Data
public class PedidoResponseDTO {
    private Long idPedido;
    private String idMesa;
    private String idMesero;
    private BigDecimal totalFinal;
    private String estado;

    private List<DetallePedidoResponseDTO> detalles;


}
