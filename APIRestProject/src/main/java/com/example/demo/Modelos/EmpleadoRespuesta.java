package com.example.demo.Modelos;

public class EmpleadoRespuesta {
    private Long departamentoID;
    private String nombreDepartamento;
    private double sumSalario;

    public Long getDepartamentoID() {
        return departamentoID;
    }

    public void setDepartamentoID(Long departamentoID) {
        this.departamentoID = departamentoID;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public double getSumSalario() {
        return sumSalario;
    }

    public void setSumSalario(double sumSalario) {
        this.sumSalario = sumSalario;
    }

    public EmpleadoRespuesta(Long departamentoID, String nombreDepartamento, double sumSalario) {
        this.departamentoID = departamentoID;
        this.nombreDepartamento = nombreDepartamento;
        this.sumSalario = sumSalario;
    }
}
