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

    @Override
    @Transactional
    public ProductoResponseDto crear(ProductoRequestDto dto)
    {
        boolean existe = tipoProductoService.existePorId(dto.tipoProductoId());

        if (!existe)
        {
            throw new RecursoNoEncontradoException("El tipo de producto no existe");
        }

        Producto producto = ProductoMapper.toEntity(dto);
        producto.setEstadoProducto(true);
        producto.setTipoProducto(tipoProductoService.buscarPorId(dto.tipoProductoId()));

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

        if (tipoProductoService.existePorId(dto.tipoProductoId()))
        {
            producto.setTipoProducto(tipoProductoService.buscarPorId(dto.tipoProductoId()));
        }

        Producto guardado = iproductoRepositor.save(producto);

        return ProductoMapper.toResponseDto(guardado);
    }

//    @Override
//    public ProductoResponseDto actualizar(Long id, ProductoRequestDto dto)
//    {
//        Producto producto = iproductoRepositor.findById(id)
//                .orElseThrow(() -> new RecursoNoEncontradoException(
//                        "No se encontró el ID " + id
//                ));
//
//        ProductoMapper.updateEntity(producto, dto);
//        Producto guardado = iproductoRepositor.save(producto);
//
//        return ProductoMapper.toResponseDto(guardado);
//    }

    @Override
    public ProductoResponseDto darDeBaja(Long id)
    {
        return cambioDeEstado(id, false);
    }

    @Override
    public ProductoResponseDto darDeAlta(Long id)
    {
        return cambioDeEstado(id, true);
    }

    @Override
    public List<ProductoResponseDto> busquedaNombre(String nombre){
        return iproductoRepositor.findByNombre(nombre)
                .stream()
                .map(ProductoMapper::toResponseDto)
                .toList();
    }

    private ProductoResponseDto cambioDeEstado(Long id, boolean activo)
    {
        Producto producto = iproductoRepositor.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id " + id
                ));

        producto.setEstadoProducto(activo);
        iproductoRepositor.save(producto);

        return ProductoMapper.toResponseDto(producto);
    }
}
