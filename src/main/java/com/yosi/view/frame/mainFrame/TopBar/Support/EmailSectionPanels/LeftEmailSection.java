package com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels;

import com.yosi.additions.Borders;

import javax.swing.*;
import java.awt.*;

public class LeftEmailSection implements Borders {
    private static final int WIDTH = 565;
    private static final int HEIGHT = 620;

    public LeftEmailSection() {

    }

    public JPanel getLeftSide() {
        JPanel leftSidePanel = new JPanel();
        leftSidePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        leftSidePanel.setBorder(detailsBorder("Formularz"));

        leftSidePanel.add(createPanelSection("Nazwa użytkownika"));
        leftSidePanel.add(createPanelSection("Tytuł"));
        leftSidePanel.add(createPanelSection("Czego dotyczy sprawa // mail wysyłki"));
        leftSidePanel.add(createPanelSection("Twój email"));
        leftSidePanel.add(createPanelSection("Nazwa użytkownika"));
        leftSidePanel.add(contentTextField("Treść"));


        return leftSidePanel;
    }

    public JPanel createPanelSection(String borderTitle) {
        JPanel panel = new JPanel();
        JTextField textField = new JTextField();
        panel.setBorder(detailsBorder(borderTitle));
        panel.setPreferredSize(new Dimension(200,90));
        textField.setPreferredSize(new Dimension(140,30));


        panel.add(textField);
        return panel;
    }

    public JPanel contentTextField(String borderTitle) {
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea();
        panel.setBorder(detailsBorder(borderTitle));
        panel.setPreferredSize(new Dimension(500,600));
        textArea.setPreferredSize(new Dimension(440,500));


        panel.add(textArea);
        return panel;
    }
}
