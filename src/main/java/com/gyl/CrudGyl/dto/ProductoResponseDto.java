package com.gyl.CrudGyl.dto;

import com.gyl.CrudGyl.entity.TipoProducto;

public record ProductoResponseDto
        (
                Long id,
                String nombre,
                Double precio,
                Integer stock,
                TipoProducto tipoProducto,
                Boolean estadoProducto
        )
{

}
