package com.gyl.CrudGyl.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tipoProducto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoProducto
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "tipoProducto")
    private List<Producto> productos = new ArrayList<>();

    @Column(nullable = false)
    private Boolean estadoTipoProducto;
}
