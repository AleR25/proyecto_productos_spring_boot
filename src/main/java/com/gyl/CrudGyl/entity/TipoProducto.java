package com.gyl.CrudGyl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="tipo_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoProducto
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTipoProducto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "idProducto")
    private List<Producto> productos;

    @Column(nullable = false)
    private Boolean estadoTipoProducto;
}
