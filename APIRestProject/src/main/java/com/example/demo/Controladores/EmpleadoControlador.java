package com.example.demo.Controladores;

import com.example.demo.Modelos.Empleado;
import com.example.demo.Repositorios.EmpleadoRepositorio;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
public class EmpleadoControlador {

    @Autowired
    private EmpleadoRepositorio repository;

    @GetMapping("/employees")
    public Iterable<Empleado> getAllEmployees() {
        return repository.findAll();
    }



}
