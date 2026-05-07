package com.gyl.CrudGyl.service.interf;

import com.gyl.CrudGyl.dto.resquest.TipoProductoRequestDto;
import com.gyl.CrudGyl.dto.response.TipoProductoResponseDto;
import com.gyl.CrudGyl.entity.TipoProducto;

import java.util.List;

public interface ITipoProductoService
{
    TipoProductoResponseDto crear(TipoProductoRequestDto tipoproducto);

    List<TipoProductoResponseDto> listar();

    TipoProducto buscarPorId(Long id);

    boolean existePorId(Long id);

    TipoProductoResponseDto buscarPorIdTipo(Long id);

    TipoProductoResponseDto actualizar(Long id, TipoProductoRequestDto dto);

    TipoProductoResponseDto cambioDeEstado(Long id);

    List<TipoProductoResponseDto> busquedaNombre(String nombre);
}
