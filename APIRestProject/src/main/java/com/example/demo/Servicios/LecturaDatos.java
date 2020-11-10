package com.example.demo.Servicios;


import com.example.demo.Modelos.Departamento;
import com.example.demo.Repositorios.DepartamentoRepositorio;
import com.example.demo.Modelos.Empleado;
import com.example.demo.Repositorios.EmpleadoRepositorio;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class LecturaDatos {
    @Autowired
    private EmpleadoRepositorio empleado;
    String line = "";


    public void LeerCsv() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/Recursos/empleados.csv"));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Empleado e = new Empleado();
                e.setNombre(data[0]);
                e.setCargo(data[1]);
                double salario = Double.parseDouble(data[2]);
                e.setSalario(salario);
                boolean tiempo = Boolean.parseBoolean(data[3]);
                e.setTiempoCompleto(tiempo);
                empleado.save(e);
            }
        }
        catch (FileNotFoundException e){
            throw new FileNotFoundException();
        }
    }

}
