package com.TCU.controller;
import com.TCU.domain.Actividad;
import com.TCU.service.ActividadService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    ActividadService actividadService;

    @GetMapping("/listado")
    public String page(Model model) {
        List<Actividad> actividades = actividadService.getActividades();
        model.addAttribute("actividades", actividades);

        return "actividad/listado";
    }

    @RequestMapping("/modificar/{idActividad}")
    public String modificar(Model model, Actividad actividad) {

        actividad = actividadService.getActividad(actividad);
        
        model.addAttribute("fecha", actividad.getFecha().toString());
        model.addAttribute("actividad", actividad);

        return "actividad/modificar";

    }

    @RequestMapping("/nuevo")
    public String nuevo(Model model) {

        return "actividad/agregar";
    }

    @PostMapping("/guardar")
    public String guardar(Actividad actividad, HttpSession httpSession) {

        String idUsuario = (String)  httpSession.getAttribute("Usuario");
        actividadService.save(actividad);

        if (idUsuario == null) {
             
            return "redirect:/actividad/exito"; 
        }
        

        return "redirect:/actividad/listado";
    }

    @PostMapping("/actualizar")
    public String actualizar(Actividad actividad) {

        actividadService.save(actividad);
        return "redirect:/actividad/listado";

    }

    @GetMapping("/eliminar/{idActividad}")
    public String Eliminar(Actividad actividad) {

        actividadService.delete(actividad);

        return "redirect:/actividad/listado";
    }
     @RequestMapping("/exito")
    public String exito() {

        return "actividad/exito";
    }

}
