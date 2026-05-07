package com.gyl.CrudGyl.service.impl;

import com.gyl.CrudGyl.dto.resquest.ClienteRequestDto;
import com.gyl.CrudGyl.dto.response.ClienteResponseDto;
import com.gyl.CrudGyl.entity.Cliente;
import com.gyl.CrudGyl.exception.RecursoNoEncontradoException;
import com.gyl.CrudGyl.mapper.ClienteMapper;
import com.gyl.CrudGyl.repository.IClienteRepositor;
import com.gyl.CrudGyl.service.interf.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicceImpl implements IClienteService
{
    private final IClienteRepositor iClienteRepositor;

    public ClienteServicceImpl(IClienteRepositor iClienteRepositor) {
        this.iClienteRepositor = iClienteRepositor;
    }

    @Override
    public ClienteResponseDto crear(ClienteRequestDto dto) {
        return ClienteMapper.toResponseDto
                (
                        iClienteRepositor.save
                                (
                                        ClienteMapper.toEntity(dto)
                                )
                );
    }

    @Override
    public List<ClienteResponseDto> listar() {
        return iClienteRepositor.findAll()
                .stream()
                .map(ClienteMapper::toResponseDto)
                .toList();
    }

    @Override
    public ClienteResponseDto buscarPorId(Long id) {
        return iClienteRepositor.findById(id)
                .map(ClienteMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException
                        (
                                "No se encontró el ID " + id
                        ));
    }

    @Override
    public ClienteResponseDto actualizar(Long id, ClienteRequestDto dto) {
        Cliente cliente = iClienteRepositor.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException
                        (
                                "No se encontró el ID " + id
                        ));
        ClienteMapper.updateEntity(cliente, dto);
        Cliente guardado = iClienteRepositor.save(cliente);
        return ClienteMapper.toResponseDto(guardado);
    }

    @Override
    public ClienteResponseDto darDeBaja(Long id) {
        return null;
    }

    @Override
    public List<ClienteResponseDto> busquedaNomnbre(String nombre) {
        return iClienteRepositor.findByNombre(nombre)
                .stream()
                .map(ClienteMapper::toResponseDto)
                .toList();
    }
}
