package com.gastrosena.moduloRestaurante.Mapper;

import com.gastrosena.moduloRestaurante.Entity.DetallePedido;
import com.gastrosena.moduloRestaurante.Entity.Pedido;
import com.gastrosena.moduloRestaurante.Entity.Producto;
import com.gastrosena.moduloRestaurante.dto.PlatoDTO;
import org.springframework.stereotype.Component;

@Component
public class DetallePedidoMapper {
	public DetallePedido fromPlatoDTO(
            PlatoDTO dto,
            Producto producto,
            Pedido pedido
    ) {
        DetallePedido detalle = new DetallePedido();

        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioCongelado(producto.getPrecioActual());
        detalle.setProducto(producto);
        detalle.setPedido(pedido);

        return detalle;
    }
}
