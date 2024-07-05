/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TCU.service.impl;

import com.TCU.dao.ActividadDao;
import com.TCU.dao.BeneficiadoDao;
import com.TCU.dao.GraficoDao;
import com.TCU.dao.PromedioEdadDecadaDao;
import com.TCU.domain.Actividad;
import com.TCU.domain.Ayuda;
import com.TCU.domain.Grafico;

import com.TCU.domain.PromedioEdadDecada;
import com.TCU.service.ActividadService;
import com.TCU.service.AyudaService;
import java.text.DecimalFormat;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import org.hibernate.engine.jdbc.Size;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReporteService {

    @Autowired
    private BeneficiadoDao beneficiadoDao;

    @Autowired
    private AyudaService ayudaService;

    @Autowired
    private ActividadDao actividadDao;

    @Autowired
    private PromedioEdadDecadaDao promedioEdadDecadaDao;
     @Autowired
    private GraficoDao graficoDao;
    
    
    

    public List<List<Object>> getCountBySexo() {
        List<Object[]> rawData = beneficiadoDao.countBySexo();
        return rawData.stream()
                .map(result -> {
                    List<Object> entry = new ArrayList<>();
                    entry.add(result[0]); // Sexo
                    entry.add(result[1]); // Count
                    return entry;
                })
                .collect(Collectors.toList());
    }

    public List<PromedioEdadDecada> getPromedioEdadDecada() {
        return promedioEdadDecadaDao.PromedioEdadDecada();
    }
     public List<Grafico> getGrafico() {
        return graficoDao.grafico();
    }

    public String getPromedioAyuda() {
        List<Ayuda> ayudas = ayudaService.getAyudas(LocalDate.now());

        double promedioFinal = ayudas.stream()
                .mapToDouble(Ayuda::getLey9188MontoAyuda)
                .average()
                .orElse(0.0);

        return new DecimalFormat("#.##").format(promedioFinal);
    }

    public String getSumaAyuda() {
        List<Ayuda> ayudas = ayudaService.getAyudas(LocalDate.now());

        double sumaTotal = ayudas.stream()
                .mapToDouble(Ayuda::getLey9188MontoAyuda)
                .sum();

        return new DecimalFormat("#.##").format(sumaTotal);
    }

    public String getSumaBitacora() {
        List<Actividad> actividades = actividadDao.findActividadesDelAnoActual();

        int sumaTotal = actividades.stream()
                .mapToInt(a -> a.getNinos0a5() + a.getNinos5a12() + a.getAdolescentes()
                        + a.getAdultoHombre() + a.getAdultoMujer() + a.getPersonasMayores65())
                .sum();

        return new DecimalFormat("#.##").format(sumaTotal);
    }

    public List<List<Object>> getCantActXOrg() {
        List<Object[]> rawData = actividadDao.countByOrganizacionAndAnio();
        return rawData.stream()
                .map(result -> {
                    List<Object> entry = new ArrayList<>();
                    entry.add(result[0]); // Organizacion
                    entry.add(result[1]); // Año
                    entry.add(result[2]); // Count
                    return entry;
                })
                .collect(Collectors.toList());
    }

    public List<List<Object>> getActividadResumenByYearAndTipo() {
        List<Object[]> rawData = actividadDao.findActividadResumenByYearAndTipo();
        return rawData.stream()
                .map(result -> {
                    List<Object> entry = new ArrayList<>();
                    entry.add(result[0]); // Año
                    entry.add(result[1]); // Tipo Actividad
                    entry.add(result[2]); // Cantidad Actividades
                    return entry;
                })
                .collect(Collectors.toList());
    }

    public List<List<Object>> getAverageParticipantsByTipoActividad() {
        List<Object[]> rawData = actividadDao.findAverageParticipantsByTipoActividad();
        return rawData.stream()
                .map(result -> {
                    List<Object> entry = new ArrayList<>();
                    entry.add(result[0]); // Tipo Actividad
                    for (int i = 1; i < result.length; i++) {
                        entry.add(new DecimalFormat("#.##").format(result[i])); // Promedios formateados
                    }
                    return entry;
                })
                .collect(Collectors.toList());
    }
    
    
  
}
