package com.TCU.dao;


import com.TCU.domain.Actividad;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ActividadDao extends JpaRepository<Actividad, Long>{
    
   @Query("SELECT a FROM Actividad a WHERE YEAR(a.fecha) = YEAR(CURRENT_DATE)")
    List<Actividad> findActividadesDelAnoActual();
    
    
     @Query("SELECT a.organizacion, YEAR(a.fecha), COUNT(a) "
         + "FROM Actividad a "
         + "GROUP BY a.organizacion, YEAR(a.fecha) "
         + "ORDER BY a.organizacion, YEAR(a.fecha)")
    List<Object[]> countByOrganizacionAndAnio();
    
    @Query("SELECT YEAR(a.fecha) AS año, a.tipoActividad, COUNT(a) AS cantidadActividades FROM Actividad a GROUP BY YEAR(a.fecha), a.tipoActividad ORDER BY año")
    List<Object[]> findActividadResumenByYearAndTipo();
    
    
     @Query("SELECT a.tipoActividad, AVG(a.ninos0a5), AVG(a.ninos5a12), AVG(a.adolescentes), AVG(a.adultoHombre), AVG(a.adultoMujer), AVG(a.personasMayores65) FROM Actividad a GROUP BY a.tipoActividad")
    List<Object[]> findAverageParticipantsByTipoActividad();
    
    
}
