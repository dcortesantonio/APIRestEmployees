package com.example.demo.Repositorios;

import com.example.demo.Modelos.Empleado;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface EmpleadoRepositorio extends CrudRepository<Empleado, Long> {


}
