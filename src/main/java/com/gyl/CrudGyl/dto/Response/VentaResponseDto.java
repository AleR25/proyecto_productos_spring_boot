package com.gyl.CrudGyl.dto.Response;

import com.gyl.CrudGyl.enumP.EstadoVenta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record VentaResponseDto
        (
                Long id,
                LocalDate fechaVenta,
                BigDecimal total,
                ClienteResponseDto cliente,
                List<DetalleVentaResponseDto> detalleVentas,
                EstadoVenta estadoVenta
        )
{

}
