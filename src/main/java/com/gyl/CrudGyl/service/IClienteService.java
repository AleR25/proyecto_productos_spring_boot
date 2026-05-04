package com.gyl.CrudGyl.service;

import com.gyl.CrudGyl.dto.Resquest.ClienteRequestDto;
import com.gyl.CrudGyl.dto.Response.ClienteResponseDto;

import java.util.List;

public interface IClienteService
{
    ClienteResponseDto crear(ClienteRequestDto cliente);

    List<ClienteResponseDto> listar();

    ClienteResponseDto buscarPorId(Long id);

    ClienteResponseDto actualizar(Long id, ClienteRequestDto dot);

    ClienteResponseDto darDeBaja(Long id);

    List<ClienteResponseDto> busquedaNomnbre(String nombre);
}
