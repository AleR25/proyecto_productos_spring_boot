package com.gyl.CrudGyl.service;

import com.gyl.CrudGyl.dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.dto.Resquest.VentaRequestDto;

public interface IVentaService
{
    VentaResponseDto crear(VentaRequestDto dto);
}
