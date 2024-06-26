package com.TCU.service;

import com.TCU.domain.Pension;
import java.time.LocalDate;
import java.util.List;

public interface PensionService {
    
    public List<Pension> getPensiones(LocalDate date);
      
    public Pension getPension(Pension Pension);
    
    public void save(Pension Pension);
    
    public void delete(Pension Pension);
    
}
