package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.ClienteRequestDto;
import com.gyl.CrudGyl.dto.ClienteResponseDto;
import com.gyl.CrudGyl.entity.Cliente;

public class ClienteMapper
{
    private ClienteMapper() {}

    //El estado del cliente siempre va a ser activo
    //al crearse la cuenta
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
                        cliente.getIdCliente(),
                        cliente.getNombre(),
                        cliente.getApellido(),
                        cliente.getCorreo(),
                        cliente.getTelefono(),
                        cliente.getDireccion(),
                        cliente.isEstadoCliente()
                );
    }

    //No creo que se tenga que actualizar completamente
    //el cliente, posiblemente se tenga que actualizar
    //parcialmente.
    public static void updateEntity(Cliente cliente, ClienteRequestDto dto)
    {
        cliente.setNombre(dto.nombre());
        cliente.setApellido(dto.apellido());
        cliente.setCorreo(dto.correo());
        cliente.setTelefono(dto.telefono());
        cliente.setDireccion(dto.direccion());
    }
}
