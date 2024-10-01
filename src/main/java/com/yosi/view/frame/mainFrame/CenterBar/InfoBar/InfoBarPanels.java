package com.yosi.view.frame.mainFrame.CenterBar.InfoBar;

import com.yosi.additions.Colors;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static java.awt.Color.*;

public class InfoBarPanels extends JPanel implements Colors {

    private final JLabel idLabel = new JLabel("ID");
    private final JLabel clientLabel = new JLabel("Client");
    private final JLabel cityLabel = new JLabel("City");
    private final JLabel nipLabel = new JLabel("NIP");
    private final JLabel shippingNumberLabel = new JLabel("Shipping number");

    private final JLabel[] label = {idLabel, clientLabel, cityLabel, nipLabel, shippingNumberLabel};

    private JPanel id,client,city,nip,shippingNumber;

    private final JPanel[] panels = {id, client, city, nip, shippingNumber};


    public InfoBarPanels() {
        Arrays.stream(label).forEach(l -> {
            l.setForeground(bg);
            l.setFont(new Font("Sans-serif", Font.PLAIN,20));
        });
    }
    Dimension panelSize = new Dimension(80, 80);
    public JPanel getIdPanel() {
        JPanel id = new JPanel();
        id.setPreferredSize(panelSize);
        id.setMinimumSize(panelSize);
        id.setMaximumSize(panelSize);
        id.add(idLabel);
        id.setBackground(gray);
        return id;
    }

    public JPanel getClientPanel() {
        JPanel client = new JPanel();
        client.setPreferredSize(panelSize);
        client.setMinimumSize(panelSize);
        client.setMaximumSize(panelSize);
        client.add(clientLabel);
        client.setBackground(gray);
        return client;
    }

    public JPanel getCityPanel() {
        JPanel city = new JPanel();
        city.setPreferredSize(panelSize);
        city.setMinimumSize(panelSize);
        city.setMaximumSize(panelSize);
        city.add(cityLabel);
        city.setBackground(gray);
        return city;
    }

    public JPanel getNipPanel() {
        JPanel nip = new JPanel();
        nip.setPreferredSize(panelSize);
        nip.setMinimumSize(panelSize);
        nip.setMaximumSize(panelSize);
        nip.add(nipLabel);
        nip.setBackground(gray);
        return nip;
    }

    public JPanel getShippingNumberPanel() {
        JPanel shippingNumber = new JPanel();
        shippingNumber.setPreferredSize(panelSize);
        shippingNumber.setMinimumSize(panelSize);
        shippingNumber.setMaximumSize(panelSize);
        shippingNumber.add(shippingNumberLabel);
        shippingNumber.setBackground(gray);
        return shippingNumber;
    }

    public JPanel[] getPanels() {
        return new JPanel[] {getIdPanel(), getClientPanel(), getCityPanel(), getNipPanel(), getShippingNumberPanel()};
    }







}
