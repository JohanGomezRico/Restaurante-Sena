package com.gastrosena.moduloRestaurante.mapper;

import com.gastrosena.moduloRestaurante.dto.*;
import com.gastrosena.moduloRestaurante.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    // 1. Convertir de DTO (Request) a Entidad
    public Pedido toEntity(PedidoRequestDTO dto) {
        if (dto == null) return null;

        Pedido pedido = Pedido.builder()
                .idMesa(dto.getIdMesa())
                .idMesero(dto.getIdMesero())
                // .totalFinal() -> No se mapea aquí, se calcula en el servicio
                // .estado() -> Toma el valor por defecto de la entidad
                .build();

        // Mapeamos los detalles (Aquí usamos tu método agregarDetalle)
        if (dto.getDetalles() != null) {
            for (DetallePedidoRequestDTO detalleDto : dto.getDetalles()) {
                DetallePedido detalle = new DetallePedido();
                Producto producto = new Producto();
                producto.setIdProducto(Long.valueOf(detalleDto.getIdProducto())); // Asigna el ID del string al objeto
                detalle.setProducto(producto);
                detalle.setCantidad(detalleDto.getCantidad());
                pedido.agregarDetalle(detalle);
            }
        }

        return pedido;
    }

    // 2. Convertir de Entidad a DTO (Response)
    public PedidoResponseDTO toResponseDto(Pedido entity) {
        if (entity == null) return null;

        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setIdPedido(entity.getIdPedido());
        dto.setIdMesa(entity.getIdMesa());
        dto.setIdMesero(entity.getIdMesero());
        dto.setTotalFinal(entity.getTotalFinal());
        dto.setEstado(entity.getEstado().toString());

        // Convertir la lista de detalles de entidad a detalles de DTO
        if (entity.getDetalles() != null) {
            List<DetallePedidoResponseDTO> detallesDto = entity.getDetalles().stream()
                    .map(this::toDetalleResponseDto)
                    .collect(Collectors.toList());

            dto.setDetalles(detallesDto);
        }

        return dto;
    }

    // Método auxiliar para convertir un solo detalle a DTO
    private DetallePedidoResponseDTO toDetalleResponseDto(DetallePedido entity) {
        DetallePedidoResponseDTO dto = new DetallePedidoResponseDTO();
        dto.setIdDetalle(entity.getIdDetalle());

        // Navegamos al objeto producto para sacar el ID
        if (entity.getProducto() != null) {
            dto.setIdProducto(String.valueOf(entity.getProducto().getIdProducto()));
        }
        dto.setCantidad(entity.getCantidad());
        return dto;
    }
}