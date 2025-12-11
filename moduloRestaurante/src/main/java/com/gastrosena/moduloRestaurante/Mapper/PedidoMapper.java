package com.gastrosena.moduloRestaurante.Mapper;

import com.gastrosena.moduloRestaurante.Entity.Pedido;
import com.gastrosena.moduloRestaurante.dto.PedidoRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
	public Pedido fromDTO(PedidoRequestDTO dto) {

        Pedido pedido = new Pedido();

        pedido.setIdMesa(dto.getIdMesa());
        pedido.setIdMesero(dto.getIdMesero());
        pedido.setCliente(dto.getCliente());
        pedido.setEstado(dto.getEstado().name());
        pedido.setTotalFinal(dto.getTotalFinal());
        pedido.setObservaciones(dto.getObservaciones());

        return pedido;
    }
}
