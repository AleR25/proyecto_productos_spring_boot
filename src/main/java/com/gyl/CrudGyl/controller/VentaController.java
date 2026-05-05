package com.gyl.CrudGyl.controller;

import com.gyl.CrudGyl.dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.dto.Resquest.VentaRequestDto;
import com.gyl.CrudGyl.service.IVentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/venta")
public class VentaController
{
    private final IVentaService iVentaService;

    public VentaController(IVentaService iVentaService)
    {
        this.iVentaService = iVentaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaResponseDto crear(@Valid @RequestBody VentaRequestDto dto)
    {
        return iVentaService.crear(dto);
    }
}
