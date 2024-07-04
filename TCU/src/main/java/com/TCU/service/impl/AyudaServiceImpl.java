/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TCU.service.impl;

import com.TCU.dao.AyudaDao;
import com.TCU.domain.Ayuda;
import com.TCU.service.AyudaService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jp09f
 */
@Service
public class AyudaServiceImpl implements AyudaService {

    @Autowired
    AyudaDao ayudaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ayuda> getAyudas(LocalDate date) {
        return ayudaDao.findBySelectedMonth(date);
    }

    @Override
    public Ayuda getAyuda(Ayuda ayuda) {
        return ayudaDao.findById(ayuda.getIdAyuda()).orElse(null);
    }

    @Override
    public void save(Ayuda ayuda) {
        ayudaDao.save(ayuda);
    }

    @Override
    @Transactional
    public void delete(Ayuda ayuda) {
        ayudaDao.delete(ayuda);
    }

    @Override
    @Transactional
    public void updateAllAyudasFecha(LocalDate newDate) {
       ayudaDao.updateAllAyudasFecha(newDate);
    }

}
