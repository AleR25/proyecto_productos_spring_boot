package com.gyl.CrudGyl.dto.Response;

import com.gyl.CrudGyl.entity.Producto;
import com.gyl.CrudGyl.entity.Venta;

public record DetalleVentaResponseDto
        (
                Long id,
                int cantidad,
                double precioUnitario,
                Double subtotal,
                Venta venta,
                Producto producto
        )
{

}
