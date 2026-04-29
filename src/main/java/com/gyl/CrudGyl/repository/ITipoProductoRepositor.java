package com.gyl.CrudGyl.repository;

import com.gyl.CrudGyl.entity.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoProductoRepositor extends JpaRepository<TipoProducto, Long>
{

}
