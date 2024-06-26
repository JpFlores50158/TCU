package com.TCU.dao;


import com.TCU.domain.Pension;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PensionDao extends JpaRepository<Pension, Long>{
    
 @Query("SELECT p FROM Pension p WHERE MONTH(p.mesLista) = MONTH(:selectedDate) AND YEAR(p.mesLista) = YEAR(:selectedDate)")
    List<Pension> findBySelectedMonth(@Param("selectedDate") LocalDate selectedDate);
    
    
}
