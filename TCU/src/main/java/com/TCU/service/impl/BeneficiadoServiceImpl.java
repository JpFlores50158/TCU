/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TCU.service.impl;

import com.TCU.dao.BeneficiadoDao;
import com.TCU.domain.Beneficiado;
import com.TCU.service.BeneficiadoService;
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
public class BeneficiadoServiceImpl implements BeneficiadoService {

    @Autowired
    BeneficiadoDao beneficiadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Beneficiado> getBeneficiados(LocalDate date) {
        return beneficiadoDao.findBySelectedMonth(date);
    }

    @Override
    public Beneficiado getBeneficiado(Beneficiado beneficiado) {
        return beneficiadoDao.findById(beneficiado.getIdBeneficiado()).orElse(null);
    }

    @Override
    public void save(Beneficiado beneficiado) {
        beneficiadoDao.save(beneficiado);
    }

    @Override
    public void delete(Beneficiado beneficiado) {
        beneficiadoDao.delete(beneficiado);
    }

    @Override
    public List<Beneficiado> getTodos() {
        return beneficiadoDao.findAll();
    }

    @Override
    public List<Beneficiado> findAllBeneficiadosWithoutPension() {
      
        return beneficiadoDao.findAllBeneficiadosWithoutPensionAndInMonth(LocalDate.now());
    }

}
