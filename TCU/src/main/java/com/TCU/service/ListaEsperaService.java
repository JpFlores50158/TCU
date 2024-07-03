package com.TCU.service;

import com.TCU.domain.ListaEspera;
import java.time.LocalDate;
import java.util.List;

public interface ListaEsperaService {
    
   
    public List<ListaEspera> getListaEsperaTodos();
      
    public ListaEspera getListaEspera(ListaEspera listaEspera);
    
    public void save(ListaEspera listaEspera);
    
    public void delete(ListaEspera listaEspera);
    
    public List<ListaEspera> getListaEsperaPrioridadDesc();
}
