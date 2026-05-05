package com.gyl.CrudGyl.service;

import com.gyl.CrudGyl.dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.dto.Resquest.VentaRequestDto;
import com.gyl.CrudGyl.enumP.EstadoVenta;

public interface IVentaService
{
    VentaResponseDto crear(VentaRequestDto dto);

    VentaResponseDto cambiarEstado(Long id, EstadoVenta nuevoEstado);
}
