package com.yosi.view.frame;

import com.yosi.controller.mainFrame.leftBarButtons.LeftButtons;
import com.yosi.services.YosiDAODB;
import com.yosi.services.YosiService;
import com.yosi.view.frame.mainFrame.CenterBar.Center;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.OrdersInfoPanel;
import com.yosi.view.frame.mainFrame.Frame;
import com.yosi.view.frame.mainFrame.LeftBar;
import com.yosi.view.frame.mainFrame.TopBar.TopBar;
import com.yosi.view.frame.orderFame.addOrderFrame.AddOrder;
import com.yosi.view.frame.orderFame.orderDetailsFrame.OrderDetails;

import java.awt.*;


public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        YosiService yosiService = new YosiService(new YosiDAODB());
        TopBar topBar = new TopBar();
        OrdersInfoPanel ordersInfoPanel = new OrdersInfoPanel();
        Center center = new Center(ordersInfoPanel, yosiService);
        AddOrder order = new AddOrder(center.getListPanel());
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
