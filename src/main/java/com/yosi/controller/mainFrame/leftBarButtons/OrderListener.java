package com.yosi.controller.mainFrame.leftBarButtons;

import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.ListPanel;
import com.yosi.view.frame.orderFame.addOrderFrame.AddOrder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface OrderListener {


    default ActionListener getOrderListener(AddOrder order) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order.setVisible(true);
            }
        };
    }


    default ActionListener refreshOrderListener(ListPanel listPanel) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPanel.refreshList();

            }
        };
    }


}
