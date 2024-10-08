package com.yosi.view.frame.mainFrame.TopBar;

import com.yosi.additions.Colors;
import com.yosi.controller.Listeners.TopSectionListener;
import com.yosi.view.frame.mainFrame.TopBar.Support.SupportSection;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class TopBar extends JPanel implements Colors, TopSectionListener {
    private static final int WIDTH = 1380;
    private static final int HEIGHT = 90;
    private static SupportSection supportSection;

    public TopBar() {
        supportSection = new SupportSection();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(panes);
        setLayout(new GridBagLayout());
        setTimer();
        buttons();

    }

    public void buttons() {
        JButton supportButton = new JButton();
        supportButton.setFocusPainted(false);
        ImageIcon originalIcon = new ImageIcon("src/main/java/com/yosi/additions/icons/customer-support.png");
        supportButton.setIcon(originalIcon);
        if(supportButton.getActionListeners().length == 0) {
            supportButton.addActionListener(openSupportSection(getSupportSection()));
        }


        supportButton.setPreferredSize(new Dimension(50,50));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0,0,0,10);
        add(supportButton, gbc);

    }


    public SupportSection getSupportSection() {
        return supportSection;
    }

    public void setTimer() {
        JPanel clockPanel = new JPanel();
        clockPanel.setBackground(panes);

        JLabel clockLabel = new JLabel();

        clockLabel.setFont(new Font("Arial", Font.BOLD, 25));


        clockPanel.add(clockLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime time = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                clockLabel.setText(time.format(formatter));
            }
        });
        timer.start();
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,10,0,0);

        add(clockPanel, gbc);
    }
}
