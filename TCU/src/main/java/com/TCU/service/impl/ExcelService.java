/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TCU.service.impl;

import com.TCU.domain.Ayuda;
import com.TCU.domain.Beneficiado;
import com.TCU.domain.Pension;
import com.TCU.service.AyudaService;
import com.TCU.service.BeneficiadoService;
import com.TCU.service.PensionService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

/**
 *
 * @author jp09f
 */
@Service
public class ExcelService {

    @Autowired
    private BeneficiadoService beneficiadoService;

    @Autowired
    private PensionService pensionService;

    @Autowired
    private AyudaService ayudaService;

    public ByteArrayInputStream generateBeneficiadosExcel() {
         LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-yyyy");
        String monthYear = currentDate.format(dateFormatter);

        List<Beneficiado> beneficiados = beneficiadoService.getBeneficiados(currentDate);
        List<Pension> pensiones = pensionService.getPensiones(currentDate);
        List<Ayuda> ayudas = ayudaService.getAyudas(currentDate);

        try (Workbook workbook = new XSSFWorkbook()) {
            String sheetName = "Planilla CONAPAM Red de Heredia-  " + monthYear;
            Sheet sheet = workbook.createSheet(sheetName);

            // Crear encabezados
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Nombre_completo");
            headerRow.createCell(1).setCellValue("Nombre_1");
            headerRow.createCell(2).setCellValue("Apellido_1");
            headerRow.createCell(3).setCellValue("Apellido_2");
            headerRow.createCell(4).setCellValue("Tipo_Identific");
            headerRow.createCell(5).setCellValue("Num_identifica");
            headerRow.createCell(6).setCellValue("Fecha_Nac");
            headerRow.createCell(7).setCellValue("Edad");
            headerRow.createCell(8).setCellValue("Sexo");
            headerRow.createCell(9).setCellValue("Modalidad");
            headerRow.createCell(10).setCellValue("T_Pension");
            headerRow.createCell(11).setCellValue("Mont_pension");
            headerRow.createCell(12).setCellValue("Ley9188_Est_actual_activo");
            headerRow.createCell(13).setCellValue("Ley7972_Est_actual_activo");
            headerRow.createCell(14).setCellValue("Fecha_Ingr_fallec");
            headerRow.createCell(15).setCellValue("Ley7972_Monto_ayuda");
            headerRow.createCell(16).setCellValue("Ley9188_Monto_ayuda");
            headerRow.createCell(17).setCellValue("Mes_lista");
            headerRow.createCell(18).setCellValue("Fiscalizador");
            headerRow.createCell(19).setCellValue("Sinirube");
            headerRow.createCell(20).setCellValue("ALIMENTACION");
            headerRow.createCell(21).setCellValue("ARTICULOS DE USO PERSONAL E HIGIENE");
            headerRow.createCell(22).setCellValue("ATENCION SOCIAL EN SALUD INTEGRAL");
            headerRow.createCell(23).setCellValue("PRODUCTOS DE APOYO O AYUDAS TECNICAS");
            headerRow.createCell(24).setCellValue("EQUIPAMIENTO DE CASA");
            headerRow.createCell(25).setCellValue("ALQUILER DE VIVIENDA, SERVICIOS BASICOS Y MUNICIPALES");
            headerRow.createCell(26).setCellValue("FAMILIAS SOLIDARIAS");
            headerRow.createCell(27).setCellValue("ASISTENTE DOMICILIAR");

            DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            int rowIndex = 1;
            for (Beneficiado beneficiado : beneficiados) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(beneficiado.getNombre1() + " " + beneficiado.getApellido1() + " " + beneficiado.getApellido2());
                row.createCell(1).setCellValue(beneficiado.getNombre1());
                row.createCell(2).setCellValue(beneficiado.getApellido1());
                row.createCell(3).setCellValue(beneficiado.getApellido2());
                row.createCell(4).setCellValue(beneficiado.getTipoIdentificacion());
                row.createCell(5).setCellValue(beneficiado.getNumIdentificacion());
                row.createCell(6).setCellValue(beneficiado.getFechaNac());
                row.createCell(7).setCellValue(beneficiado.getEdad());
                row.createCell(8).setCellValue(beneficiado.getSexo());
                row.createCell(9).setCellValue(beneficiado.getModalidad());

                // Buscar la pensión correspondiente al beneficiado
                for (Pension pension : pensiones) {
                    if (pension.getBeneficiado().getIdBeneficiado().equals(beneficiado.getIdBeneficiado())) {
                        row.createCell(10).setCellValue(pension.getTipoPension());
                        row.createCell(11).setCellValue(pension.getMontoPension());
                        row.createCell(12).setCellValue(pension.isLey9188EstadoActualActivo());
                        row.createCell(13).setCellValue(pension.isLey7972EstadoActualActivo());
                        row.createCell(14).setCellValue(pension.getFechaIngresoFallecimiento());
                        row.createCell(17).setCellValue(pension.getMesLista().format(dateFormatter2));
                        row.createCell(18).setCellValue(pension.getFiscalizador());
                        row.createCell(19).setCellValue(pension.getSinerube());
                        break;
                    }
                }

                // Buscar la ayuda correspondiente al beneficiado
                for (Ayuda ayuda : ayudas) {
                    if (ayuda.getBeneficiado().getIdBeneficiado().equals(beneficiado.getIdBeneficiado())) {
                        row.createCell(15).setCellValue(ayuda.getLey7972MontoAyuda());
                        row.createCell(16).setCellValue(ayuda.getLey9188MontoAyuda());
                        row.createCell(20).setCellValue(ayuda.getAlimentacion());
                        row.createCell(21).setCellValue(ayuda.getArticulosUsoPersonalHigiene());
                        row.createCell(22).setCellValue(ayuda.getAtencionSocialSaludIntegral());
                        row.createCell(23).setCellValue(ayuda.getProductosApoyoAyudasTecnicas());
                        row.createCell(24).setCellValue(ayuda.getEquipamientoCasa());
                        row.createCell(25).setCellValue(ayuda.getAlquilerViviendaServiciosBasicos());
                        row.createCell(26).setCellValue(ayuda.getFamiliasSolidarias());
                        row.createCell(27).setCellValue(ayuda.getAsistenteDomiciliar());
                        break;
                    }
                }
            }

            // Convertir el libro de trabajo a un array de bytes para la descarga
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate Excel file", e);
        }
    }
}
