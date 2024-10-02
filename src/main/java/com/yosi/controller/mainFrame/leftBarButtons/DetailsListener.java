package com.yosi.controller.mainFrame.leftBarButtons;

import com.yosi.model.Client;
import com.yosi.services.YosiDAODB;
import com.yosi.services.YosiService;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.OrdersInfoPanel;
import com.yosi.view.frame.orderFame.orderDetailsFrame.OrderDetails;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface DetailsListener {

    YosiService yosiService = new YosiService(new YosiDAODB());
    default ActionListener getOrderDetails(OrderDetails orderDetails, OrdersInfoPanel ordersInfoPanel) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (ordersInfoPanel.getIds().size() == 1) {
                    int id = Integer.parseInt(ordersInfoPanel.getIds().get(0));
                    Client client = yosiService.getEntity(id);
                    OrderDetails.getDetailsClient().setLabelName(client.getName());
                    OrderDetails.getDetailsClient().setLabelNip(String.valueOf(client.getNip()));
                    OrderDetails.getDetailsClient().setLabelCity(client.getCity());
                    orderDetails.setVisible(true);



                }
            }
        };
    }

}
