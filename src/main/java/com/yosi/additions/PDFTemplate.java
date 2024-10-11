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

            Paragraph senderLabel = new Paragraph("Nadawca", headerFont);
            senderLabel.setAlignment(Element.ALIGN_CENTER);
            document.add(senderLabel);

            Paragraph senderInfo = new Paragraph(client.getName() + "\n" + client.getCity(), bodyFont);
            senderInfo.setAlignment(Element.ALIGN_CENTER);
            document.add(senderInfo);


            document.add(new Paragraph(" "));
            Paragraph taker = new Paragraph("Odbiorca", headerFont);
            taker.setAlignment(Element.ALIGN_CENTER);
            document.add(taker);

            Paragraph takerInfo = new Paragraph(
                    orderAddress.getCity() +
                    "\n" + orderAddress.getPostalCode() +
                    "\n" + orderAddress.getStreet() + " " + orderAddress.getHouseNumber()+ "/" + orderAddress.getLocalNumber(),
                    bodyFont
            );
            takerInfo.setAlignment(Element.ALIGN_CENTER);
            document.add(takerInfo);

            document.add(new Paragraph(" "));

            Paragraph ship = new Paragraph("Przesyłka", headerFont);
            ship.setAlignment(Element.ALIGN_CENTER);
            document.add(ship);
            double volume = (
                    (double)
                            shipment.getHeight() /100) *
                    ((double) shipment.getLength() /100) *
                    ((double) shipment.getWidth() /100);
            DecimalFormat f = new DecimalFormat("##.00");
            Paragraph shipInfo = new Paragraph(
                    f.format(volume) + " m3" +
                            "\n" + shipment.getWeight() + " kg", bodyFont
            );
            shipInfo.setAlignment(Element.ALIGN_CENTER);
            document.add(shipInfo);

            document.add(new Paragraph(" "));

            Paragraph shipNumber = new Paragraph("Numer przesyłki: " + shipment.getShipmentNumber(), bodyFont);
            shipNumber.setAlignment(Element.ALIGN_CENTER);
            document.add(shipNumber);

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
