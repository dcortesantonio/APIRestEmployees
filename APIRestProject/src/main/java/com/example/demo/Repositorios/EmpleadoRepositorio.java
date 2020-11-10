package com.example.demo.Repositorios;

import com.example.demo.Modelos.Empleado;
import com.example.demo.Modelos.EmpleadoRespuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface EmpleadoRepositorio extends CrudRepository<Empleado, Long> {

    public List<Empleado> findTop5ByOrderBySalarioDesc();

    @Query("SELECT new com.example.demo.Modelos.EmpleadoRespuesta(" +
            "e.departamentoAsingnado.id, "
            + "e.departamentoAsingnado.nombreDepartamento, "
            + "SUM(e.salario)) "
            + "FROM Empleado e "
            + "group by e.departamentoAsingnado")
    public List<EmpleadoRespuesta> findEmpleadoCount();
}
