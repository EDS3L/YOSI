package com.yosi.view.frame;

import com.yosi.controller.mainFrame.leftBarButtons.LeftButtons;
import com.yosi.view.frame.mainFrame.CenterBar.Center;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.OrdersInfoPanel;
import com.yosi.view.frame.mainFrame.Frame;
import com.yosi.view.frame.mainFrame.LeftBar;
import com.yosi.view.frame.mainFrame.TopBar.TopBar;
import com.yosi.view.frame.orderFame.addOrderFrame.AddOrder;
import com.yosi.view.frame.orderFame.orderDetailsFrame.OrderDetails;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        TopBar topBar = new TopBar();
        AddOrder order = new AddOrder();
        OrdersInfoPanel ordersInfoPanel = new OrdersInfoPanel();
        Center center = new Center(ordersInfoPanel);
        OrderDetails orderDetails = new OrderDetails();

        LeftButtons leftButtons = new LeftButtons(order, center, ordersInfoPanel, orderDetails);
        LeftBar leftBar = new LeftBar();
        leftBar.add(leftButtons);

        frame.add(topBar, BorderLayout.NORTH);
        frame.add(leftBar, BorderLayout.WEST);
        frame.add(center, BorderLayout.CENTER);



        frame.pack();
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);


    }

}
