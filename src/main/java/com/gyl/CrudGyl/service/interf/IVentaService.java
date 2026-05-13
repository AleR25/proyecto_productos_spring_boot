package com.gyl.CrudGyl.service.interf;

import com.gyl.CrudGyl.dto.response.VentaResponseDto;
import com.gyl.CrudGyl.dto.request.VentaRequestDto;
import com.gyl.CrudGyl.enumP.EstadoVenta;

import java.util.List;

public interface IVentaService
{
    VentaResponseDto crear(VentaRequestDto dto);

    VentaResponseDto cambiarEstado(Long id, EstadoVenta nuevoEstado);

    List<VentaResponseDto> listar();

    VentaResponseDto buscarPorId(Long id);
}
