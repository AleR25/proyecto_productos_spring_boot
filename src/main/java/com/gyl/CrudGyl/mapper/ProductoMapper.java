package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.ProductoRequestDto;
import com.gyl.CrudGyl.dto.ProductoResponseDto;
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

    public static ProductoResponseDto toResponseDto(Producto producto)
    {
        return new ProductoResponseDto(
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getTipoProducto(),
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
