package com.gyl.CrudGyl.mapper;

import com.gyl.CrudGyl.dto.resquest.TipoProductoRequestDto;
import com.gyl.CrudGyl.dto.response.TipoProductoResponseDto;
import com.gyl.CrudGyl.entity.TipoProducto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TipoProductoMapper
{
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
                        tipoProducto.getId(),
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
