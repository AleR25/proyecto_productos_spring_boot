package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.TipoProductoRequestDto;
import com.gyl.CrudGyl.dto.TipoProductoResponseDto;
import com.gyl.CrudGyl.entity.TipoProducto;

public class TipoProductoMapper
{
    private TipoProductoMapper() {}

    public static TipoProducto toEntity(TipoProductoRequestDto dto)
    {
        TipoProducto tipoProducto = new TipoProducto();

        tipoProducto.setNombre(dto.nombre());
        tipoProducto.setDescripcion(dto.descripcion());
        tipoProducto.setEstadoTipoProducto(dto.estadoTipoProducto());

        return tipoProducto;
    }

    public static TipoProductoResponseDto toResponseDto(TipoProducto tipoProducto)
    {
        return new TipoProductoResponseDto
                (
                        tipoProducto.getIdTipoProducto(),
                        tipoProducto.getNombre(),
                        tipoProducto.getDescripcion(),
                        tipoProducto.getEstadoTipoProducto()
                );
    }

    public static void updateEntity(TipoProducto tipoProducto, TipoProductoRequestDto dto)
    {
        tipoProducto.setNombre(dto.nombre());
        tipoProducto.setDescripcion(dto.descripcion());
        tipoProducto.setEstadoTipoProducto(dto.estadoTipoProducto());
    }
}
