package com.yosi.view.frame.orderFame.orderDetailsFrame.orderDetailsSections;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;

import javax.swing.*;
import java.awt.*;

public class DetailsShipment extends JPanel implements Colors, Borders {
    private final JLabel labelWeight = new JLabel();
    private final JLabel labelWidth = new JLabel();
    private final JLabel labelHeight = new JLabel();
    private final JLabel labelLength = new JLabel();

    public DetailsShipment() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(white);
        setBorder(detailsBorder("Shipment"));
        add(infoPanel("Weight: ", labelWeight));
        add(infoPanel("Width: ", labelWidth));
        add(infoPanel("Height: ", labelHeight));
        add(infoPanel("Length: ", labelLength));
    }

    private JPanel infoPanel(String labelText, JLabel valueLabel) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(white);
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Sans-serif", Font.BOLD, 20));
        valueLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        panel.add(label);
        panel.add(valueLabel);
        return panel;
    }

    public void setLabelWeight(String labelWeight) {
        this.labelWeight.setText(labelWeight);
    }

    public void setLabelWidth(String labelWidth) {
        this.labelWidth.setText(labelWidth);
    }

    public void setLabelHeight(String labelHeight) {
        this.labelHeight.setText(labelHeight);
    }

    public void setLabelLength(String labelLength) {
        this.labelLength.setText(labelLength);
    }
}