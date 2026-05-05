package com.gyl.CrudGyl.dto.Resquest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductoRequestDto
        (
            @NotBlank(message = "El nombre no puede ser vacio")
            String nombre,

            @NotNull(message = "El precio es obligatorio")
            @Positive(message = "El precio debe ser mayor a Cero")
            BigDecimal precio,

            @NotNull(message = "El Stock es obligatorio")
            @Min(value=0, message = "El stock no puede ser negativo")
            Integer stock,

            @NotNull(message = "El ID de tipo producto es obligatotio")
            Long tipoProductoId,

            @NotNull(message = "El producto tiene que estar activo o no")
            Boolean estadoProducto
        )
{

}