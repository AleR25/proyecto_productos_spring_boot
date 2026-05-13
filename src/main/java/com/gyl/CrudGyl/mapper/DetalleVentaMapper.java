package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.response.DetalleVentaResponseDto;
import com.gyl.CrudGyl.dto.request.DetalleVentaRequestDto;
import com.gyl.CrudGyl.entity.DetalleVenta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DetalleVentaMapper
{
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
