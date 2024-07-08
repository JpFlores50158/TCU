
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
    private BeneficiadoService beneficiadoService;

    @Autowired
    private PensionService pensionService;

    @Autowired
    private AyudaService ayudaService;

    public ByteArrayInputStream generateBeneficiadosExcel() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-yyyy");
        String monthYear = currentDate.format(dateFormatter);

        List<Beneficiado> beneficiados = beneficiadoService.getBeneficiadosOrdenado(currentDate);
        List<Pension> pensiones = pensionService.getPensiones(currentDate);
        List<Ayuda> ayudas = ayudaService.getAyudas(currentDate);

        try (Workbook workbook = new XSSFWorkbook()) {
            String sheetName = "Planilla CONAPAM Red de Heredia-  " + monthYear;
            Sheet sheet = workbook.createSheet(sheetName);

            // Headers
            String[] headers = {"Nombre_completo", "Nombre_1", "Apellido_1", "Apellido_2", "Tipo_Identific", "Num_identifica", "Fecha_Nac", "Edad", "Sexo", "Modalidad", "T_Pension", "Mont_pension", "Ley9188_Est_actual_activo", "Ley7972_Est_actual_activo", "tipo_ingre_fallec", "Fecha_Ingr_fallec", "Ley7972_Monto_ayuda", "Ley9188_Monto_ayuda", "Mes_lista", "Fiscalizador", "Sinirube", "ALIMENTACION", "ARTICULOS DE USO PERSONAL E HIGIENE", "ATENCION SOCIAL EN SALUD INTEGRAL", "PRODUCTOS DE APOYO O AYUDAS TECNICAS", "EQUIPAMIENTO DE CASA", "ALQUILER DE VIVIENDA, SERVICIOS BASICOS Y MUNICIPALES", "FAMILIAS SOLIDARIAS", "ASISTENTE DOMICILIAR"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.getCellStyle().setAlignment(HorizontalAlignment.RIGHT);
            }

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
                        row.createCell(14).setCellValue(pension.getTipoIngreFallec()); // Usar tipoIngreFallec
                        row.createCell(15).setCellValue(pension.getFechaIngresoFallecimiento());

                        row.createCell(18).setCellValue(pension.getMesLista().format(dateFormatter2));
                        row.createCell(19).setCellValue(pension.getFiscalizador());
                        row.createCell(20).setCellValue(pension.getSinerube());
                        break;
                    }
                }

                // Buscar la ayuda correspondiente al beneficiado
                for (Ayuda ayuda : ayudas) {
                    if (ayuda.getBeneficiado().getIdBeneficiado().equals(beneficiado.getIdBeneficiado())) {
                        row.createCell(16).setCellValue(ayuda.getLey7972MontoAyuda());
                        row.createCell(17).setCellValue(ayuda.getLey9188MontoAyuda());
                        row.createCell(21).setCellValue(ayuda.getAlimentacion());
                        row.createCell(22).setCellValue(ayuda.getArticulosUsoPersonalHigiene());
                        row.createCell(23).setCellValue(ayuda.getAtencionSocialSaludIntegral());
                        row.createCell(24).setCellValue(ayuda.getProductosApoyoAyudasTecnicas());
                        row.createCell(25).setCellValue(ayuda.getEquipamientoCasa());
                        row.createCell(26).setCellValue(ayuda.getAlquilerViviendaServiciosBasicos());
                        row.createCell(27).setCellValue(ayuda.getFamiliasSolidarias());
                        row.createCell(28).setCellValue(ayuda.getAsistenteDomiciliar());
                        break;
                    }
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
