package com.gyl.CrudGyl.controller;

import com.gyl.CrudGyl.dto.TipoProductoRequestDto;
import com.gyl.CrudGyl.dto.TipoProductoResponseDto;
import com.gyl.CrudGyl.service.ITipoProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo_producto")
public class TipoProductoController
{
    private final ITipoProductoService iTipoProductoService;

    public TipoProductoController(ITipoProductoService iTipoProductoService)
    {
        this.iTipoProductoService = iTipoProductoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoProductoResponseDto crear(@Valid @RequestBody TipoProductoRequestDto dto)
    {
        return iTipoProductoService.crear(dto);
    }

    @GetMapping
    public List<TipoProductoResponseDto> listar()
    {
        return iTipoProductoService.listar();
    }

    @GetMapping("/{id}")
    public TipoProductoResponseDto buscarPorId(@PathVariable Long id)
    {
        return iTipoProductoService.buscarPorId(id);
    };

    @PutMapping("/{id}")
    public TipoProductoResponseDto actualizar(@Valid @PathVariable Long id,@Valid @RequestBody TipoProductoRequestDto dto)
    {
        return iTipoProductoService.actualizar(id, dto);
    };

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public TipoProductoResponseDto cambioDeEstado(@PathVariable Long id)
    {
        return iTipoProductoService.cambioDeEstado(id);
    }

    @GetMapping("/buscar")
    public List<TipoProductoResponseDto> busquedaNombre(@RequestParam String nombre)
    {
        return iTipoProductoService.busquedaNombre(nombre);
    }
}
