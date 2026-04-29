package com.gyl.CrudGyl.controller;

import com.gyl.CrudGyl.service.IProductoService;
import com.gyl.CrudGyl.dto.ProductoResponseDto;
import com.gyl.CrudGyl.dto.ProductoRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final IProductoService iProductoService;

    public ProductoController(IProductoService iProductoService)
    {
        this.iProductoService = iProductoService;
    }

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
    @PatchMapping("/{id}")
    public ProductoResponseDto cambioDeEstado(@PathVariable Long id)
    {
        return iProductoService.cambioDeEstado(id);
    }

    @GetMapping("/buscar")
    public List<ProductoResponseDto> busquedaNombre(@RequestParam String nombre)
    {
        return iProductoService.busquedaNombre(nombre);
    }


}
