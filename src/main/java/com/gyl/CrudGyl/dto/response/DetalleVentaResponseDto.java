package com.gyl.CrudGyl.dto.response;

import java.math.BigDecimal;

public record DetalleVentaResponseDto
        (
                Long id,
                int cantidad,
                BigDecimal precioUnitario,
                BigDecimal subtotal,
                String nombreProducto
        )
{

}
