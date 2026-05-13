package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.resquest.ClienteRequestDto;
import com.gyl.CrudGyl.dto.response.ClienteResponseDto;
import com.gyl.CrudGyl.entity.Cliente;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteMapper
{
    public static Cliente toEntity(ClienteRequestDto dto)
    {
        Cliente cliente = new Cliente();

        cliente.setNombre(dto.nombre());
        cliente.setApellido(dto.apellido());
        cliente.setCorreo(dto.correo());
        cliente.setTelefono(dto.telefono());
        cliente.setDireccion(dto.direccion());
        cliente.setEstadoCliente(true);

        return cliente;
    }

    public static ClienteResponseDto toResponseDto(Cliente cliente)
    {
        return new ClienteResponseDto
                (
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getApellido(),
                        cliente.getCorreo(),
                        cliente.getTelefono(),
                        cliente.getDireccion(),
                        cliente.isEstadoCliente()
                );
    }

    public static void updateEntity(Cliente cliente, ClienteRequestDto dto)
    {
        cliente.setNombre(dto.nombre());
        cliente.setApellido(dto.apellido());
        cliente.setCorreo(dto.correo());
        cliente.setTelefono(dto.telefono());
        cliente.setDireccion(dto.direccion());
    }
}
