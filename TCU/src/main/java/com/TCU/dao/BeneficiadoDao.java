/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TCU.dao;

import com.TCU.domain.Beneficiado;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jp09f
 */
public interface BeneficiadoDao extends JpaRepository<Beneficiado, Long> {

    @Query("SELECT b FROM Beneficiado b WHERE MONTH(b.fecha) = MONTH(:selectedDate) AND YEAR(b.fecha) = YEAR(:selectedDate)")
    List<Beneficiado> findBySelectedMonth(@Param("selectedDate") LocalDate selectedDate);

    @Query("SELECT b FROM Beneficiado b "
            + "WHERE NOT EXISTS (SELECT p FROM Pension p WHERE p.beneficiado = b) "
            + "AND MONTH(b.fecha) = MONTH(:selectedDate) AND YEAR(b.fecha) = YEAR(:selectedDate)")
    List<Beneficiado> findAllBeneficiadosWithoutPensionAndInMonth(
            @Param("selectedDate") LocalDate selectedDate);

    @Query("SELECT b FROM Beneficiado b "
            + "WHERE NOT EXISTS (SELECT a FROM Ayuda a WHERE a.beneficiado = b) "
            + "AND MONTH(b.fecha) = MONTH(:selectedDate) AND YEAR(b.fecha) = YEAR(:selectedDate)")
    List<Beneficiado> findAllBeneficiadosWithoutAyudaAndInMonth(@Param("selectedDate") LocalDate selectedDate);

    @Query("SELECT COUNT(b) FROM Beneficiado b "
            + "WHERE b.numIdentificacion = :numIdentificacion "
            + "AND MONTH(b.fecha) = MONTH(:selectedDate) "
            + "AND YEAR(b.fecha) = YEAR(:selectedDate)")
    int countByNumIdentificacionAndMonth(
            @Param("numIdentificacion") String numIdentificacion,
            @Param("selectedDate") LocalDate selectedDate);

    @Modifying
    @Query("UPDATE Beneficiado b SET b.fecha = :newDate")
    int updateAllBeneficiadosFecha(@Param("newDate") LocalDate newDate);
    
    @Query("SELECT b.sexo, COUNT(b) FROM Beneficiado b GROUP BY b.sexo")
    List<Object[]> countBySexo();
    
 @Query("SELECT b FROM Beneficiado b WHERE MONTH(b.fecha) = MONTH(:selectedDate) AND YEAR(b.fecha) = YEAR(:selectedDate) ORDER BY b.nombre1, b.apellido1, b.apellido2")
    List<Beneficiado> findBySelectedMonthOrdenado(@Param("selectedDate") LocalDate selectedDate);
}
