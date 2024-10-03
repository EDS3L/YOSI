package com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import com.yosi.controller.Listeners.EmailSenderListener;

import javax.swing.*;
import java.awt.*;

public class EmailSection extends JPanel implements Colors, Borders, EmailSenderListener {

    private static LeftEmailSection leftEmailSection;
    private static RightEmailSection rightEmailSection;

    public EmailSection() {
        leftEmailSection = new LeftEmailSection();
        rightEmailSection = new RightEmailSection();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx =1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        setBackground(white);
        add(getLeftEmailSection().getLeftSide(),gbc);
        add(getRightEmailSection().getRightSide(),gbc);
    }

    public LeftEmailSection getLeftEmailSection() {
        return leftEmailSection;
    }

    public RightEmailSection getRightEmailSection() {
        return rightEmailSection;
    }






}
