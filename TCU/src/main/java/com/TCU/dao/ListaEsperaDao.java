package com.TCU.dao;

import com.TCU.domain.ListaEspera;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListaEsperaDao extends JpaRepository<ListaEspera, Long> {

    @Query("SELECT le FROM ListaEspera le WHERE le.sinirubreEstadoJustificacion = 'Lista Espera' ORDER BY le.prioridad DESC")
    List<ListaEspera> findAllByPrioridadDescAndSinirubeEstado();

}
