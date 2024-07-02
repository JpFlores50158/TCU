/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.TCU.controller;

import com.TCU.domain.Beneficiado;
import com.TCU.domain.Actividad;
import com.TCU.service.BeneficiadoService;
import com.TCU.service.ActividadService;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jp09f
 */
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


        if (idUsuario == null) {
            return "redirect:/actividad/exito"; 
        }
        actividadService.save(actividad);

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
