package com.yosi.additions.emailAdditions;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;

import javax.swing.*;
import java.awt.*;

public class TextAreaField implements Colors, Borders {

    private final JPanel panel;

    public TextAreaField(String borderTitle) {
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(darkBorder(borderTitle));
        panel.setPreferredSize(new Dimension(360, 290));
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("Dzień dobry, \n"+ "\n".repeat(10) + "Pozdrawiam.");


        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());


        panel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }
}
