package com.yosi.controller.Listeners;

import com.yosi.model.Client;
import com.yosi.model.OrderAddress;
import com.yosi.model.Shipment;
import com.yosi.services.YosiDAODB;
import com.yosi.services.YosiService;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.OrdersInfoPanel;
import com.yosi.view.frame.orderFame.orderDetailsFrame.OrderDetails;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface DetailsListener {


    default ActionListener getOrderDetails(OrderDetails orderDetails,
                                           OrdersInfoPanel ordersInfoPanel,YosiService yosiService) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (ordersInfoPanel.getIds().size() == 1) {
                    int id = Integer.parseInt(ordersInfoPanel.getIds().getFirst());
                    Client client = yosiService.getEntity(id);
                    OrderDetails.getDetailsClient().setLabelName(client.getName());
                    OrderDetails.getDetailsClient().setLabelNip(String.valueOf(client.getNip()));
                    OrderDetails.getDetailsClient().setLabelCity(client.getCity());

                    client.getOrderAddress().forEach(d -> {
                        OrderDetails.getDetailsAddress().setLabelCounty(d.getCountry());
                        OrderDetails.getDetailsAddress().setLabelCity(d.getCity());
                        OrderDetails.getDetailsAddress().setLabelStreet(d.getStreet());
                        OrderDetails.getDetailsAddress().setLabelHomeNumber(d.getHouseNumber() + "");
                        OrderDetails.getDetailsAddress().setLabelLocalNumber(d.getLocalNumber() + "");
                        OrderDetails.getDetailsAddress().setLabelPostalCode(d.getPostalCode());
                        OrderDetails.getDetailsAddress().setLabelContactNumber(d.getContactNumber() + "");
                    });

                    client.getShipments().forEach( d -> {
                        OrderDetails.getDetailsShipment().setLabelHeight(d.getHeight() +"");
                        OrderDetails.getDetailsShipment().setLabelWeight(d.getWeight() +"");
                        OrderDetails.getDetailsShipment().setLabelWidth(d.getWidth() + "");
                        OrderDetails.getDetailsShipment().setLabelLength(d.getLength() +"");
                    });

                    orderDetails.setVisible(true);

                }
            }
        };
    }

}
