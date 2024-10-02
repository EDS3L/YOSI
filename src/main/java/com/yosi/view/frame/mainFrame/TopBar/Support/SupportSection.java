package com.yosi.view.frame.mainFrame.TopBar.Support;

import com.yosi.additions.Colors;
import com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels.EmailSection;

import javax.swing.*;
import java.awt.*;

public class SupportSection extends JFrame implements Colors {
    private static final int WIDTH = 1140;
    private static final int HEIGHT = 620;

    EmailSection emailSection = new EmailSection();

    public SupportSection() {
        initFrame();

        add(emailSection);
    }


    public void initFrame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(bg);
        setLayout(new BorderLayout());


        pack();
        setLocationRelativeTo(this);
    }
}
