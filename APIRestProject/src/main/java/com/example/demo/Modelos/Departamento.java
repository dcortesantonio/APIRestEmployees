package com.example.demo.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nombreDepartamento;

    @OneToMany(mappedBy = "departamentoAsingnado", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Empleado> empleados;


    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombreDepartamento='" + nombreDepartamento + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
