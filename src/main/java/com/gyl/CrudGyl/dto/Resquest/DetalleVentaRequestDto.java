package com.gyl.CrudGyl.dto.Resquest;

import jakarta.validation.constraints.NotNull;

public record DetalleVentaRequestDto
        (
                @NotNull(message = "La cantidad de productos es obligatoria")
                int cantidad,

                @NotNull(message = "El ID del Detalle de Venta es obligatorio")
                Long producto
        )
{

}
