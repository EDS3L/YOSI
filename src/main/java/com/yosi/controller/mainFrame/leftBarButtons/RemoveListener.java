package com.yosi.controller.mainFrame.leftBarButtons;

import com.yosi.model.Client;
import com.yosi.services.YosiDAODB;
import com.yosi.services.YosiService;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.ListPanel;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.OrdersInfoPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface RemoveListener {
    YosiService yosiService = new YosiService(new YosiDAODB());
    default ActionListener removeListener(OrdersInfoPanel ordersInfoPanel, ListPanel listPanel) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                if (ordersInfoPanel.getIds().size() == 1) {
                    id = Integer.parseInt(ordersInfoPanel.getIds().get(0));

                    Client client = yosiService.getEntity(id);
                    System.out.println(client);
                    yosiService.delete(client);
                    listPanel.refreshList();

                }

            }
        };


    }
}
