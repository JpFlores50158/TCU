package com.TCU.controller;

import com.TCU.dao.UsuarioDao;

import com.TCU.domain.Usuario;

import com.TCU.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
@RequestMapping("/perfil")
@Slf4j
public class PerfilController {

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/mostrar")
    public String PageMostrar(Model model, HttpSession httpSession) {
        model.addAttribute("idUsuario", httpSession.getAttribute("IdUsuario"));
        model.addAttribute("Usuario", httpSession.getAttribute("Usuario"));
        model.addAttribute("Nombre", httpSession.getAttribute("Nombre"));
        model.addAttribute("PriApellido", httpSession.getAttribute("PriApellido"));
        model.addAttribute("SegApellido", httpSession.getAttribute("SegApellido"));
        model.addAttribute("Correo", httpSession.getAttribute("Correo"));
        model.addAttribute("Telefono", httpSession.getAttribute("Telefono"));
        model.addAttribute("Rol", httpSession.getAttribute("Rol"));

        return "/perfil/mostrar";
    }

    @RequestMapping("/editar")
    public String PageEditar(Model model, HttpSession httpSession) {
        model.addAttribute("idUsuario", httpSession.getAttribute("IdUsuario"));
        model.addAttribute("Usuario", httpSession.getAttribute("Usuario"));
        model.addAttribute("Nombre", httpSession.getAttribute("Nombre"));
        model.addAttribute("PriApellido", httpSession.getAttribute("PriApellido"));
        model.addAttribute("SegApellido", httpSession.getAttribute("SegApellido"));
        model.addAttribute("Correo", httpSession.getAttribute("Correo"));
        model.addAttribute("Telefono", httpSession.getAttribute("Telefono"));

        model.addAttribute("password", httpSession.getAttribute("password"));
        return "/perfil/editar";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(Usuario usuario, HttpSession httpSession) {
        if (usuario.getIdUsuario() != null && usuario.getIdUsuario() > 0) {
            var temp = usuarioService.getUsuario(usuario);
            usuario.setPassword(temp.getPassword());
            usuario.setUsername(temp.getUsername());

        } else {
            usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        }

        usuarioDao.save(usuario);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDetails user = null;

        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;
        }

        if (user != null) {
            Usuario usuariohttp = usuarioDao.findByUsername(user.getUsername());

            httpSession.setAttribute("IdUsuario", usuariohttp.getIdUsuario());
            httpSession.setAttribute("Usuario", usuariohttp.getUsername());
            httpSession.setAttribute("Nombre", usuariohttp.getNombreUsuario());
            httpSession.setAttribute("PriApellido", usuariohttp.getPrimerApellido());
            httpSession.setAttribute("SegApellido", usuariohttp.getSegundoApellido());
            httpSession.setAttribute("Correo", usuariohttp.getCorreo());
            httpSession.setAttribute("Telefono", usuariohttp.getTelefono());

            httpSession.setAttribute("password", usuariohttp.getPassword());

        }
        return "redirect:/perfil/mostrar";
    }

}
