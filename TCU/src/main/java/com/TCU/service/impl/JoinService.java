/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TCU.service.impl;

import com.TCU.dao.ExcelJoinDao;
import com.TCU.domain.ExcelJoin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jp09f
 */
@Service
public class JoinService {
     @Autowired
    private ExcelJoinDao excelJoinDao;

    @Transactional
    public  List<ExcelJoin> getDatos() {
        List<ExcelJoin> datosCompletos = excelJoinDao.obtenerDatosCompletos();
        return datosCompletos;
    }
}
