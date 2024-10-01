package com.yosi.view.frame.orderFame.orderDetailsFrame.orderDetailsSections;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;

import javax.swing.*;
import java.awt.*;
public class DetailsClient extends JPanel implements Colors, Borders {
    private final JLabel labelNip = new JLabel();
    private final JLabel labelName = new JLabel();
    private final JLabel labelCity = new JLabel();

    public DetailsClient() {
        setLayout(new GridBagLayout());
        setBackground(white);
        setBorder(detailsBorder("Client"));


        add(infoPanel("Name: ", labelName));
        add(infoPanel("Nip: ", labelNip));
        add(infoPanel("City: ", labelCity));

        System.out.println("wywołanie");
    }

    private JPanel infoPanel(String labelText, JLabel valueLabel) {
        JPanel panel = new JPanel();
        panel.setBackground(white);
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Sans-serif", Font.BOLD, 20));
        valueLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        panel.add(label);
        panel.add(valueLabel);
        return panel;
    }

    public void setLabelNip(String labelNip) {
        this.labelNip.setText(labelNip);

    }

    public void setLabelName(String labelName) {
        this.labelName.setText(labelName);
    }


    public void setLabelCity(String labelCity) {
        this.labelCity.setText(labelCity);
    }
}
