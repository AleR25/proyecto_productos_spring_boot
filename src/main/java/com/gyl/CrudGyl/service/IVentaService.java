package com.gyl.CrudGyl.service;

import com.gyl.CrudGyl.dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.dto.Resquest.VentaRequestDto;
import com.gyl.CrudGyl.enumP.EstadoVenta;

import java.util.List;

public interface IVentaService
{
    VentaResponseDto crear(VentaRequestDto dto);

    VentaResponseDto cambiarEstado(Long id, EstadoVenta nuevoEstado);

    List<VentaResponseDto> listar();

    VentaResponseDto BuscarPorId(Long id);
}
