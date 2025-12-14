package com.restaurante.modulo_restaurante_back.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearDetallePedidoRequestDTO {

    @NotNull
    private Long idProducto;

    @NotNull
    @Positive
    private Integer cantidad;

    private String observaciones;
}
