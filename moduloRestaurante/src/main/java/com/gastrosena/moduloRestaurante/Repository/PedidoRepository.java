package com.gastrosena.moduloRestaurante.Repository;

import com.gastrosena.moduloRestaurante.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
