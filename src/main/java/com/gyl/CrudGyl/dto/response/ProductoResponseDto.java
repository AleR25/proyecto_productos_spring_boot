package com.gyl.CrudGyl.dto.response;

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
