package com.gyl.CrudGyl.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DetalleVentaRequestDto
        (
                @Min(value = 1, message = "la cantidad debe ser mayor a 0")
                int cantidad,

                @NotNull(message = "El ID de producto es obligatorio")
                @Min(value = 1, message = "no se puede pasa un ID producto negativo")
                Long productoId
        )
{

}
