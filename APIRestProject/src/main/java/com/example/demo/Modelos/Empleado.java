package com.example.demo.Modelos;

import javax.persistence.*;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;

    private String nombre;
    private String cargo;
    private double salario;
    private Boolean tiempoCompleto;

    @ManyToOne
    private Departamento departamentoAsingnado;

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", tiempoCompleto=" + tiempoCompleto +
                '}';
    }

    public Long getId() {
        return idEmpleado;
    }

    public void setId(Long id) {
        this.idEmpleado = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Boolean getTiempoCompleto() {
        return tiempoCompleto;
    }

    public void setTiempoCompleto(Boolean tiempoCompleto) {
        this.tiempoCompleto = tiempoCompleto;
    }

    public Departamento getDepartamentoAsingnado() {
        return departamentoAsingnado;
    }

    public void setDepartamentoAsingnado(Departamento departamentoAsingnado) {
        this.departamentoAsingnado = departamentoAsingnado;
    }


}
