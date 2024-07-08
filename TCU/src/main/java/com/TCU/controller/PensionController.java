
package com.TCU.controller;

import com.TCU.domain.Beneficiado;
import com.TCU.domain.Pension;
import com.TCU.service.BeneficiadoService;
import com.TCU.service.PensionService;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pension")
public class PensionController {

    @Autowired
    PensionService pensionService;
    @Autowired
    BeneficiadoService beneficiadoService;

    @GetMapping("/listado")
    public String page(Model model) {
        List<Pension> pensiones = pensionService.getPensiones(LocalDate.now());
        model.addAttribute("pensiones", pensiones);
        List<Beneficiado> beneficiados = beneficiadoService.getTodos();
        model.addAttribute("beneficiados", beneficiados);
        model.addAttribute("totalPensiones", pensiones.size());
        return "pension/listado";
    }

    @GetMapping("/filtrar")
    public String getPensionsPorFecha(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaSeleccionada, Model model) {
        List<Pension> filtro = pensionService.getPensiones(fechaSeleccionada);

        YearMonth yearMonth = YearMonth.from(fechaSeleccionada);

        model.addAttribute("fecha", yearMonth);
        model.addAttribute("pensiones", filtro);
        List<Beneficiado> beneficiados = beneficiadoService.getTodos();
        model.addAttribute("beneficiados", beneficiados);
        model.addAttribute("totalPensions", filtro.size());
        return "pension/filtro";
    }

    @RequestMapping("/modificar/{idPension}")
    public String modificar(Model model, Pension pension) {

        pension = pensionService.getPension(pension);

        LocalDate now = LocalDate.now();
        List<Beneficiado> beneficiados = beneficiadoService.getBeneficiados(LocalDate.now());

        if (pension.getMesLista().getMonthValue() != now.getMonthValue() || pension.getMesLista().getYear() != now.getYear()) {
            return "redirect:/pension/listado";
        }

        model.addAttribute("beneficiados", beneficiados);
        model.addAttribute("pension", pension);
        model.addAttribute("mesLista", pension.getMesLista().toString());

        return "pension/modificar";

    }

    @RequestMapping("/nuevo")
    public String nuevo(Model model) {
        List<Beneficiado> beneficiados = beneficiadoService.findAllBeneficiadosWithoutPensionInMonth();
        model.addAttribute("beneficiados", beneficiados);
        return "pension/agregar";
    }

    @PostMapping("/guardar")
    public String guardar(Pension pension) {
        Beneficiado beneficiado = beneficiadoService.getBeneficiado(pension.getBeneficiado());

        LocalDate fecha = beneficiado.getFecha();
        pension.setMesLista(fecha);
        pension.setEstado(true);
        pensionService.save(pension);

        return "redirect:/pension/listado";
    }

    @PostMapping("/actualizar")
    public String actualizar(Pension pension) {

        Beneficiado beneficiado = beneficiadoService.getBeneficiado(pension.getBeneficiado());
        LocalDate fecha = beneficiado.getFecha();
        pension.setMesLista(fecha);
        pensionService.save(pension);
        return "redirect:/pension/listado";

    }

    @GetMapping("/eliminar/{idPension}")
    public String Eliminar(Pension pension) {

        pension = pensionService.getPension(pension);

        // Verificar si la fecha del pension no es del mismo mes y año actual
        LocalDate now = LocalDate.now();
        if (pension.getMesLista().getMonthValue() != now.getMonthValue() || pension.getMesLista().getYear() != now.getYear()) {
            return "redirect:/pension/listado";
        }

        pensionService.delete(pension);

        return "redirect:/pension/listado";
    }
    
     @GetMapping("/actualizarTodo")
    public String actualizarTodo() {

      pensionService.updateAllPensionesFecha(LocalDate.now());

        return "redirect:/pension/listado";
    }

}
