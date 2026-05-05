package com.gyl.CrudGyl.repository;

import com.gyl.CrudGyl.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepositor extends JpaRepository<Venta,Long>
{

}
