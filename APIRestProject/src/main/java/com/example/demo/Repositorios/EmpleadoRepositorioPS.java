package com.example.demo.Repositorios;

import com.example.demo.Modelos.Empleado;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmpleadoRepositorioPS  extends PagingAndSortingRepository<Empleado, Long> {
    public List<Empleado> findByDepartamentoAsingnadoId(long id, Pageable pageable);
}
