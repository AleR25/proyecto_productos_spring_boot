package com.gyl.CrudGyl.dto.Response;

import com.gyl.CrudGyl.entity.Cliente;
import com.gyl.CrudGyl.entity.DetalleVenta;

import java.time.LocalDate;
import java.util.List;

public record VentaResponseDto
        (
                Long id,
                LocalDate fechaVenta,
                Double total,
                Cliente cliente,
                List<DetalleVenta> detalleVentas,
                String estadoVenta
        )
{

}
