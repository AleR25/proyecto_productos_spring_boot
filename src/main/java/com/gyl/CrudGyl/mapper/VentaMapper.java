package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.response.VentaResponseDto;
import com.gyl.CrudGyl.dto.resquest.VentaRequestDto;
import com.gyl.CrudGyl.entity.Venta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VentaMapper
{
    public static Venta toEntity(VentaRequestDto dto) {
        Venta venta = new Venta();
        return venta;
    }

    public static VentaResponseDto toResponseDto(Venta venta)
    {
        return new VentaResponseDto(
                venta.getId(),
                venta.getFechaVenta(),
                venta.getTotal(),
                ClienteMapper.toResponseDto(venta.getCliente()),
                venta.getDetalleVentas()
                        .stream()
                        .map(DetalleVentaMapper::toResponseDto)
                        .toList(),
                venta.getEstadoVenta()
        );
    }

}
