package com.yosi.controller.Listeners;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public interface PDFListener {

    default ActionListener pdfCreator() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document document = new Document();
                try {
                    PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
                } catch (DocumentException | FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                document.open();
                Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                Chunk chunk = new Chunk("Hello World", font);

                try {
                    document.add(chunk);
                } catch (DocumentException ex) {
                    throw new RuntimeException(ex);
                }
                document.close();
            }
        };
    }
}
