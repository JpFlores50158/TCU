package com.TCU.dao;


import com.TCU.domain.Pension;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PensionDao extends JpaRepository<Pension, Long>{
    
 @Query("SELECT p FROM Pension p WHERE MONTH(p.mesLista) = MONTH(:selectedDate) AND YEAR(p.mesLista) = YEAR(:selectedDate)")
    List<Pension> findBySelectedMonth(@Param("selectedDate") LocalDate selectedDate);
    
    @Query("SELECT p FROM Pension p WHERE p.beneficiado.idBeneficiado = :idBeneficiado")
    Pension findByBeneficiadoId(@Param("idBeneficiado") Long idBeneficiado);
    
    
     @Modifying
    @Query("UPDATE Pension p SET p.mesLista = :newDate")
    int updateAllPensionesFecha(@Param("newDate") LocalDate newDate);
    
    
    
  
}
