package com.gyl.CrudGyl.controller;

import com.gyl.CrudGyl.service.interf.IProductoService;
import com.gyl.CrudGyl.dto.response.ProductoResponseDto;
import com.gyl.CrudGyl.dto.resquest.ProductoRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController
{
    private final IProductoService iProductoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponseDto crear(@Valid @RequestBody ProductoRequestDto dto)
    {
        return iProductoService.crear(dto);
    }

    @GetMapping
    public List<ProductoResponseDto> listar()
    {
        return iProductoService.listar();
    }

    @GetMapping("/{id}")
    public ProductoResponseDto buscarPorId(@PathVariable Long id)
    {
        return iProductoService.buscarPorId(id);
    };

    //Por cada parametro tengo q poner las validaciones?
    @PutMapping("/{id}")
    public ProductoResponseDto actualizar(@Valid @PathVariable Long id,@Valid @RequestBody ProductoRequestDto dto)
    {
        return iProductoService.actualizar(id, dto);
    };

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}/baja")
    public ProductoResponseDto darDeBaja(@PathVariable Long id)
    {
        return iProductoService.darDeBaja(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}/alta")
    public ProductoResponseDto darDeAlta(@PathVariable Long id)
    {
        return iProductoService.darDeAlta(id);
    }

    @GetMapping("/buscar")
    public List<ProductoResponseDto> busquedaNombre(@RequestParam String nombre)
    {
        return iProductoService.busquedaNombre(nombre);
    }


}
