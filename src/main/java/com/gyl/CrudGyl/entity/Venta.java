package com.gyl.CrudGyl.entity;

import com.gyl.CrudGyl.enumP.EstadoVenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="venta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venta
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaVenta;

    @Column(nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalleVentas = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoVenta estadoVenta;
}
