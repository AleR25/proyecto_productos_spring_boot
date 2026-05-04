package com.gyl.CrudGyl.dto.Resquest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRequestDto
        (
                @NotBlank(message =  "El nombre no puede ser vacío")
                String nombre,

                @NotBlank(message = "El apellido no puede ser vacío")
                String apellido,

                @NotBlank(message = "El correo no puede ser vacío")
                String correo,

                @NotBlank(message = "El telefono no puede ser vacío")
                String telefono,

                @NotBlank(message = "La dirección no puede ser vacía")
                String direccion,

                @NotNull
                boolean estadoCliente
        )
{

}
