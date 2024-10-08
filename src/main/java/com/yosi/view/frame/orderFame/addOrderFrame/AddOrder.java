package com.yosi.view.frame.orderFame.addOrderFrame;

import com.yosi.additions.Colors;
import com.yosi.controller.addOrderFrame.OrderController;
import com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels.AddAddressPanel;
import com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels.AddClientPanel;
import com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels.AddShipmentPanel;

import javax.swing.*;
import java.awt.*;

public class AddOrder extends JFrame implements Colors {
    private static final int WIDTH = 1140;
    private static final int HEIGHT = 620;
    AddAddressPanel addressPanel = new AddAddressPanel();
    AddClientPanel clientPanel = new AddClientPanel();
    AddShipmentPanel shipmentPanel = new AddShipmentPanel();



    public AddOrder() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        OrderController orderController = new OrderController(clientPanel,shipmentPanel, addressPanel, this);

        clientPanel.getButton().addActionListener(orderController.addAction());


        GridBagConstraints gbcClient = this.gbc(0,1,1.3,0.3);
        gbcClient.gridwidth = 2;
        add(clientPanel, gbcClient);


        GridBagConstraints gbcAddress = this.gbc(0,0,0.5,0.7);
        add(addressPanel, gbcAddress);


        GridBagConstraints gbcShipment = this.gbc(1,0,0.5,0.7);
        add(shipmentPanel, gbcShipment);

        pack();
        setLocationRelativeTo(this);

    }

    public GridBagConstraints gbc(int gridx, int gridy, double weightx, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }



}
