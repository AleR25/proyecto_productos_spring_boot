package com.gyl.CrudGyl.dto.response;

import jakarta.validation.constraints.NotBlank;

public record RegistroRequestDto
        (
                @NotBlank(message = "El nombre de usuario es obligatorio y no puede estar vacío")
                String username,

                @NotBlank(message = "La contraseña es obligatoria y no puede estar vacía")
                String password
        )
{

}
