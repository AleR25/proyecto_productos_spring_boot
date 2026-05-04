package com.gyl.CrudGyl.dto.Response;

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
