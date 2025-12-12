package com.gastrosena.moduloRestaurante.Mapper;

import com.gastrosena.moduloRestaurante.DTO.PedidoRequestDTO;
import com.gastrosena.moduloRestaurante.DTO.PlatoDTO;
import com.gastrosena.moduloRestaurante.Entity.DetallePedido;
import com.gastrosena.moduloRestaurante.Entity.Pedido;
import com.gastrosena.moduloRestaurante.Entity.Producto;
import com.gastrosena.moduloRestaurante.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PedidoMapper {

    @Autowired
    private ProductoRepository productoRepository; //AQUI BUSCARA LOS PRECIOS Y NOMBRES REALES
    @Autowired
    private DetallePedidoMapper detalleMapper;
    public Pedido fromDTO(PedidoRequestDTO dto) {
        Pedido pedido = new Pedido();

        // 1. Mapeo de datos básicos (Cabecera)
        pedido.setIdMesa(dto.getIdMesa());
        pedido.setIdMesero(dto.getIdMesero());
        pedido.setCliente(dto.getCliente());
        pedido.setObservaciones(dto.getObservaciones());


        if(dto.getEstado() != null) {
            pedido.setEstado(dto.getEstado());
        }

        // AQUI ESTARA LA LÓGICA FUERTE: Convertir la lista de DTOs a Entidades
        BigDecimal totalCalculado = BigDecimal.ZERO; // Vamos a calcular el total real

        if (dto.getPlatos() != null) {
            for (PlatoDTO platoDto : dto.getPlatos()) {
                DetallePedido detalle = new DetallePedido();

                // 1. Cantidad y Observaciones
                detalle.setCantidad(platoDto.getCantidad());


                // 2. Buscar el PRODUCTO REAL en la BD (Vital para el precio)
                Producto productoReal = productoRepository.findById(platoDto.getIdProducto())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + platoDto.getIdProducto()));

                detalle.setProducto(productoReal);

                // 3. CONGELAR EL PRECIO (Precio del producto * Cantidad)
                detalle.setPrecioCongelado(productoReal.getPrecioActual());


                // E. ¡AQUÍ SE USA TU MÉTODO HELPER!

                pedido.agregarDetalle(detalle);
            }
        }


        pedido.setTotalFinal(totalCalculado);

        return pedido;
    }
}