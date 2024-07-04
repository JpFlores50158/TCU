/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.TCU.controller;

import com.TCU.domain.Beneficiado;
import com.TCU.domain.Ayuda;
import com.TCU.service.BeneficiadoService;
import com.TCU.service.AyudaService;
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
@RequestMapping("/ayuda")
public class AyudaController {

    @Autowired
    AyudaService ayudaService;
    @Autowired
    BeneficiadoService beneficiadoService;

    @GetMapping("/listado")
    public String page(Model model) {
        List<Ayuda> ayudaes = ayudaService.getAyudas(LocalDate.now());
        model.addAttribute("ayudas", ayudaes);
        List<Beneficiado> beneficiados = beneficiadoService.getTodos();
        model.addAttribute("beneficiados", beneficiados);
        model.addAttribute("totalAyudas", ayudaes.size());
        return "ayuda/listado";
    }

    @GetMapping("/filtrar")
    public String getAyudasPorFecha(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaSeleccionada, Model model) {
        List<Ayuda> filtro = ayudaService.getAyudas(fechaSeleccionada);

        YearMonth yearMonth = YearMonth.from(fechaSeleccionada);

        model.addAttribute("fecha", yearMonth);
        model.addAttribute("ayudas", filtro);
        List<Beneficiado> beneficiados = beneficiadoService.getTodos();
        model.addAttribute("beneficiados", beneficiados);
        model.addAttribute("totalAyudas", filtro.size());
        return "ayuda/filtro";
    }

    @RequestMapping("/modificar/{idAyuda}")
    public String modificar(Model model, Ayuda ayuda) {

        ayuda = ayudaService.getAyuda(ayuda);

        LocalDate now = LocalDate.now();
        List<Beneficiado> beneficiados = beneficiadoService.getBeneficiados(LocalDate.now());

        if (ayuda.getFecha().getMonthValue() != now.getMonthValue() || ayuda.getFecha().getYear() != now.getYear()) {
            return "redirect:/ayuda/listado";
        }

        model.addAttribute("beneficiados", beneficiados);
        model.addAttribute("ayuda", ayuda);
        model.addAttribute("mesLista", ayuda.getFecha().toString());

        return "ayuda/modificar";

    }

    @RequestMapping("/nuevo")
    public String nuevo(Model model) {
        List<Beneficiado> beneficiados = beneficiadoService.findAllBeneficiadosWithoutAyudaInMonth();
        model.addAttribute("beneficiados", beneficiados);
        return "ayuda/agregar";
    }

    @PostMapping("/guardar")
    public String guardar(Ayuda ayuda) {
        Beneficiado beneficiado = beneficiadoService.getBeneficiado(ayuda.getBeneficiado());

        LocalDate fecha = beneficiado.getFecha();
        ayuda.setFecha(fecha);
        ayuda.setEstado(true);

        double suma = ayuda.getAlimentacion()
                + ayuda.getArticulosUsoPersonalHigiene()
                + ayuda.getAtencionSocialSaludIntegral()
                + ayuda.getProductosApoyoAyudasTecnicas()
                + ayuda.getEquipamientoCasa()
                + ayuda.getAlquilerViviendaServiciosBasicos()
                + ayuda.getFamiliasSolidarias()
                + ayuda.getAsistenteDomiciliar();
        ayuda.setLey9188MontoAyuda(suma);
        ayudaService.save(ayuda);

        return "redirect:/ayuda/listado";
    }

    @PostMapping("/actualizar")
    public String actualizar(Ayuda ayuda) {

        Beneficiado beneficiado = beneficiadoService.getBeneficiado(ayuda.getBeneficiado());
        LocalDate fecha = beneficiado.getFecha();
        ayuda.setFecha(fecha);
        double suma = ayuda.getAlimentacion()
                + ayuda.getArticulosUsoPersonalHigiene()
                + ayuda.getAtencionSocialSaludIntegral()
                + ayuda.getProductosApoyoAyudasTecnicas()
                + ayuda.getEquipamientoCasa()
                + ayuda.getAlquilerViviendaServiciosBasicos()
                + ayuda.getFamiliasSolidarias()
                + ayuda.getAsistenteDomiciliar();
        ayuda.setLey9188MontoAyuda(suma);
        ayudaService.save(ayuda);
        return "redirect:/ayuda/listado";

    }

    @GetMapping("/eliminar/{idAyuda}")
    public String Eliminar(Ayuda ayuda) {

        ayuda = ayudaService.getAyuda(ayuda);

        // Verificar si la fecha del ayuda no es del mismo mes y año actual
        LocalDate now = LocalDate.now();
        if (ayuda.getFecha().getMonthValue() != now.getMonthValue() || ayuda.getFecha().getYear() != now.getYear()) {
            return "redirect:/ayuda/listado";
        }

        ayudaService.delete(ayuda);

        return "redirect:/ayuda/listado";
    }
    
     @GetMapping("/actualizarTodo")
    public String actualizarTodo() {

      ayudaService.updateAllAyudasFecha(LocalDate.now());

        return "redirect:/ayuda/listado";
    }

}
