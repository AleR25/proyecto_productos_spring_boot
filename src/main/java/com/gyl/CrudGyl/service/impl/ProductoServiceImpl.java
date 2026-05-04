package com.gyl.CrudGyl.service.impl;

import com.gyl.CrudGyl.service.IProductoService;
import com.gyl.CrudGyl.dto.Resquest.ProductoRequestDto;
import com.gyl.CrudGyl.dto.Response.ProductoResponseDto;
import com.gyl.CrudGyl.entity.Producto;
import com.gyl.CrudGyl.exception.RecursoNoEncontradoException;
import com.gyl.CrudGyl.mapper.ProductoMapper;
import com.gyl.CrudGyl.repository.IProductoRepositor;
import com.gyl.CrudGyl.service.ITipoProductoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService
{
    private ITipoProductoService tipoProductoService;
    private IProductoRepositor iproductoRepositor;

    public ProductoServiceImpl(IProductoRepositor iproductoRepositor,
                               ITipoProductoService tipoProductoService)
    {
        this.iproductoRepositor = iproductoRepositor;
        this.tipoProductoService = tipoProductoService;
    }

//    public ProductoServiceImpl(IProductoRepositor iproductoRepositor)
//    {
//        this.iproductoRepositor = iproductoRepositor;
//    }

    @Override
    @Transactional
    public ProductoResponseDto crear(ProductoRequestDto dto)
    {
        Producto producto = ProductoMapper.toEntity(dto);
        producto.setTipoProducto(tipoProductoService.buscarPorId(dto.tipoProductoId()));

        Producto guardado = iproductoRepositor.save(producto);

        return ProductoMapper.toResponseDto(guardado);
    }

//    @Transactional
//    @Override
//    public ProductoResponseDto crear(ProductoRequestDto dto)
//    {
//        Producto producto = ProductoMapper.toEntity(dto);
//        Producto guardado = iproductoRepositor.save(producto);
//
//        return ProductoMapper.toResponseDto(guardado);
//    }

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
                    "No se encontró el ID " + id
                ));
    }

    @Override
    public ProductoResponseDto actualizar(Long id, ProductoRequestDto dto)
    {
        Producto producto = iproductoRepositor.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el ID " + id
                ));

        ProductoMapper.updateEntity(producto, dto);
        Producto guardado = iproductoRepositor.save(producto);

        return ProductoMapper.toResponseDto(guardado);
    }

    @Override
    public ProductoResponseDto darDeBaja(Long id)
    {
        Producto producto = iproductoRepositor.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id " + id
                ));

        producto.setEstadoProducto(false);
        iproductoRepositor.save(producto);

        return ProductoMapper.toResponseDto(producto);
    }

    @Override
    public List<ProductoResponseDto> busquedaNombre(String nombre){
        return iproductoRepositor.findByNombre(nombre)
                .stream()
                .map(ProductoMapper::toResponseDto)
                .toList();
    }
}
