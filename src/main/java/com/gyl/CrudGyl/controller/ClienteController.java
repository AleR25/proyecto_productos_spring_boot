package com.gyl.CrudGyl.controller;

import com.gyl.CrudGyl.dto.resquest.ClienteRequestDto;
import com.gyl.CrudGyl.dto.response.ClienteResponseDto;
import com.gyl.CrudGyl.service.interf.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController
{
    private final IClienteService iClienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto crear(@Valid @RequestBody ClienteRequestDto dto)
    {
        return iClienteService.crear(dto);
    }

    @GetMapping("/listaclientes")
    public List<ClienteResponseDto> listar()
    {
        return iClienteService.listar();
    }

    @GetMapping("/{id}")
    public ClienteResponseDto buscarPorId(@PathVariable Long id)
    {
        return iClienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ClienteResponseDto actualizar(@Valid @PathVariable Long id, @Valid @RequestBody ClienteRequestDto dto)
    {
        return iClienteService.actualizar(id, dto);
    }

    @PatchMapping("/baja/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto darDeBaja(@PathVariable Long id)
    {
        return iClienteService.darDeBaja(id);
    }

    @PatchMapping("/alta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto darDeAlta(@PathVariable Long id)
    {
        return iClienteService.darDeAlta(id);
    }

    @GetMapping("/buscar")
    public List<ClienteResponseDto> busquedaNombre(@RequestParam String nombre)
    {
        return iClienteService.busquedaNomnbre(nombre);
    }
}
