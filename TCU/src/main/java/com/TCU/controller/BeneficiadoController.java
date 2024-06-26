/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.TCU.controller;

import com.TCU.domain.Beneficiado;
import com.TCU.service.BeneficiadoService;
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
@RequestMapping("/beneficiado")
public class BeneficiadoController {

    @Autowired
    BeneficiadoService beneficiadoService;

    @GetMapping("/listado")
    public String page(Model model) {
        List<Beneficiado> beneficiado = beneficiadoService.getBeneficiados(LocalDate.now());
        model.addAttribute("beneficiados", beneficiado);
        model.addAttribute("totalBeneficiados", beneficiado.size());
        return "beneficiado/listado";
    }

    @GetMapping("/filtrar")
    public String getBeneficiadosPorFecha(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaSeleccionada, Model model) {
        List<Beneficiado> filtro = beneficiadoService.getBeneficiados(fechaSeleccionada);

        YearMonth yearMonth = YearMonth.from(fechaSeleccionada);

        model.addAttribute("fecha", yearMonth);
        model.addAttribute("beneficiados", filtro);
        model.addAttribute("totalBeneficiados", filtro.size());
        return "beneficiado/filtro";
    }

    @RequestMapping("/modificar/{idBeneficiado}")
    public String modificar(Model model, Beneficiado beneficiado) {

        beneficiado = beneficiadoService.getBeneficiado(beneficiado);

        // Verificar si la fecha del beneficiado no es del mismo mes y año actual
        LocalDate now = LocalDate.now();
        if (beneficiado.getFecha().getMonthValue() != now.getMonthValue() || beneficiado.getFecha().getYear() != now.getYear()) {
            return "redirect:/beneficiado/listado";
        }

        model.addAttribute("beneficiado", beneficiado);
        model.addAttribute("fecha", beneficiado.getFecha().toString());

        return "beneficiado/modificar";

    }

    @RequestMapping("/nuevo")
    public String nuevo(Model model) {
        return "beneficiado/agregar";
    }

    @PostMapping("/guardar")
    public String guardar(Beneficiado beneficiado) {
        beneficiado.setEstado(true);
        beneficiado.setFecha(LocalDate.now());
        LocalDate fechaNacimiento = LocalDate.parse(beneficiado.getFechaNac());
        beneficiado.setEdad(Period.between(fechaNacimiento, LocalDate.now()).getYears());
        beneficiadoService.save(beneficiado);

        return "redirect:/beneficiado/listado";
    }

    @PostMapping("/actualizar")
    public String actualizar(Beneficiado beneficiado) {
        if (beneficiado.getFecha().getMonthValue() != LocalDate.now().getMonthValue()) {
            return "redirect:/beneficiado/listado";
        } else {
            LocalDate fechaNacimiento = LocalDate.parse(beneficiado.getFechaNac());
            beneficiado.setEdad(Period.between(fechaNacimiento, LocalDate.now()).getYears());
            beneficiadoService.save(beneficiado);
            return "redirect:/beneficiado/listado";
        }
    }

    @GetMapping("/eliminar/{idBeneficiado}")
    public String Eliminar(Beneficiado beneficiado) {

        beneficiado = beneficiadoService.getBeneficiado(beneficiado);

        // Verificar si la fecha del beneficiado no es del mismo mes y año actual
        LocalDate now = LocalDate.now();
        if (beneficiado.getFecha().getMonthValue() != now.getMonthValue() || beneficiado.getFecha().getYear() != now.getYear()) {
            return "redirect:/beneficiado/listado";
        }

        beneficiadoService.delete(beneficiado);

        return "redirect:/beneficiado/listado";
    }

}
