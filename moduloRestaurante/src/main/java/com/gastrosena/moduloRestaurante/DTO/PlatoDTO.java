package com.gastrosena.moduloRestaurante.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoDTO {
    private Long idProducto;
    private Integer cantidad;
    private String observaciones;
}
