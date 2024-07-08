package com.TCU.dao;

import com.TCU.domain.Grafico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface GraficoDao extends JpaRepository<Grafico, String> {
    
      @Procedure(name = "grafico")
    List<Grafico> grafico();
}
