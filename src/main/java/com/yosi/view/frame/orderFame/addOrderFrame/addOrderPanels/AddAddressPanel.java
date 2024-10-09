package com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import com.yosi.additions.LabeledNumberFieldPanel;
import com.yosi.additions.LabeledTextFieldPanel;

import javax.swing.*;
import java.awt.*;

public class AddAddressPanel extends JPanel implements Colors, Borders {


    private final LabeledTextFieldPanel countryPanel;
    private final LabeledTextFieldPanel cityPanel;
    private final LabeledTextFieldPanel streetPanel;
    private final LabeledNumberFieldPanel houseNumberPanel;
    private final LabeledNumberFieldPanel localNumberPanel;
    private final LabeledTextFieldPanel postalCodePanel ;
    private final LabeledNumberFieldPanel contactNumberPanel;


    public AddAddressPanel() {
        setBackground(dark);
        setLayout(new GridBagLayout());
        setBorder(border("Address"));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;




        countryPanel = new LabeledTextFieldPanel("Country");
        add(countryPanel, gbc);

        cityPanel = new LabeledTextFieldPanel("City");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(cityPanel, gbc);

        streetPanel = new LabeledTextFieldPanel("Street");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(streetPanel, gbc);

        houseNumberPanel = new LabeledNumberFieldPanel("House Number");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(houseNumberPanel, gbc);

        localNumberPanel = new LabeledNumberFieldPanel("Local Number");
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(localNumberPanel, gbc);

        postalCodePanel = new LabeledTextFieldPanel("Postal Code");
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(postalCodePanel, gbc);

        contactNumberPanel = new LabeledNumberFieldPanel("Contact Number");
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(contactNumberPanel, gbc);

    }

    public JTextField getCountryText() {
        return countryPanel.getTextField();
    }

    public JTextField getCityText() {
        return cityPanel.getTextField();
    }

    public JTextField getStreetText() {
        return streetPanel.getTextField();
    }

    public JTextField getHouseNumberText() {
        return houseNumberPanel.getTextField();
    }

    public JTextField getLocalNumberText() {
        return localNumberPanel.getTextField();
    }

    public JTextField getPostalCodeText() {
        return postalCodePanel.getTextField();
    }

    public JTextField getContactNumberText() {
        return contactNumberPanel.getTextField();
    }


}
