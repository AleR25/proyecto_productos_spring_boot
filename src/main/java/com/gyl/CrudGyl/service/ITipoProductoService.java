package com.gyl.CrudGyl.service;

import com.gyl.CrudGyl.dto.TipoProductoRequestDto;
import com.gyl.CrudGyl.dto.TipoProductoResponseDto;

import java.util.List;

public interface ITipoProductoService
{
    TipoProductoResponseDto crear(TipoProductoRequestDto tipoproducto);

    List<TipoProductoResponseDto> listar();

    TipoProductoResponseDto buscarPorId(Long id);

    TipoProductoResponseDto actualizar(Long id, TipoProductoRequestDto dto);

    TipoProductoResponseDto cambioDeEstado(Long id);

    List<TipoProductoResponseDto> busquedaNombre(String nombre);
}
