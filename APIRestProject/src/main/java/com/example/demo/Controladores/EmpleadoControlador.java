package com.example.demo.Controladores;

import com.example.demo.Modelos.Empleado;
import com.example.demo.Modelos.EmpleadoRespuesta;
import com.example.demo.Repositorios.EmpleadoRepositorio;
import com.example.demo.Servicios.LecturaDatos;
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
    @Autowired
    private LecturaDatos servicio;

    @GetMapping("/employees")
    public Iterable<Empleado> getAllEmployees() {
        return repository.findAll();
    }

    @RequestMapping(path = "/feedEmployees")
    public void guardarDatos() throws IOException {
        try{
            servicio.LeerCsv();
            System.out.print(" END READ FILE .CSV ");
        }
        catch (FileNotFoundException e){
            throw new FileNotFoundException(" File .csv not found. ");
        }
        catch (ClientAbortException c)
        {
            throw new ClientAbortException("CC File .csv not found. ");
        }
    }

    @GetMapping("/employees/Top5")
    public Iterable<Empleado> findTop5() {
        return repository.findTop5ByOrderBySalarioDesc();
    }

    @GetMapping("/employees/GroupBy")
    public Iterable<EmpleadoRespuesta> findGroupBy() {
        return repository.findEmpleadoCount();
    }


}
