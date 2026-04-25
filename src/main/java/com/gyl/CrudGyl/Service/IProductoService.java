package com.gyl.CrudGyl.Service;

import com.gyl.CrudGyl.dto.ProductoRequestDto;
import com.gyl.CrudGyl.dto.ProductoResponseDto;

import java.util.List;

public interface IProductoService
{
    ProductoResponseDto crear(ProductoRequestDto producto);

    List<ProductoResponseDto> listar();

    ProductoResponseDto buscarPorId(Long id);
}
