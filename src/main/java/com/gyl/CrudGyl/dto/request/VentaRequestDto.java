package com.gyl.CrudGyl.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record VentaRequestDto
        (
                @NotNull(message = "el ID del cliente es obligatorio")
                @Min(value = 1, message = "El ID del cliente tiene que ser positivo")
                long clienteId,

                @NotEmpty(message = "La venta debe tener por lo menos un detalle")
                List<DetalleVentaRequestDto> detalles
        )
{

}
