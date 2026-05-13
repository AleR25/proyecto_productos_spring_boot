package com.gyl.CrudGyl.controller;

import com.gyl.CrudGyl.dto.response.VentaResponseDto;
import com.gyl.CrudGyl.dto.resquest.VentaRequestDto;
import com.gyl.CrudGyl.enumP.EstadoVenta;
import com.gyl.CrudGyl.service.interf.IVentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
@RequiredArgsConstructor
public class VentaController
{
    private final IVentaService iVentaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VentaResponseDto crear(@Valid @RequestBody VentaRequestDto dto)
    {
        return iVentaService.crear(dto);
    }

    @PatchMapping("/{id}/estado")
    public VentaResponseDto cambiarEstado(
            @PathVariable Long id,
            @RequestParam EstadoVenta estado
    )
    {
        return iVentaService.cambiarEstado(id, estado);
    }

    @GetMapping
    public List<VentaResponseDto> listar()
    {
        return iVentaService.listar();
    }

    @GetMapping("/{id}")
    public VentaResponseDto buscarPorId(@PathVariable Long id)
    {
        return iVentaService.buscarPorId(id);
    }
}
