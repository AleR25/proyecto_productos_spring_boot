package com.gyl.CrudGyl.dto.Resquest;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record VentaRequestDto
        (
                @NotBlank(message = "La fecha de venta tiene que ser obligatoria")
                LocalDate fechaVenta,
                long clienteId,
                String estadoVenta,
                List<DetalleVentaRequestDto> detalles
        )
{

}
