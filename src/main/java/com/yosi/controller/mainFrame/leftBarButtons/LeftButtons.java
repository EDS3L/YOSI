package com.yosi.controller.mainFrame.leftBarButtons;

import com.yosi.additions.Colors;
import com.yosi.controller.Listeners.DetailsListener;
import com.yosi.controller.Listeners.OrderListener;
import com.yosi.controller.Listeners.RemoveListener;
import com.yosi.view.frame.mainFrame.CenterBar.Center;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.OrdersInfoPanel;
import com.yosi.view.frame.orderFame.addOrderFrame.AddOrder;
import com.yosi.view.frame.orderFame.orderDetailsFrame.OrderDetails;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeftButtons extends Panel implements Colors, OrderListener, DetailsListener, RemoveListener {

    public LeftButtons(AddOrder order, Center center, OrdersInfoPanel ordersInfoPanel, OrderDetails orderDetailsFrame) {

        JButton addOrder = new JButton("Add Order");
        JButton removeOrder = new JButton("Remove");
        JButton shipOrder = new JButton("Ship Order");
        JButton orderDetails = new JButton("Order Details");
        JButton refresh = new JButton("Refresh");

        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(addOrder);
        buttons.add(removeOrder);
        buttons.add(shipOrder);
        buttons.add(orderDetails);
        buttons.add(refresh);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);

        for (int i = 0; i < buttons.size(); i++) {
            gbc.gridy = i;
            JButton button = buttons.get(i);
            button.setPreferredSize(new Dimension(120, 40));
            button.setFocusPainted(false);
            button.setBackground(bg);
            button.setFont(new Font("Sans-serif", Font.BOLD, 13));
            button.setForeground(dark);
            add(button, gbc);
        }

        if (addOrder.getActionListeners().length == 0) {
            addOrder.addActionListener(getOrderListener(order));
        }

        if (refresh.getActionListeners().length == 0) {
            refresh.setBackground(Color.gray);
            refresh.addActionListener(refreshOrderListener(center.getListPanel()));

        }

        if(removeOrder.getActionListeners().length == 0) {
            removeOrder.addActionListener(removeListener(ordersInfoPanel, center.getListPanel()));
        }

        if(orderDetails.getActionListeners().length == 0) {
            orderDetails.addActionListener(getOrderDetails(orderDetailsFrame, ordersInfoPanel));


        }




    }


}
