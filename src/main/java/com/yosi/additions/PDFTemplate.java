package com.yosi.additions;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.yosi.model.Client;
import com.yosi.model.OrderAddress;
import com.yosi.model.Shipment;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class PDFTemplate {

    public PDFTemplate() {

    }

    public Document getPDF(Client client, Shipment shipment, OrderAddress orderAddress) {

        Document document = new com.itextpdf.text.Document();
        String pdfPath = "temp/YO" + shipment.getShipmentNumber() + ".pdf";

        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
        } catch (DocumentException | FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        document.open();

        Font headerFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 20, BaseColor.BLACK);
        Font bodyFont = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);

        try {


            Chunk header = new Chunk("Etykieta Przewozowa", headerFont);
            document.add(header);
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Nadawca:", headerFont));
            document.add(new Paragraph(client.getName(), bodyFont));
            document.add(new Paragraph(client.getCity(), bodyFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Odbiorca:", headerFont));
            document.add(new Paragraph(orderAddress.getCity(), bodyFont));
            document.add(new Paragraph(orderAddress.getPostalCode(), bodyFont));
            document.add(new Paragraph(orderAddress.getStreet() +
                    orderAddress.getHouseNumber()+ "/" + orderAddress.getLocalNumber(), bodyFont));
            document.add(new Paragraph(" "));


            document.add(new Paragraph("Przesyłka:", headerFont));
            double volume = ((double) shipment.getHeight() /100) * ((double) shipment.getLength() /100) * ((double) shipment.getWidth() /100);
            DecimalFormat f = new DecimalFormat("##.00");
            document.add(new Paragraph( f.format(volume) + " m3", bodyFont));
            document.add(new Paragraph( shipment.getWeight() + " kg", bodyFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Numer przesyłki: " + shipment.getShipmentNumber(), bodyFont));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        document.close();
        System.out.println("Etykieta przewozowa została wygenerowana!");

        try {
            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(pdfPath);
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("Nie można otworzyć pliku PDF, ponieważ funkcja Desktop nie jest obsługiwana.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return document;
    }
}
