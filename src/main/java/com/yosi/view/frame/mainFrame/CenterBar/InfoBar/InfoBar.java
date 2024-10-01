package com.yosi.view.frame.mainFrame.CenterBar.InfoBar;

import com.yosi.additions.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;

import static java.awt.Color.black;

public class InfoBar extends JPanel implements Colors {

    InfoBarPanels infoBar = new InfoBarPanels();

    public InfoBar() {
    }

    public JPanel getInfoPanel() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;


        JPanel[] panels = infoBar.getPanels();
        for (int i = 0; i < panels.length; i++) {
            gbc.gridx = i;
            gbc.gridy = 0;
            add(panels[i], gbc);
        }

        return this;
    }


    public void adjustSize(int parentWidth) {
        int newWidth = (int) (parentWidth * 0.95);
        setPreferredSize(new Dimension(newWidth, 40));
        revalidate();
    }



}
