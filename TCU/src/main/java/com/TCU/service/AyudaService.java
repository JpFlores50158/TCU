package com.TCU.service;

import com.TCU.domain.Ayuda;
import java.time.LocalDate;
import java.util.List;

public interface AyudaService {
    
   
    public List<Ayuda> getAyudas(LocalDate date);
      
    public Ayuda getAyuda(Ayuda ayuda);
    
    public void save(Ayuda ayuda);
    
    public void delete(Ayuda ayuda);
    
}
