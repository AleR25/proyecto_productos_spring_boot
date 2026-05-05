package com.gyl.CrudGyl.dto.Response;

import com.gyl.CrudGyl.entity.TipoProducto;

import java.math.BigDecimal;

public record ProductoResponseDto
        (
                Long id,
                String nombre,
                BigDecimal precio,
                Integer stock,
                TipoProductoResponseDto tipoProducto,
                Boolean estadoProducto
        )
{

}
