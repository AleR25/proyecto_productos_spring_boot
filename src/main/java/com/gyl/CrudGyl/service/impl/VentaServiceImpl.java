package com.gyl.CrudGyl.service.impl;

import com.gyl.CrudGyl.dto.response.VentaResponseDto;
import com.gyl.CrudGyl.dto.resquest.DetalleVentaRequestDto;
import com.gyl.CrudGyl.dto.resquest.VentaRequestDto;
import com.gyl.CrudGyl.entity.Cliente;
import com.gyl.CrudGyl.entity.DetalleVenta;
import com.gyl.CrudGyl.entity.Producto;
import com.gyl.CrudGyl.entity.Venta;
import com.gyl.CrudGyl.enumP.EstadoVenta;
import com.gyl.CrudGyl.exception.ClienteInactivoException;
import com.gyl.CrudGyl.exception.RecursoNoEncontradoException;
import com.gyl.CrudGyl.mapper.VentaMapper;
import com.gyl.CrudGyl.repository.IClienteRepositor;
import com.gyl.CrudGyl.repository.IProductoRepositor;
import com.gyl.CrudGyl.repository.IVentaRepositor;
import com.gyl.CrudGyl.service.interf.IVentaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements IVentaService
{
    private final IVentaRepositor iVentaRepositor;
    private final IProductoRepositor iProductoRepositor;
    private final IClienteRepositor iClienteRepositor;

    @Override
    @Transactional
    public VentaResponseDto crear(VentaRequestDto dto)
    {
        Venta venta = new Venta();
        venta.setFechaVenta(LocalDate.now());
        venta.setEstadoVenta(EstadoVenta.PENDIENTE);

        BigDecimal total = BigDecimal.ZERO;

        Cliente cliente = iClienteRepositor.findById(dto.clienteId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Cliente no encontrado ID: " + dto.clienteId()
                ));

        validarClienteActivo(cliente);

        venta.setCliente(cliente);

        for (DetalleVentaRequestDto detalleVentaRequestDto : dto.detalles())
        {
            Producto producto = iProductoRepositor.findById(detalleVentaRequestDto.productoId())
                    .orElseThrow(() -> new RecursoNoEncontradoException(
                            "Producto no encontrado ID: " + detalleVentaRequestDto.productoId()
                    ));

            if (!producto.isEstadoProducto())
            {
                throw new RuntimeException("El producto está dado de baja: " + producto.getNombre());
            }

            if (producto.getStock() < detalleVentaRequestDto.cantidad())
            {
                throw new RuntimeException(
                        "Stock insuficiente para: " + producto.getNombre()
                );
            }

            DetalleVenta detalle = new DetalleVenta();
            detalle.setProducto(producto);
            detalle.setCantidad(detalleVentaRequestDto.cantidad());
            detalle.setPrecioUnitario(producto.getPrecio());

            BigDecimal subtotal = producto
                    .getPrecio()
                    .multiply(BigDecimal.valueOf(detalleVentaRequestDto.cantidad()));

            detalle.setSubtotal(subtotal);

            vincularDetalle(venta, detalle);

            total = total.add(subtotal);

            producto.setStock(producto.getStock() - detalleVentaRequestDto.cantidad());
            iProductoRepositor.save(producto);
        }

        venta.setTotal(total);

        Venta guardada = iVentaRepositor.save(venta);

        return VentaMapper.toResponseDto(guardada);
    }

    @Override
    @Transactional
    public VentaResponseDto cambiarEstado(Long id, EstadoVenta nuevoEstado)
    {
        Venta venta = iVentaRepositor.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Venta no encontrada ID: " + id
                ));

        if (venta.getEstadoVenta() == EstadoVenta.CANCELADA)
        {
            throw new IllegalStateException("No se puede modificar una venta cancelada");
        }

        venta.setEstadoVenta(nuevoEstado);

        Venta guardada = iVentaRepositor.save(venta);

        return VentaMapper.toResponseDto(guardada);
    }

    public List<VentaResponseDto> listar()
    {
        return iVentaRepositor.findAll()
                .stream()
                .map(VentaMapper::toResponseDto)
                .toList();
    }

    public VentaResponseDto buscarPorId(Long id)
    {
        return iVentaRepositor.findById(id)
                .map(VentaMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el ID " + id
                ));
    }

    private void vincularDetalle(Venta venta, DetalleVenta detalle) {
        detalle.setVenta(venta);
        venta.getDetalleVentas().add(detalle);
    }

    private void validarClienteActivo(Cliente cliente)
    {
        if (!cliente.isEstadoCliente())
        {
            throw new ClienteInactivoException(
                    "El cliente está inactivo y no puede realizar compras"
            );
        }
    }

}

