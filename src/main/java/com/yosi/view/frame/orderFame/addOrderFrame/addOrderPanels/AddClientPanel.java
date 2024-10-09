package com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import com.yosi.additions.LabeledNumberFieldPanel;
import com.yosi.additions.LabeledTextFieldPanel;

import javax.swing.*;
import java.awt.*;

public class AddClientPanel extends JPanel implements Colors, Borders{

    private final LabeledTextFieldPanel namePanel;
    private final LabeledNumberFieldPanel nipPanel;
    private final LabeledTextFieldPanel cityPanel;


    JButton button;

    public AddClientPanel() {
        setBackground(dark);
        setLayout(new GridBagLayout());
        setBorder(border("Client"));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        namePanel = new LabeledTextFieldPanel("Company name");
        add(namePanel, gbc);

        nipPanel = new LabeledNumberFieldPanel("Company NIP");
        gbc.gridx = 1;
        add(nipPanel, gbc);

        cityPanel = new LabeledTextFieldPanel("City");
        gbc.gridx = 2;
        add(cityPanel, gbc);

        button = new JButton("Submit");
        button.setPreferredSize(new Dimension(200, 60));
        button.setFont(new Font("Sans-serif", Font.BOLD, 15));
        button.setForeground(dark);
        button.setBackground(bg);
        gbc.gridx = 3;
        add(button, gbc);

    }


    public JTextField getNameTextField() {
        return namePanel.getTextField();
    }

    public JTextField getNipTextField() {
        return nipPanel.getTextField();
    }

    public JTextField getCityTextField() {
        return cityPanel.getTextField();
    }

    public JButton getButton() {
        return button;
    }
}