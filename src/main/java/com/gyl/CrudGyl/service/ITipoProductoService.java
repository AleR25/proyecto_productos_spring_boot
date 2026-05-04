package com.gyl.CrudGyl.service;

import com.gyl.CrudGyl.dto.Resquest.TipoProductoRequestDto;
import com.gyl.CrudGyl.dto.Response.TipoProductoResponseDto;
import com.gyl.CrudGyl.entity.TipoProducto;

import java.util.List;

public interface ITipoProductoService
{
    TipoProductoResponseDto crear(TipoProductoRequestDto tipoproducto);

    List<TipoProductoResponseDto> listar();

    TipoProducto buscarPorId(Long id);

    TipoProductoResponseDto buscarPorIdTipo(Long id);

    TipoProductoResponseDto actualizar(Long id, TipoProductoRequestDto dto);

    TipoProductoResponseDto cambioDeEstado(Long id);

    List<TipoProductoResponseDto> busquedaNombre(String nombre);
}
