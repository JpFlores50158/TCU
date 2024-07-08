package com.TCU.service.impl; 

import com.TCU.dao.RolDao;
import com.TCU.domain.Rol;
import com.TCU.service.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService {
    
    @Autowired
    RolDao rolDao;

    @Override
    @Transactional(readOnly = true)        
    public List<Rol> getRoles() {
       return rolDao.findAll();
    }

    @Override
    public Rol obtenerRolPorId(Long idRol) {
       return rolDao.findByIdRol(idRol);
    }
    
    

    
}
