package com.yosi.view.frame.mainFrame.CenterBar.OrdersList;

import com.yosi.additions.Colors;
import com.yosi.additions.Listeners.MouseListener;
import com.yosi.model.Client;
import com.yosi.model.OrderAddress;
import com.yosi.model.Shipment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class OrdersInfoPanel extends JPanel implements Colors, MouseListener {


    private final ArrayList<String> ids = new ArrayList<String>();
    public JPanel lastSelectedPanel = null;
    public Color lastSelectedPanelColor = null;
    public OrdersInfoPanel() {
    }

    public ArrayList<JPanel> createDataPanels(ArrayList<Client> clients) {
        ArrayList<JPanel> panelsList = new ArrayList<>();

        for (Client client : clients) {
            JPanel subPanel = new JPanel();
            subPanel.setLayout(new GridBagLayout());
            subPanel.setBackground(gray);
            subPanel.setBorder(BorderFactory.createLineBorder(black));

            String id = String.valueOf(client.getShipments().stream().map(Shipment::getId).map(String::valueOf).collect(Collectors.joining(", ")));
            String name = client.getName();
            String city = String.valueOf(client.getOrderAddress().stream().map(OrderAddress::getCity).map(String::valueOf).collect(Collectors.joining(", ")));
            String nip = String.valueOf(client.getNip());
            String shippingNumber = String.valueOf(client.getShipments().stream().map(Shipment::getLength).map(String::valueOf).collect(Collectors.joining(", ")));

            JPanel idPanel = new JPanel();
            JPanel namePanel = new JPanel();
            JPanel cityPanel = new JPanel();
            JPanel nipPanel = new JPanel();
            JPanel shippingNumberPanel = new JPanel();

            JLabel idLabel = new JLabel(id);
            idLabel.setName("id");
            idPanel.add(idLabel);
            JLabel nameLabel = new JLabel(name);
            nameLabel.setName("companyName");
            namePanel.add(nameLabel);
            JLabel cityLabel = new JLabel(city);
            cityLabel.setName("cityOfTheOrderAddress");
            cityPanel.add(cityLabel);
            JLabel nipLabel = new JLabel(nip);
            nipLabel.setName("nip");
            nipPanel.add(nipLabel);
            JLabel shippingNumberLabel = new JLabel(shippingNumber);
            shippingNumberLabel.setName("shippingNumber");
            shippingNumberPanel.add(shippingNumberLabel);

            JLabel[] labels = new JLabel[]{idLabel, nameLabel, cityLabel, nipLabel, shippingNumberLabel};
            JPanel[] panels = new JPanel[]{idPanel, namePanel, cityPanel, nipPanel, shippingNumberPanel};

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            Dimension panelSize = new Dimension(100, 100);

            for (JPanel panel : panels) {
                panel.setPreferredSize(panelSize);
                panel.setMinimumSize(panelSize);
                panel.setMaximumSize(panelSize);
                panel.setBackground(gray);
                subPanel.add(panel, gbc);
            }

            for (JLabel label : labels) {
                label.setForeground(bg);
                label.setFont(new Font("Sans-serif", Font.PLAIN, 20));
            }

            panelsList.add(subPanel);
            subPanel.addMouseListener(this.mouseListener(this));
        }

        return panelsList;
    }

    public ArrayList<String> getIds() {
        return ids;
    }




}


