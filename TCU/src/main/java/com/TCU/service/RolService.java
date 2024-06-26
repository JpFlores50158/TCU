package com.TCU.service;

import com.TCU.domain.Rol;

import java.util.List;

public interface RolService {
    
    public List<Rol> getRoles();
    
    public Rol obtenerRolPorId(Long idRol);
    
}
