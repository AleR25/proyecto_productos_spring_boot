package com.gyl.CrudGyl.controller;

import com.gyl.CrudGyl.dto.resquest.TipoProductoRequestDto;
import com.gyl.CrudGyl.dto.response.TipoProductoResponseDto;
import com.gyl.CrudGyl.service.interf.ITipoProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoProducto")
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
    public TipoProductoResponseDto buscarPorIdTipo(@PathVariable Long id)
    {
        return iTipoProductoService.buscarPorIdTipo(id);
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
