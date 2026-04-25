package com.gyl.CrudGyl.repository;

import com.gyl.CrudGyl.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepositor extends JpaRepository<Producto, Long> {
}
