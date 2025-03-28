package com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import com.yosi.controller.Listeners.EmailSenderListener;

import javax.swing.*;
import java.awt.*;

public class RightEmailSection implements Borders, EmailSenderListener, Colors {

    private static final int WIDTH = 565;
    private static final int HEIGHT = 620;

    private JButton sendButton;
    private EmailSection emailSection;

    public RightEmailSection(EmailSection emailSection) {
        this.emailSection = emailSection;
    }


    public JPanel getRightSide() {
        JPanel rightSidePanel = new JPanel();
        rightSidePanel.setBackground(white);
        rightSidePanel.setLayout(new GridBagLayout());
        rightSidePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        rightSidePanel.setBorder(detailsBorder("Wyślij!"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;

        sendButton = new JButton("WYŚLIJ");
        sendButton.setPreferredSize(new Dimension(200, 60));
        sendButton.addActionListener(emailSender(emailSection));
        rightSidePanel.add(sendButton, gbc);

        return rightSidePanel;
    }

    public JButton getSendButton() {
        return sendButton;
    }
}
