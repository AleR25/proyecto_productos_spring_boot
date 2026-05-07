package com.gyl.CrudGyl.dto.resquest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DetalleVentaRequestDto
        (
                @Min(value = 1, message = "la cantidad debe ser mayor a 0")
                int cantidad,

                @NotNull(message = "El ID de producto es obligatorio")
                Long productoId
        )
{

}
