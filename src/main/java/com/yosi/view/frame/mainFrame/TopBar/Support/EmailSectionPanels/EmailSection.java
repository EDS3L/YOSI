package com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import com.yosi.controller.Listeners.EmailSenderListener;

import javax.swing.*;
import java.awt.*;

public class EmailSection extends JPanel implements Colors, Borders, EmailSenderListener {

    private static final int WIDTH = 565;
    private static final int HEIGHT = 620;

    private static LeftEmailSection leftEmailSection;
    private static RightEmailSection rightEmailSection;

    public EmailSection() {
        leftEmailSection = new LeftEmailSection();
        rightEmailSection = new RightEmailSection();

        setLayout(new BorderLayout());
        add(getLeftEmailSection().getLeftSide(), BorderLayout.WEST);
        add(getRightEmailSection().getRightSide(), BorderLayout.EAST);
    }

    public LeftEmailSection getLeftEmailSection() {
        return leftEmailSection;
    }

    public RightEmailSection getRightEmailSection() {
        return rightEmailSection;
    }






}
