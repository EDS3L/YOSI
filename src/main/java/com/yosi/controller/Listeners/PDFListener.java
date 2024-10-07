package com.yosi.controller.Listeners;

import com.yosi.additions.PDFTemplate;
import com.yosi.model.Client;
import com.yosi.model.OrderAddress;
import com.yosi.model.Shipment;
import com.yosi.services.YosiDAODB;
import com.yosi.services.YosiService;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.OrdersInfoPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public interface PDFListener {
    YosiService yosiService = new YosiService(new YosiDAODB());
    PDFTemplate pdf = new PDFTemplate();
    default ActionListener pdfCreator(OrdersInfoPanel ordersInfoPanel) {


        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ordersInfoPanel.getIds().size() == 1) {
                    int id = Integer.parseInt(ordersInfoPanel.getIds().getFirst());

                    Client client = yosiService.getEntity(id);

                    List<Shipment> shipmentList = client.getShipments();
                    Shipment shipment = shipmentList.getFirst();

                    List<OrderAddress> orderAddressList = client.getOrderAddress();
                    OrderAddress orderAddress = orderAddressList.getFirst();

                    List<Client> clients = yosiService.findAll();

                    if(shipment.getShipmentNumber() == 0) {
                        shipment.setShipmentNumber(getHighestNumber(clients));
                        yosiService.update(client);
                    } else {
                        System.out.println("To zamówienie jest już nadane");
                    }






                }
            }
        };
    }

    private long getHighestNumber(List<Client> clients) {
        long highestNumber = Integer.MIN_VALUE;

        for (Client client1 : clients) {
            for (Shipment shipment2 : client1.getShipments()) {
                long shipmentNumber = shipment2.getShipmentNumber();

                if (shipmentNumber > highestNumber) {
                    highestNumber = shipmentNumber;
                }
            }
        }


        return highestNumber + 1;
    }
}
