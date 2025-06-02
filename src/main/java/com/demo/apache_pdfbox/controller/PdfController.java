package com.demo.apache_pdfbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.apache_pdfbox.service.PdfService;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @PostMapping("/create")
    public String createPdf(@RequestBody String text, @RequestParam String path) {
        try {
            pdfService.createPdf(text, path);
            return "PDF created at: " + path;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/read")
    public String readPdf(@RequestParam String path) {
        try {
            return pdfService.extractText(path);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
