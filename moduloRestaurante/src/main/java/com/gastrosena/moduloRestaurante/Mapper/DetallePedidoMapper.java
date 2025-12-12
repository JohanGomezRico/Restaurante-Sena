package com.gastrosena.moduloRestaurante.Mapper;

import com.gastrosena.moduloRestaurante.Entity.DetallePedido;
import com.gastrosena.moduloRestaurante.Entity.Producto;
import com.gastrosena.moduloRestaurante.DTO.PlatoDTO;
import org.springframework.stereotype.Component;

@Component
public class DetallePedidoMapper {

    public DetallePedido fromPlatoDTO(PlatoDTO dto, Producto producto) {

        DetallePedido detalle = new DetallePedido();

        // 1. Datos básicos
        detalle.setCantidad(dto.getCantidad());
        detalle.setObservaciones(dto.getObservaciones()); // ¡Faltaba esto!

        // 2. Estado inicial (Vital para que cocina sepa que es nuevo)
        detalle.setEstadoItem("REGISTRADO");

        // 3. Relación con Producto y Precio
        detalle.setProducto(producto);
        detalle.setPrecioCongelado(producto.getPrecioActual());

        return detalle;
    }
}
