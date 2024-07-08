
package com.TCU.service.impl;

import com.TCU.dao.ListaEsperaDao;
import com.TCU.domain.ListaEspera;
import com.TCU.service.ListaEsperaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ListaEsperaServiceImpl implements ListaEsperaService {

    @Autowired
    ListaEsperaDao listaEsperaDao;

    @Override
    @Transactional(readOnly = true)
    public List<ListaEspera> getListaEsperaTodos() {
        return listaEsperaDao.findAll();
    }

    @Override
    public ListaEspera getListaEspera(ListaEspera listaEspera) {
        return listaEsperaDao.findById(listaEspera.getIdListaEspera()).orElse(null);
    }

    @Override
    public void save(ListaEspera listaEspera) {
        listaEsperaDao.save(listaEspera);
    }

    @Override
    public void delete(ListaEspera listaEspera) {
        listaEsperaDao.delete(listaEspera);
    }

    @Override
    public List<ListaEspera> getListaEsperaPrioridadDesc() {
       return listaEsperaDao.findAllByPrioridadDescAndSinirubeEstado();
    }

}
