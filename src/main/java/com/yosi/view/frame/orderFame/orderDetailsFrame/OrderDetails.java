package com.yosi.view.frame.orderFame.orderDetailsFrame;

import com.yosi.additions.Colors;

import javax.swing.*;
import java.awt.*;
import com.yosi.view.frame.orderFame.orderDetailsFrame.orderDetailsSections.DetailsAddress;
import com.yosi.view.frame.orderFame.orderDetailsFrame.orderDetailsSections.DetailsClient;
import com.yosi.view.frame.orderFame.orderDetailsFrame.orderDetailsSections.DetailsShipment;

public class OrderDetails extends JFrame implements Colors {
    private static final int WIDTH = 1140;
    private static final int HEIGHT = 620;
    private static DetailsAddress detailsAddress;
    private static DetailsClient detailsClient;
    private static DetailsShipment detailsShipment;

    public OrderDetails() {
        intiFrame();
    }

    public void intiFrame() {
        detailsClient = new DetailsClient();
        detailsAddress = new DetailsAddress();
        detailsShipment = new DetailsShipment();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        setBackground(white);


        GridBagConstraints gbcClient = this.gbc(0,1,1.3,0.3);
        gbcClient.gridwidth = 2;
        add(detailsClient, gbcClient);
        GridBagConstraints gbcAddress = this.gbc(0,0,0.5,0.7);
        add(detailsAddress, gbcAddress);
        GridBagConstraints gbcShipment = this.gbc(1,0,0.5,0.7);
        add(detailsShipment, gbcShipment);



        pack();
        setLocationRelativeTo(this);
        revalidate();
        repaint();

    }

    private GridBagConstraints gbc(int gridx, int gridy, double weightx, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }

    public static DetailsClient getDetailsClient() {
        return detailsClient;
    }

    public static DetailsAddress getDetailsAddress() {
        return detailsAddress;
    }

    public static DetailsShipment getDetailsShipment() {
        return detailsShipment;
    }

}
