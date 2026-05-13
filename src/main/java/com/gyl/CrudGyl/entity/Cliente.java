package com.gyl.CrudGyl.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente
{
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 50)
    private String correo;

    @Column(nullable = false, length = 50)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas = new ArrayList<>();

    private boolean estadoCliente = true;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
