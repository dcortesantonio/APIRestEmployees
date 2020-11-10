package com.example.demo.Servicios;


import com.example.demo.Modelos.Departamento;
import com.example.demo.Repositorios.DepartamentoRepositorio;
import com.example.demo.Modelos.Empleado;
import com.example.demo.Repositorios.EmpleadoRepositorio;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class LecturaDatos {
    @Autowired
    private DepartamentoRepositorio departamento;
    @Autowired
    private EmpleadoRepositorio empleado;


    public Departamento verificarDepartamento(String nombreDepartamento)
    {
        Departamento d = departamento.findByNombreDepartamento(nombreDepartamento);
        if( d == null)
        {
            Departamento nuevoD = new Departamento();
            nuevoD.setNombreDepartamento(nombreDepartamento);
            departamento.save(nuevoD);
            return nuevoD;
        }
        return d;
    }

    public void LeerCsv() throws IOException {
        String line = "";
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
                e.setDepartamentoAsingnado(this.verificarDepartamento(data[4]));
                empleado.save(e);
            }
        }
        catch (FileNotFoundException e){
            throw new FileNotFoundException(" File .csv not found. ");
        }
        catch (ClientAbortException c)
        {
            throw new ClientAbortException("CC File .csv not found. ");

        }
        catch (IOException  c)
        {
            throw new IOException("CC File .csv not found. ");

        }
    }

}
