package com.gastrosena.moduloRestaurante.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "id_mesa", nullable = false)
    private String idMesa;

    @Column (name = "id_mesero", nullable = false)
    private String idMesero;

    @Column(name = "total_final")
    private BigDecimal totalFinal = BigDecimal.ZERO;

    // este metodo sera para el swagger
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoPedido estado = EstadoPedido.REGISTRADO;

    @JsonManagedReference
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();

    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
        detalle.setPedido(this);
    }
}
