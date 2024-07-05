/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.TCU.controller;

import com.TCU.service.impl.ExcelService;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jp09f
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {
    
   @Autowired
    private ExcelService excelService;
   
    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadExcelFile() {
        ByteArrayInputStream bis = excelService.generateBeneficiadosExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=Planilla_CONAPAM_Red_de_Heredia-" + LocalDate.now().format(DateTimeFormatter.ofPattern("MM-yyyy")) + ".xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(bis));
    }
    
}
