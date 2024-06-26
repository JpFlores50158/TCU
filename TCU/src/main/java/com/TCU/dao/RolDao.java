package com.TCU.dao;

import com.TCU.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol, Long>{
    
    
    Rol findByIdRol(Long idRol);
    
}
