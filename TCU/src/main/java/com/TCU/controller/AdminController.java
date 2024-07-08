package com.TCU.controller;

import com.TCU.domain.Rol;
import com.TCU.domain.Usuario;
import com.TCU.service.RolService;
import com.TCU.service.UsuarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;


    @GetMapping("/usuarios/listado")
    public String page(Model model) {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "admin/listado";
    }

    @RequestMapping("/usuarios/modificar/{idUsuario}")
    public String modificar(Model model, Usuario usuario) {
        usuario = usuarioService.getUsuario(usuario);
        List<Rol> roles = rolService.getRoles();
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", roles);
        return "admin/modificar";
    }
    
    @RequestMapping("/usuarios/nuevo")
    public String nuevo(Model model) { 
        List<Rol> roles = rolService.getRoles();
        model.addAttribute("roles", roles);
        return "admin/agregar";
    }
     @PostMapping("/usuarios/agregar")
    public String agregar(Usuario usuario) {

        Rol nuevoRol = rolService.obtenerRolPorId(usuario.getRol().getIdRol());
        usuario.setRol(nuevoRol);
         usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        usuarioService.save(usuario);

        return "redirect:/admin/usuarios/listado";
    }

    @PostMapping("/usuarios/guardar")
    public String guardar(Usuario usuario) {

        Rol nuevoRol = rolService.obtenerRolPorId(usuario.getRol().getIdRol());
        usuario.setRol(nuevoRol);

       if (usuario.getPassword()== null || usuario.getPassword().isEmpty() || "".equals(usuario.getPassword())) {
            var temp = usuarioService.getUsuario(usuario);
            usuario.setPassword(temp.getPassword());
            usuario.setUsername(temp.getUsername());
           
        } else {
            usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        }

     
        usuarioService.save(usuario);

        return "redirect:/admin/usuarios/listado";
    } 
    @GetMapping("/usuarios/eliminar/{idUsuario}")
    public String Eliminar(Usuario usuario) {

        usuarioService.delete(usuario);

        return "redirect:/admin/usuarios/listado";
    }

}
