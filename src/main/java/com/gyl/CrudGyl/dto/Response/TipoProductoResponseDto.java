package com.gyl.CrudGyl.dto.Response;

public record TipoProductoResponseDto
        (
                Long id,
                String nombre,
                String descripcion,
                Boolean estadoTipoProducto
        )
{

}
