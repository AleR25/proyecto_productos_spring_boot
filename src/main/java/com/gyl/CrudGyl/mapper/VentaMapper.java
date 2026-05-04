package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.dto.Resquest.VentaRequestDto;
import com.gyl.CrudGyl.entity.Producto;
import com.gyl.CrudGyl.entity.Venta;

import java.time.LocalDate;

public class VentaMapper
{
    private VentaMapper() {}

    public static Venta toEntity(VentaRequestDto dto) {
        Venta venta = new Venta();

        venta.setFechaVenta(dto.fechaVenta());
        venta.setEstadoVenta(dto.estadoVenta());

        return venta;
    }

    public static VentaResponseDto toResponseDto(Venta venta)
    {
        return new VentaResponseDto
                (
                        venta.getId(),
                        venta.getFechaVenta(),
                        venta.getTotal(),
                        venta.getCliente(),
                        venta.getDetalleVentas(),
                        venta.getEstadoVenta()
                );
    }

}
