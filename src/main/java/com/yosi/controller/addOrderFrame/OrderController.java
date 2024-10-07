package com.yosi.controller.addOrderFrame;

import com.yosi.model.Client;
import com.yosi.model.OrderAddress;
import com.yosi.model.Shipment;
import com.yosi.services.YosiDAODB;
import com.yosi.services.YosiService;
import com.yosi.view.frame.orderFame.addOrderFrame.AddOrder;
import com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels.AddAddressPanel;
import com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels.AddClientPanel;
import com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels.AddShipmentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public record OrderController(AddClientPanel clientPanel, AddShipmentPanel shipmentPanel, AddAddressPanel addressPanel, AddOrder order) {

    static YosiService yosiService = new YosiService(new YosiDAODB());
    public ActionListener addAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = clientPanel.getNameTextField().getText();
                String nip = clientPanel.getNipTextField().getText();
                long nipClint = Long.parseLong(nip);
                String city = clientPanel.getCityTextField().getText();


                String weight = shipmentPanel.getWeightText().getText();
                int weightAddress = Integer.parseInt(weight);
                String width = shipmentPanel.getWidthText().getText();
                int widthAddress = Integer.parseInt(width);
                String height = shipmentPanel.getHeightText().getText();
                int heightAddress = Integer.parseInt(height);
                String length = shipmentPanel.getLengthText().getText();
                int lengthAddress = Integer.parseInt(length);


                String country = addressPanel.getCountryText().getText();
                String addressCity = addressPanel.getCityText().getText();
                String street = addressPanel.getStreetText().getText();
                String houseNumber = addressPanel.getHouseNumberText().getText();
                int houseNumberShipment = Integer.parseInt(houseNumber);
                String localNumber = addressPanel.getLocalNumberText().getText();
                int localNumberAddress = Integer.parseInt(localNumber);
                String postalCode = addressPanel.getPostalCodeText().getText();
                String contactNumber = addressPanel.getContactNumberText().getText();
                long contactNumberShipment = Long.parseLong(contactNumber);


                Client clint = new Client(name,nipClint,city);


                Shipment shipment = new Shipment(weightAddress,widthAddress,heightAddress,lengthAddress,0);
                ArrayList<Shipment> shipmentList = new ArrayList<Shipment>();
                shipmentList.add(shipment);


                OrderAddress orderAddress = new OrderAddress(country,addressCity,street,houseNumberShipment,
                        localNumberAddress,postalCode,contactNumberShipment);
                ArrayList<OrderAddress> orderAddressList = new ArrayList<OrderAddress>();
                orderAddressList.add(orderAddress);

                clint.setOrderAddress(orderAddressList);
                orderAddress.setClient(clint);

                clint.setShipments(shipmentList);
                shipment.setClient(clint);

                yosiService.save(clint);

                order.dispatchEvent(new WindowEvent(order, WindowEvent.WINDOW_CLOSING));






            }
        };
    }


}
