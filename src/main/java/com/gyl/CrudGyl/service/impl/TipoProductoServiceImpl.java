package com.gyl.CrudGyl.service.impl;

import com.gyl.CrudGyl.dto.resquest.TipoProductoRequestDto;
import com.gyl.CrudGyl.dto.response.TipoProductoResponseDto;
import com.gyl.CrudGyl.entity.TipoProducto;
import com.gyl.CrudGyl.exception.RecursoNoEncontradoException;
import com.gyl.CrudGyl.mapper.TipoProductoMapper;
import com.gyl.CrudGyl.repository.ITipoProductoRepositor;
import com.gyl.CrudGyl.service.interf.ITipoProductoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService
{
    private final ITipoProductoRepositor iTipoProductoRepositor;

    public TipoProductoServiceImpl(ITipoProductoRepositor iTipoProductoRepositor)
    {
        this.iTipoProductoRepositor = iTipoProductoRepositor;
    }

    public TipoProducto buscarPorId(Long id) {
        return iTipoProductoRepositor.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El tipo de producto con ID " + id + " no existe."));
    }

    @Override
    public TipoProductoResponseDto buscarPorIdTipo(Long id) {
        return TipoProductoMapper.toResponseDto(buscarPorId(id));
    }

    @Override
    public TipoProductoResponseDto crear(TipoProductoRequestDto dto)
    {
        return TipoProductoMapper.toResponseDto
                (
                        iTipoProductoRepositor.save
                                (
                                        TipoProductoMapper.toEntity(dto)
                                )
                );
    }

    @Override
    public List<TipoProductoResponseDto> listar() {
        return iTipoProductoRepositor.findAll()
                .stream()
                .map(TipoProductoMapper::toResponseDto)
                .toList();
    }

    @Override
    public TipoProductoResponseDto actualizar(Long id, TipoProductoRequestDto dto) {
        TipoProducto tipoProducto = iTipoProductoRepositor.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException
                        (
                                "No se encontró el ID " + id
                        ));

        TipoProductoMapper.updateEntity(tipoProducto, dto);
        TipoProducto guardado = iTipoProductoRepositor.save(tipoProducto);

        return TipoProductoMapper.toResponseDto(guardado);
    }

    @Override
    public TipoProductoResponseDto cambioDeEstado(Long id) {
        TipoProducto tipoProducto = iTipoProductoRepositor.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id " + id
                ));

        tipoProducto.setEstadoTipoProducto(false);
        iTipoProductoRepositor.save(tipoProducto);

        return TipoProductoMapper.toResponseDto(tipoProducto);
    }

    @Override
    public List<TipoProductoResponseDto> busquedaNombre(String nombre) {
        return iTipoProductoRepositor.findByNombre(nombre)
                .stream()
                .map(TipoProductoMapper::toResponseDto)
                .toList();
    }

    public boolean existePorId(Long id)
    {
        return iTipoProductoRepositor.existsById(id);
    }
}
