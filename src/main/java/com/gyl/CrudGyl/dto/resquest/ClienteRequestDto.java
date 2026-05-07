package com.gyl.CrudGyl.dto.resquest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ClienteRequestDto
        (
                @NotBlank(message =  "El nombre no puede ser vacío")
                String nombre,

                @NotBlank(message = "El apellido no puede ser vacío")
                String apellido,

                @Email
                String correo,

                @NotBlank(message = "El telefono no puede ser vacío")
                String telefono,

                @NotBlank(message = "La dirección no puede ser vacía")
                String direccion
        )
{

}
