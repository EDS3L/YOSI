package com.yosi.additions.emailAdditions;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;

import javax.swing.*;
import java.awt.*;

public class TextFieldMail extends JPanel implements Colors, Borders {

    private final JPanel panel;
    private final JTextField textField;

    public TextFieldMail(String borderTitle) {
        panel = new JPanel();
        panel.setBackground(white);
        panel.setPreferredSize(new Dimension(250, 60));
        panel.setBorder(darkBorder(borderTitle));



        textField = new JTextField();
        textField.setPreferredSize(new Dimension(240, 30));
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setFont(new Font("Sans-serif", Font.PLAIN, 15));




        panel.add(textField);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTextField() {
        return textField;
    }

    public String getText() {
        return textField.getText();
    }
}
