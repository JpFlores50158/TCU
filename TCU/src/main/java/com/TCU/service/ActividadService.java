package com.TCU.service;

import com.TCU.domain.Actividad;

import java.util.List;

public interface ActividadService {
    
   
    public List<Actividad> getActividades();
      
    public Actividad getActividad(Actividad actividad);
    
    public void save(Actividad actividad);
    
    public void delete(Actividad actividad);
    
}
