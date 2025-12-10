package com.gastrosena.moduloRestaurante.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_pedidos")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// el auto-incrementable
    @Column(name = "id_detalle")
    private Long idDetalle;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_congelado", nullable = false)
    private BigDecimal precioCongelado; // guarda el precio del momento de la venta

    @Column (name = "observaciones")
    private String observaciones;

    //relaciones

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column (name = "estado_item")
    private String estadoItem;

}
