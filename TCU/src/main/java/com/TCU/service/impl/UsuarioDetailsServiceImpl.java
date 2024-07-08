package com.TCU.service.impl;

import com.TCU.dao.UsuarioDao;
import com.TCU.domain.Usuario;
import com.TCU.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

     @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Busca el usuario en la base de datos
        Usuario usuario = usuarioDao.findByUsername(username);

        // Si el usuario no existe en la base de datos, lanza una excepción
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        // Limpia cualquier atributo de sesión relacionado con el usuario
        session.removeAttribute("usuarioImagen");

        // Obtiene el rol del usuario
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombreRol());

        // Retorna un objeto de tipo "User" con los datos necesarios
        return new User(usuario.getUsername(), usuario.getPassword(), Collections.singletonList(authority));
    }
}
