package com.gyl.CrudGyl.service.interf;

import com.gyl.CrudGyl.dto.resquest.ProductoRequestDto;
import com.gyl.CrudGyl.dto.response.ProductoResponseDto;

import java.util.List;

public interface IProductoService
{
    ProductoResponseDto crear(ProductoRequestDto producto);

    List<ProductoResponseDto> listar();

    ProductoResponseDto buscarPorId(Long id);

    ProductoResponseDto actualizar(Long id, ProductoRequestDto dto);

    ProductoResponseDto darDeBaja(Long id);

    ProductoResponseDto darDeAlta(Long id);

    List<ProductoResponseDto> busquedaNombre(String nombre);
}
