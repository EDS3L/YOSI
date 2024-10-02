package com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels;

import com.yosi.additions.Borders;
import com.yosi.controller.Listeners.EmailSenderListener;

import javax.swing.*;
import java.awt.*;

public class RightEmailSection implements Borders, EmailSenderListener {

    private static final int WIDTH = 565;
    private static final int HEIGHT = 620;

    public RightEmailSection() {

    }

    public JPanel getRightSide() {
        JPanel rightSidePanel = new JPanel();

        rightSidePanel.setLayout(new GridBagLayout());
        rightSidePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        rightSidePanel.setBorder(detailsBorder("Wyślij!"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;

        JButton sendButton = new JButton("WYŚLIJ");
        sendButton.setPreferredSize(new Dimension(200, 60));
        sendButton.addActionListener(emailSender());
        rightSidePanel.add(sendButton, gbc);

        return rightSidePanel;
    }
}
