package com.TCU.service;

import com.TCU.domain.Pension;
import java.time.LocalDate;
import java.util.List;

public interface PensionService {
    
    public List<Pension> getPensiones(LocalDate date);
      
    public Pension getPension(Pension pension);
    
    public void save(Pension pension);
    
    public void delete(Pension pension);
    
     public void updateAllPensionesFecha(LocalDate newDate);
    
}
