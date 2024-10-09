package com.yosi.additions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LabeledNumberFieldPanel extends JPanel implements Colors, Borders {
    private final JTextField textField;

    public LabeledNumberFieldPanel(String labelText) {
        setBackground(dark);
        setLayout(new GridBagLayout());

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Sans-serif", Font.BOLD, 19));
        label.setForeground(bg);

        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        textField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        textField.setPreferredSize(new Dimension(200, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 0);
        add(label, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(textField, gbc);






    }


    public JTextField getTextField() {
        return textField;
    }
}
