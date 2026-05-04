package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.Resquest.ProductoRequestDto;
import com.gyl.CrudGyl.dto.Response.ProductoResponseDto;
import com.gyl.CrudGyl.entity.Producto;

public class ProductoMapper
{

    private ProductoMapper() {}

    public static Producto toEntity(ProductoRequestDto dto)
    {
        Producto producto = new Producto();

        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());

        return producto;
    }

    //como estoy usando un Mapper estoy realizando un movimiento horizontal
    public static ProductoResponseDto toResponseDto(Producto producto)
    {
        return new ProductoResponseDto(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                TipoProductoMapper.toResponseDto(producto.getTipoProducto()),
                producto.isEstadoProducto()
        );
    }

    public static void updateEntity(Producto producto, ProductoRequestDto dto){
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
        producto.setEstadoProducto(dto.estadoProducto());
    }
}
