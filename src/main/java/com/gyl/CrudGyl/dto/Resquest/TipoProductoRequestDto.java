package com.gyl.CrudGyl.dto.Resquest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TipoProductoRequestDto
        (
                @NotBlank(message = "El nombre no puede ser vacio")
                String nombre,

                @NotBlank(message = "La descripción no puede ser vacia")
                String descripcion,

                @NotNull(message = "El estado del tipo de producto tiene que ser activo o no activo")
                Boolean estadoTipoProducto
        )
{

}
