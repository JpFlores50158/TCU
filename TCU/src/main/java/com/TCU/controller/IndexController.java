
package com.TCU.controller;

import com.TCU.dao.UsuarioDao;

import com.TCU.domain.Usuario;

import com.TCU.service.impl.ReporteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private ReporteService reporteService;

    @RequestMapping("/")
    public String page(Model model, HttpSession httpSession) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = (principal instanceof UserDetails) ? (UserDetails) principal : null;

        if (user != null) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            httpSession.setAttribute("IdUsuario", usuario.getIdUsuario());
            httpSession.setAttribute("Usuario", usuario.getUsername());
            httpSession.setAttribute("Nombre", usuario.getNombreUsuario());
            httpSession.setAttribute("PriApellido", usuario.getPrimerApellido());
            httpSession.setAttribute("SegApellido", usuario.getSegundoApellido());
            httpSession.setAttribute("Correo", usuario.getCorreo());
            httpSession.setAttribute("Telefono", usuario.getTelefono());
            httpSession.setAttribute("password", usuario.getPassword());
            httpSession.setAttribute("Rol", usuario.getRol().getNombreRol());
        }

        var sumaAyuda = Double.parseDouble(reporteService.getSumaAyuda());
        var promedioAyuda = Double.parseDouble(reporteService.getPromedioAyuda()); 
        var cantidadXDecada = reporteService.getPromedioEdadDecada();
        var totalHyM = reporteService.getCountBySexo();
        var sumaBitacora = reporteService.getSumaBitacora();
        var CantActXOrg = reporteService.getCantActXOrg();
        var ActividadResumenByYearAndTipo = reporteService.getActividadResumenByYearAndTipo();
        var AverageParticipants = reporteService.getAverageParticipantsByTipoActividad();
        var grafico = reporteService.getGrafico();
        
        
         model.addAttribute("grafico", grafico);
        model.addAttribute("sumaAyuda", sumaAyuda);
        model.addAttribute("promedioAyuda", promedioAyuda);
        model.addAttribute("cantidadXDecada", cantidadXDecada);
        model.addAttribute("totalesHyM", totalHyM);
        model.addAttribute("sumaBitacora", sumaBitacora);
        model.addAttribute("CantActXOrg", CantActXOrg);
        model.addAttribute("ActividadResumenByYearAndTipo", ActividadResumenByYearAndTipo);
        model.addAttribute("AverageParticipants", AverageParticipants);

        return "index";
    }

}
