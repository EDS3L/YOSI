package com.yosi.view.frame.mainFrame.CenterBar.OrdersList;

import com.yosi.model.Client;
import com.yosi.services.YosiDAODB;
import com.yosi.services.YosiService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ListPanel extends JPanel {

    private final OrdersInfoPanel ordersInfoPanel;


    public ListPanel(OrdersInfoPanel ordersInfoPanel) {
        this.ordersInfoPanel = ordersInfoPanel;
    }

    public JPanel getListPanel() {
        setLayout(new GridBagLayout());
        refreshList();
        return this;
    }



    public void refreshList() {
        removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
//        gbc.insets = new Insets(0,0,0,0);

        YosiService yosiService = new YosiService(new YosiDAODB());
        ArrayList<Client> clientList = (ArrayList<Client>) yosiService.findAll();

        ArrayList<JPanel> panelsList = ordersInfoPanel.createDataPanels(clientList);


        for (JPanel panel : panelsList) {
            gbc.gridy ++;
            panel.setPreferredSize(new Dimension(200,35));
            add(panel, gbc);
        }

        revalidate();
        repaint();

    }



}
