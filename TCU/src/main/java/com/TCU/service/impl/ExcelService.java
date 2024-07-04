/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TCU.service.impl;


import com.TCU.domain.ExcelJoin;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/**
 *
 * @author jp09f
 */
@Service
public class ExcelService {
    
    
    @Autowired
    private JoinService joinService;

    public ByteArrayInputStream generateExcel() {
        
         LocalDate currentDate = LocalDate.now();
         DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("MM-yyyy");
        String monthYear = currentDate.format(dateFormatter2);
        try (Workbook workbook = new XSSFWorkbook()) {
            String sheetName = "Planilla CONAPAM Red de Heredia-  " + monthYear;
            Sheet sheet = workbook.createSheet(sheetName);

            // Headers
            String[] headers = {"Nombre_completo", "Nombre_1", "Apellido_1", "Apellido_2", "Tipo_Identific", "Num_identifica", "Fecha_Nac", "Edad", "Sexo", "Modalidad", "T_Pension", "Mont_pension", "Ley9188_Est_actual_activo", "Ley7972_Est_actual_activo", "Fecha_Ingr_fallec", "Ley7972_Monto_ayuda", "Ley9188_Monto_ayuda", "Mes_lista", "Fiscalizador", "Sinirube", "ALIMENTACION", "ARTICULOS DE USO PERSONAL E HIGIENE", "ATENCION SOCIAL EN SALUD INTEGRAL", "PRODUCTOS DE APOYO O AYUDAS TECNICAS", "EQUIPAMIENTO DE CASA", "ALQUILER DE VIVIENDA, SERVICIOS BASICOS Y MUNICIPALES", "FAMILIAS SOLIDARIAS", "ASISTENTE DOMICILIAR"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                 cell.getCellStyle().setAlignment(HorizontalAlignment.RIGHT);
            }

            // Data
            List<ExcelJoin> data = joinService.getDatos();
            
            int rowIndex = 1;
            for (ExcelJoin datos : data) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(datos.getNombre1() + " " + datos.getApellido1() + " " + datos.getApellido2());
                row.createCell(1).setCellValue(datos.getNombre1());
                row.createCell(2).setCellValue(datos.getApellido1());
                row.createCell(3).setCellValue(datos.getApellido2());
                row.createCell(4).setCellValue(datos.getTipoIdentificacion());
                row.createCell(5).setCellValue(datos.getNumIdentificacion());
                row.createCell(6).setCellValue(datos.getFechaNac());
                row.createCell(7).setCellValue(datos.getEdad());
                row.createCell(8).setCellValue(datos.getSexo()); 
                row.createCell(9).setCellValue(datos.getModalidad()); 
                row.createCell(10).setCellValue(datos.getTPension());
                row.createCell(11).setCellValue(datos.getMontPension());
                row.createCell(12).setCellValue(datos.getLey9188EstActualActivo());
                row.createCell(13).setCellValue(datos.getLey7972EstActualActivo());
                row.createCell(14).setCellValue(datos.getFechaIngrFallec());
                row.createCell(15).setCellValue(datos.getLey7972MontoAyuda());
                row.createCell(16).setCellValue(datos.getLey9188MontoAyuda());
                row.createCell(17).setCellValue(datos.getMesLista());
                row.createCell(18).setCellValue(datos.getFiscalizador());
                row.createCell(19).setCellValue(datos.getSinirube());
                row.createCell(20).setCellValue(datos.getAlimentacion());
                row.createCell(21).setCellValue(datos.getArticulosUsoPersonalHigiene());
                row.createCell(22).setCellValue(datos.getAtencionSocialSaludIntegral());
                row.createCell(23).setCellValue(datos.getProductosApoyoAyudasTecnicas());
                row.createCell(24).setCellValue(datos.getEquipamientoCasa());
                row.createCell(25).setCellValue(datos.getAlquilerViviendaServiciosBasicos());
                row.createCell(26).setCellValue(datos.getFamiliasSolidarias());
                row.createCell(27).setCellValue(datos.getAsistenteDomiciliar());
                
                  // Alinear todas las celdas hacia la derecha
                for (int i = 0; i < headers.length; i++) {
                    row.getCell(i).setCellStyle(sheet.getColumnStyle(i));
                }
            }
            
            // Autoajustar el tamaño de las columnas según el contenido
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
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
