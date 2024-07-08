package com.TCU.service.impl;

import com.TCU.dao.PensionDao;
import com.TCU.domain.Pension;
import com.TCU.service.PensionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PensionServiceImpl implements PensionService {

    @Autowired
    PensionDao pensionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pension> getPensiones(LocalDate date) {
        return pensionDao.findBySelectedMonth(date);
    }

    @Override
    public Pension getPension(Pension pension) {
        return pensionDao.findById(pension.getIdPension()).orElse(null);
    }

    @Override
    public void save(Pension pension) {
        pensionDao.save(pension);
    }

    @Override
    @Transactional
    public void delete(Pension pension) {
        pensionDao.delete(pension);
    }

    @Override
    @Transactional
    public void updateAllPensionesFecha(LocalDate newDate) {
        pensionDao.updateAllPensionesFecha(newDate);
    }

}
