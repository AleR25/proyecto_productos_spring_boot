package com.gyl.CrudGyl.dto;

public record ClienteResponseDto
        (
                long idCliente,
                String nombre,
                String apellido,
                String correo,
                String telefono,
                String direccion,
                boolean estadoCliente
        )
{

}
