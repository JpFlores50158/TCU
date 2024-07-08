package com.TCU.service.impl;

import com.TCU.dao.ActividadDao;
import com.TCU.domain.Actividad;
import com.TCU.service.ActividadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jp09f
 */
@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    ActividadDao actividadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Actividad> getActividades() {
        return actividadDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Actividad> getActividadesAno() {
        return actividadDao.findActividadesDelAnoActual();
    }

    @Override
    public Actividad getActividad(Actividad actividad) {
        return actividadDao.findById(actividad.getIdActividad()).orElse(null);
    }

    @Override
    public void save(Actividad actividad) { 
        actividadDao.save(actividad);
    }

    @Override
    public void delete(Actividad actividad) {
        actividadDao.delete(actividad);
    }

}
