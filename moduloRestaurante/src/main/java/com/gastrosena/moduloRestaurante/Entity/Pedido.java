package com.gastrosena.moduloRestaurante.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "id_mesa", nullable = false)
    private Long idMesero;

    @Column (name = "cliente")
    private String cliente;

    @Column(name = "total_final")
    private BigDecimal totalFinal = BigDecimal.ZERO;

    // este metodo sera para el swagger
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoPedido estado = EstadoPedido.REGISTRADO;//AQUI ESTARA EL REGISTRADO

    @JsonManagedReference
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();

    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
        detalle.setPedido(this);
    }

    //Aqui voy a dejar el enum para los estados del pedido

    enum EstadoPedido{
        REGISTRADO,
        EN_PREPARACION,
        ENTREGADO,
        CERRADO,
        ANULADO
    }
}
