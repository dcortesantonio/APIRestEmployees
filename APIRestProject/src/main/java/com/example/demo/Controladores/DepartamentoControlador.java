package com.example.demo.Controladores;

import com.example.demo.Excepciones.NotFoundException;
import com.example.demo.Excepciones.PageNegativeException;
import com.example.demo.Modelos.Departamento;
import com.example.demo.Modelos.Empleado;
import com.example.demo.Repositorios.DepartamentoRepositorio;
import com.example.demo.Repositorios.EmpleadoRepositorioPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DepartamentoControlador {
    @Autowired
    private DepartamentoRepositorio repository;
    @Autowired
    private EmpleadoRepositorioPS repositoryPS;

    @GetMapping("/department")
    public Iterable<Departamento> getAllDepartamentos() {
        return repository.findAll();
    }

    @GetMapping("/department//page/{id}/{pagenum}")
    public List<Empleado> findByEmployees(@PathVariable long id, @PathVariable(value="pagenum") int pagenum) {
        System.out.print(" DEPARTAMENTOO: ID:: " + id);
        System.out.print(" DEPARTAMENTOO: pagenum:: " + pagenum);
        if ( pagenum < 0)
        {
            throw new PageNegativeException("The number page can't be negative ");
        } else{
            Pageable paging = PageRequest.of(pagenum, 5);
            if (repository.existsById(id)) {
                return repositoryPS.findByDepartamentoAsingnadoId(id, paging);

            }
            else{
                throw new NotFoundException(" The department don't exist. ");
            }

        }

    }
    @GetMapping("/employees/page/{pagenum}")
    public Page<Empleado> getAllEmployees(@PathVariable(value="pagenum") int pagenum) {
        if ( pagenum < 0)
        {
            throw new PageNegativeException("The number page can't be negative ");
        } else{
            Pageable paging = PageRequest.of(pagenum, 10);
            return repositoryPS.findAll(paging);
        }
    }
}
