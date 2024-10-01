package com.yosi.view.frame.orderFame.orderDetailsFrame.orderDetailsSections;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import javax.swing.*;
import java.awt.*;
public class DetailsAddress extends JPanel implements Colors, Borders {

    private final JLabel labelCounty = new JLabel();
    private final JLabel labelCity = new JLabel();
    private final JLabel labelStreet = new JLabel();
    private final JLabel labelHomeNumber = new JLabel();
    private final JLabel labelLocalNumber = new JLabel();
    private final JLabel labelPostalCode = new JLabel();
    private final JLabel labelContactNumber = new JLabel();


    public DetailsAddress() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(white);
        setBorder(detailsBorder("Address"));
        add(infoPanel("County : ", labelCounty));
        add(infoPanel("City : ", labelCity));
        add(infoPanel("Street : ", labelStreet));
        add(infoPanel("Home Number: ", labelHomeNumber));
        add(infoPanel("Local Number: ", labelLocalNumber));
        add(infoPanel("Postal Code: ", labelPostalCode));
        add(infoPanel("Contact Number: ", labelContactNumber));
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

    public void setLabelCounty(String labelCounty) {
        this.labelCounty.setText(labelCounty);
    }

    public void setLabelCity(String labelCity) {
        this.labelCity.setText(labelCity);
    }

    public void setLabelStreet(String labelStreet) {
        this.labelStreet.setText(labelStreet);
    }

    public void setLabelHomeNumber(String labelHomeNumber) {
        this.labelHomeNumber.setText(labelHomeNumber);
    }

    public void setLabelLocalNumber(String labelLocalNumber) {
        this.labelLocalNumber.setText(labelLocalNumber);
    }

    public void setLabelPostalCode(String labelPostalCode) {
        this.labelPostalCode.setText(labelPostalCode);
    }

    public void setLabelContactNumber(String labelContactNumber) {
        this.labelContactNumber.setText(labelContactNumber);
    }
}
