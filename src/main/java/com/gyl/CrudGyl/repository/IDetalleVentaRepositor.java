package com.gyl.CrudGyl.repository;

import com.gyl.CrudGyl.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleVentaRepositor extends JpaRepository<DetalleVenta, Long>
{

}
