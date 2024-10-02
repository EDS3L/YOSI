package com.yosi.controller.Listeners;

import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.OrdersInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public interface MouseListener {

    default java.awt.event.MouseListener mouseListener(OrdersInfoPanel ordersInfoPanel) {

        return new java.awt.event.MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel clickedPanel = (JPanel) e.getSource();
                ordersInfoPanel.getIds().clear();
                Color selectionBlue = new Color(51, 153, 255);


                if (ordersInfoPanel.lastSelectedPanel != null && ordersInfoPanel.lastSelectedPanel != clickedPanel) {
                    restoreOriginalColors(ordersInfoPanel.lastSelectedPanel, ordersInfoPanel.lastSelectedPanelColor);
                }

                ordersInfoPanel.lastSelectedPanel = clickedPanel;
                ordersInfoPanel.lastSelectedPanelColor = clickedPanel.getBackground();

                setPanelColor(clickedPanel, selectionBlue);


                for (Component c : clickedPanel.getComponents()) {
                    if (c instanceof JPanel) {
                        for (Component c2 : ((JPanel) c).getComponents()) {
                            if (c2 instanceof JLabel label) {
                                if (label.getName().equals("id")) {
                                    String id = label.getText();
                                    ordersInfoPanel.getIds().add(id);
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            private void setPanelColor(JPanel panel, Color color) {
                panel.setBackground(color);
                for (Component comp : panel.getComponents()) {
                    if (comp instanceof JPanel) {  //
                        comp.setBackground(color);
                    }
                }
            }


            private void restoreOriginalColors(JPanel panel, Color originalColor) {
                panel.setBackground(originalColor);
                for (Component comp : panel.getComponents()) {
                    if (comp instanceof JPanel) {
                        comp.setBackground(originalColor);
                    }
                }
            }
        };
    }
}
