package com.yosi.view.frame.mainFrame.TopBar.Support;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import com.yosi.controller.Listeners.EmailSenderListener;

import javax.swing.*;
import java.awt.*;

public class EmailSection extends JPanel implements Colors, Borders, EmailSenderListener {

    private static final int WIDTH = 565;
    private static final int HEIGHT = 620;

    public EmailSection() {
        setLayout(new BorderLayout());
        add(getLeftSide(), BorderLayout.WEST);
        add(getRightSide(), BorderLayout.EAST);
    }


    public JPanel getLeftSide() {
        JPanel leftSidePanel = new JPanel();
        leftSidePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        leftSidePanel.setBorder(detailsBorder("Formularz"));


        return leftSidePanel;
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
