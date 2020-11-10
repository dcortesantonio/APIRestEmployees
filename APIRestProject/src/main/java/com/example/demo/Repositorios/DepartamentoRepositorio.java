package com.example.demo.Repositorios;

import com.example.demo.Modelos.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoRepositorio extends CrudRepository<Departamento,Long> {

    public Departamento findByNombreDepartamento(String nombreDepartamento);
}