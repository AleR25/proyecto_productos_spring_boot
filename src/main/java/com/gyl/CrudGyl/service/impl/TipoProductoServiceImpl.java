package com.gyl.CrudGyl.service.impl;

import com.gyl.CrudGyl.dto.TipoProductoRequestDto;
import com.gyl.CrudGyl.dto.TipoProductoResponseDto;
import com.gyl.CrudGyl.entity.Producto;
import com.gyl.CrudGyl.entity.TipoProducto;
import com.gyl.CrudGyl.exception.RecursoNoEncontradoException;
import com.gyl.CrudGyl.mapper.ProductoMapper;
import com.gyl.CrudGyl.mapper.TipoProductoMapper;
import com.gyl.CrudGyl.repository.ITipoProductoRepositor;
import com.gyl.CrudGyl.service.ITipoProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService
{
    private ITipoProductoRepositor iTipoProductoRepositor;

    public TipoProductoServiceImpl(ITipoProductoRepositor iTipoProductoRepositor)
    {
        this.iTipoProductoRepositor = iTipoProductoRepositor;
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
    public TipoProductoResponseDto buscarPorId(Long id) {
        return iTipoProductoRepositor.findById(id)
                .map(TipoProductoMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException
                (
                        "No se encontró el ID " + id
                ));
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
}
