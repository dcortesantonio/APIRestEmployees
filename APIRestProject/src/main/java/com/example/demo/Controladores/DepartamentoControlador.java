package com.example.demo.Controladores;

import com.example.demo.Modelos.Departamento;
import com.example.demo.Repositorios.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DepartamentoControlador {
    @Autowired
    private DepartamentoRepositorio repository;

    @GetMapping("/department")
    public Iterable<Departamento> getAllDepartamentos() {
        return repository.findAll();
    }

}
