package com.demo.apache_pdfbox.service.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFServiceImpl {

	public static void writeTextToPdf(String filePath, String text) throws IOException {
	    try (PDDocument document = new PDDocument()) {
	        PDPage page = new PDPage(PDRectangle.A4);
	        document.addPage(page);

	        PDFont font = PDType1Font.HELVETICA_BOLD;
	        float fontSize = 12;
	        float leading = 1.5f * fontSize;

	        PDRectangle pageSize = page.getMediaBox();
	        float margin = 50;
	        float width = pageSize.getWidth() - 2 * margin;
	        float startY = pageSize.getHeight() - margin;
	        float startX = margin;

	        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
	            contentStream.beginText();
	            contentStream.setFont(font, fontSize);
	            contentStream.setLeading(leading);
	            contentStream.newLineAtOffset(startX, startY);

	            List<String> lines = wrapText (text, font, fontSize, width);
	            for (String line : lines) {
	                contentStream.showText(line);
	                contentStream.newLine();
	            }

	            contentStream.endText();
	        }

	        document.save(filePath);
	    }
	}


    public static String readTextFromPdf(String filePath) throws IOException {
        try(PDDocument document=PDDocument.load(new File(filePath)))
        {
        	return new org.apache.pdfbox.text.PDFTextStripper().getText(document);
        }
    }
    
    public static List<String> wrapText(String text, PDFont font, float fontSize, float maxWidth) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String paragraph : text.split("\r?\n")) {
            StringBuilder line = new StringBuilder();
            for (String word : paragraph.split(" ")) {
                String testLine = line.length() == 0 ? word : line + " " + word;
                float size = font.getStringWidth(testLine) / 1000 * fontSize;
                if (size > maxWidth) {
                    lines.add(line.toString());
                    line = new StringBuilder(word);
                } else {
                    line = new StringBuilder(testLine);
                }
            }
            lines.add(line.toString());
        }
        return lines;
    }

}

