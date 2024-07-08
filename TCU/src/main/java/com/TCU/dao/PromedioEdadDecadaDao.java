
package com.TCU.dao;

import com.TCU.domain.PromedioEdadDecada;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface PromedioEdadDecadaDao extends JpaRepository<PromedioEdadDecada, Integer> {
    
    
      @Procedure(name = "PromedioEdadDecada")
    List<PromedioEdadDecada> PromedioEdadDecada();
}
