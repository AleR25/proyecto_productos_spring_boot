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

    @PostMapping
    public ProductoResponseDto buscarPorId(@RequestBody Long id)
    {
        return iProductoService.buscarPorId(id);
    };

    //Por cada parametro tengo q poner las validaciones?
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponseDto actualizar(@Valid @RequestBody Long id, ProductoRequestDto dto)
    {
        return iProductoService.actualizar(id, dto);
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void eliminar(Long id)
    {
        iProductoService.eliminar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductoResponseDto> busquedaNombre(@Valid String nombre)
    {
        return iProductoService.busquedaNombre(nombre);
    }


}
