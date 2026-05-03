package com.gyl.CrudGyl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.cfg.Compatibility;

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
    private long id;

    @Column(nullable = false, length = 100)
    private String fechaVenta;

    @Column(nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalleVentas = new ArrayList<>();

    @Column(nullable = false)
    private String estadoVenta;
}
