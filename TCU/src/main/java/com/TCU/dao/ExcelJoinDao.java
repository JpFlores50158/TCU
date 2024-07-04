/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TCU.dao;


import com.TCU.domain.ExcelJoin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

/**
 *
 * @author jp09f
 */
public interface ExcelJoinDao  extends JpaRepository<ExcelJoin, Long> {
    
      @Procedure(name = "obtenerDatosCompletos")
    List<ExcelJoin> obtenerDatosCompletos();
}
 