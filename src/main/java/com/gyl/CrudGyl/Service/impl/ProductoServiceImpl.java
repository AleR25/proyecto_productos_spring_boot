package com.gyl.CrudGyl.Service.impl;

import com.gyl.CrudGyl.Service.IProductoService;
import com.gyl.CrudGyl.dto.ProductoRequestDto;
import com.gyl.CrudGyl.dto.ProductoResponseDto;
import com.gyl.CrudGyl.entity.Producto;
import com.gyl.CrudGyl.exception.RecursoNoEncontradoException;
import com.gyl.CrudGyl.mapper.ProductoMapper;
import com.gyl.CrudGyl.repository.IProductoRepositor;

import java.util.List;

public class ProductoServiceImpl implements IProductoService
{
    private IProductoRepositor iproductoRepositor;

    public ProductoServiceImpl(IProductoRepositor iproductoRepositor)
    {
        this.iproductoRepositor = iproductoRepositor;
    }

    @Override
    public ProductoResponseDto crear(ProductoRequestDto dto)
    {
        Producto producto = ProductoMapper.toEntity(dto);
        Producto guardado = iproductoRepositor.save(producto);

        return ProductoMapper.toResponseDto(guardado);
    }

    @Override
    public List<ProductoResponseDto> listar()
    {
        return iproductoRepositor.findAll()
                .stream()
                .map(ProductoMapper::toResponseDto)
                .toList();
    }

    @Override
    public ProductoResponseDto buscarPorId(Long id)
    {
        return iproductoRepositor.findById(id)
                .map(ProductoMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                    "No se encontró el id " + id
                ));
    }

    public ProductoResponseDto actualizar(Long id, ProductoRequestDto dto)
    {
        Producto producto = iproductoRepositor.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id " + id
                ));

        ProductoMapper.updateEntity(producto, dto);
        Producto guardado = iproductoRepositor.save(producto);

        return ProductoMapper.toResponseDto(guardado);
    }

    public  void eliminar(long id)
    {
        Producto producto = iproductoRepositor.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id " + id
                ));

        iproductoRepositor.delete(producto);
    }
}
