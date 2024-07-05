/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.TCU.controller;

import com.TCU.domain.Beneficiado;
import com.TCU.domain.ListaEspera;
import com.TCU.service.BeneficiadoService;
import com.TCU.service.ListaEsperaService;
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
@RequestMapping("/listaEspera")
public class ListaEsperaController {

    @Autowired
    ListaEsperaService listaEsperaService;

    @Autowired
    BeneficiadoService beneficiadoService;

    @GetMapping("/listado")
    public String page(Model model) {
        List<ListaEspera> listaEsperaTodo = listaEsperaService.getListaEsperaPrioridadDesc();
        model.addAttribute("listaEsperaTodo", listaEsperaTodo);

        return "listaEspera/listado";
    }

    @RequestMapping("/modificar/{idListaEspera}")
    public String modificar(Model model, ListaEspera listaEspera) {

        listaEspera = listaEsperaService.getListaEspera(listaEspera);
        model.addAttribute("listaEspera", listaEspera);

        return "listaEspera/modificar";

    }

    @RequestMapping("/nuevo")
    public String nuevo(Model model) {

        return "listaEspera/agregar"; 
    }

    @PostMapping("/guardar")
    public String guardar(ListaEspera listaEspera) {

        LocalDate fechaNacimiento = LocalDate.parse(listaEspera.getFechaNacimiento());
        listaEspera.setEdad(Period.between(fechaNacimiento, LocalDate.now()).getYears());
        listaEspera.setSinirubreEstadoJustificacion("Lista Espera");
        listaEsperaService.save(listaEspera);
        return "redirect:/listaEspera/listado";
    }

    @PostMapping("/actualizar")
    public String actualizar(ListaEspera listaEspera) {
        LocalDate fechaNacimiento = LocalDate.parse(listaEspera.getFechaNacimiento());
        listaEspera.setEdad(Period.between(fechaNacimiento, LocalDate.now()).getYears());

        listaEsperaService.save(listaEspera);
        return "redirect:/listaEspera/listado";

    }

    @GetMapping("/eliminar/{idListaEspera}")
    public String Eliminar(ListaEspera listaEspera) {

        listaEsperaService.delete(listaEspera);

        return "redirect:/listaEspera/listado";
    }

    @GetMapping("/listadoTodos")
    public String todos(Model model) {
        List<ListaEspera> listaEsperaTodo = listaEsperaService.getListaEsperaTodos();
        model.addAttribute("listaEsperaTodo", listaEsperaTodo);

        return "listaEspera/listadoTodos";
    }

    @RequestMapping("/mandar/{idListaEspera}")
    public String enviar(Model model, ListaEspera listaEspera, Beneficiado beneficiado) {

        var resultado = listaEsperaService.getListaEspera(listaEspera);
        beneficiado.setNombre1(resultado.getNombre());
        beneficiado.setApellido1(resultado.getPrimerApellido());
        beneficiado.setApellido2(resultado.getSegundoApellido());
        beneficiado.setTipoIdentificacion("Cedula");
        beneficiado.setNumIdentificacion(resultado.getNoCedula());
        beneficiado.setFechaNac(resultado.getFechaNacimiento());
        beneficiado.setEdad(resultado.getEdad());
        beneficiado.setSexo("M");
         beneficiado.setModalidad("Red de Cuido");
         beneficiado.setFecha(LocalDate.now());
         beneficiado.setUltimaValoracion(LocalDate.now().toString());
       beneficiado.setEstado(true);
          
        beneficiadoService.save(beneficiado);
        resultado.setSinirubreEstadoJustificacion("Pasada a beneficiado");
         listaEsperaService.save(resultado);

        return "redirect:/beneficiado/listado";

    }

}
