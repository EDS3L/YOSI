package com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import com.yosi.additions.LabeledTextFieldPanel;

import javax.swing.*;
import java.awt.*;

public class AddShipmentPanel extends JPanel implements Colors, Borders{
   private final LabeledTextFieldPanel weightPanel;
    private final LabeledTextFieldPanel widthPanel;
    private final LabeledTextFieldPanel heightPanel;
    private final LabeledTextFieldPanel lengthPanel;

    public AddShipmentPanel() {
        setBackground(dark);
        setLayout(new GridBagLayout());

        setBorder(border("Shipment"));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        weightPanel = new LabeledTextFieldPanel("weight");
        add(weightPanel,gbc);

        widthPanel = new LabeledTextFieldPanel("width");
        gbc.gridy = 1;
        add(widthPanel,gbc);

        heightPanel = new LabeledTextFieldPanel("height");
        gbc.gridy = 2;
        add(heightPanel,gbc);

        lengthPanel = new LabeledTextFieldPanel("length");
        gbc.gridy = 3;
        add(lengthPanel,gbc);



    }

    public JTextField getWeightText() {
        return weightPanel.getTextField();
    }

    public JTextField getWidthText() {
        return widthPanel.getTextField();
    }

    public JTextField getHeightText() {
        return heightPanel.getTextField();
    }

    public JTextField getLengthText() {
        return lengthPanel.getTextField();
    }

}
