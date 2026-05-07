package com.gyl.CrudGyl.dto.response;

public record ClienteResponseDto
        (
                long id,
                String nombre,
                String apellido,
                String correo,
                String telefono,
                String direccion,
                boolean estadoCliente
        )
{

}
