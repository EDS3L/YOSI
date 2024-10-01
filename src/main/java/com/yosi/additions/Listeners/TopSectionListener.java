package com.yosi.additions.Listeners;

import com.yosi.view.frame.mainFrame.TopBar.Support.SupportSection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface TopSectionListener {



    default ActionListener openSupportSection(SupportSection supportSection) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supportSection.setVisible(true);
            }
        };

    }
}
