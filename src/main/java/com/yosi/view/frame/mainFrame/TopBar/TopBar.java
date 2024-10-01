package com.yosi.view.frame.mainFrame.TopBar;

import com.yosi.additions.Colors;
import com.yosi.additions.Listeners.TopSectionListener;
import com.yosi.view.frame.mainFrame.TopBar.Support.SupportSection;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class TopBarFrame extends JPanel implements Colors, TopSectionListener {
    private static final int WIDTH = 1380;
    private static final int HEIGHT = 90;
    private static SupportSection supportSection;

    public TopBarFrame() {
        supportSection = new SupportSection();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(panes);
        setLayout(new FlowLayout());
        buttons();

    }

    public void buttons() {
        JButton supportButton = new JButton("?");
        if(supportButton.getActionListeners().length == 0) {
            supportButton.addActionListener(openSupportSection(getSupportSection()));
        }

        add(supportButton);
    }


    public SupportSection getSupportSection() {
        return supportSection;
    }
}
