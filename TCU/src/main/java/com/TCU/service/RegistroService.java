package com.TCU.service;

import com.TCU.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;

public interface RegistroService {

  

    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException;

    
}
