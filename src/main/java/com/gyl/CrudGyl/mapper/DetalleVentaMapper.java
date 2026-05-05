package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.Response.DetalleVentaResponseDto;
import com.gyl.CrudGyl.dto.Resquest.DetalleVentaRequestDto;
import com.gyl.CrudGyl.entity.DetalleVenta;

public class DetalleVentaMapper
{
    private DetalleVentaMapper() {}

    public static DetalleVenta toEntity(DetalleVentaRequestDto dto)
    {
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setCantidad(dto.cantidad());

        return detalleVenta;
    }

    public static DetalleVentaResponseDto toResponseDto(DetalleVenta detalleVenta)
    {
        return new DetalleVentaResponseDto
                (
                        detalleVenta.getId(),
                        detalleVenta.getCantidad(),
                        detalleVenta.getPrecioUnitario(),
                        detalleVenta.getSubtotal(),
                        detalleVenta.getProducto().getNombre()
                );
    }

    public static void updateEntity(DetalleVenta detalleVenta, DetalleVentaRequestDto dto)
    {
        detalleVenta.setCantidad(dto.cantidad());
    }
}
