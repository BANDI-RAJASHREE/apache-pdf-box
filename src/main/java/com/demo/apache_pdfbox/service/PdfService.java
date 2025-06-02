package com.demo.apache_pdfbox.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.demo.apache_pdfbox.service.impl.PDFServiceImpl;

@Service
public class PdfService {
	public void createPdf(String content,String filePath) throws IOException{
		PDFServiceImpl.writeTextToPdf(filePath, content);
		
	}
	
	public String extractText(String filePath) throws IOException{
		return PDFServiceImpl.readTextFromPdf(filePath);
	}
}
