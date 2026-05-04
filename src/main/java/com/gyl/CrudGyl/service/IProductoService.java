package com.gyl.CrudGyl.service;

import com.gyl.CrudGyl.dto.Resquest.ProductoRequestDto;
import com.gyl.CrudGyl.dto.Response.ProductoResponseDto;

import java.util.List;

public interface IProductoService
{
    ProductoResponseDto crear(ProductoRequestDto producto);

    List<ProductoResponseDto> listar();

    ProductoResponseDto buscarPorId(Long id);

    ProductoResponseDto actualizar(Long id, ProductoRequestDto dto);

    ProductoResponseDto darDeBaja(Long id);

    List<ProductoResponseDto> busquedaNombre(String nombre);
}
