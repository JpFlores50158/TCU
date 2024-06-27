package com.TCU.dao;


import com.TCU.domain.Ayuda;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AyudaDao extends JpaRepository<Ayuda, Long>{
    
 @Query("SELECT a FROM Ayuda a WHERE MONTH(a.fecha) = MONTH(:selectedDate) AND YEAR(a.fecha) = YEAR(:selectedDate)")
    List<Ayuda> findBySelectedMonth(@Param("selectedDate") LocalDate selectedDate);
    
    
}
