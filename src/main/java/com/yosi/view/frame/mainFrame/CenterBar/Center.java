package com.yosi.view.frame.mainFrame.CenterBar;

import com.yosi.additions.Colors;
import com.yosi.services.YosiDAODB;
import com.yosi.services.YosiService;
import com.yosi.view.frame.mainFrame.CenterBar.InfoBar.InfoBar;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.ListPanel;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.OrdersInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Center extends JPanel implements Colors {

    private final ListPanel listPanel;
    private final InfoBar infoBar = new InfoBar();
    private final JScrollPane scrollPane;

    public Center(OrdersInfoPanel ordersInfoPanel,YosiService yosiService ) {
        listPanel = new ListPanel(ordersInfoPanel,yosiService);

        scrollPane = new JScrollPane(listPanel.getListPanel());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(infoBar.getInfoPanel());
        add(scrollPane);


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int parentWidth = getWidth();
                infoBar.adjustSize(parentWidth);
                scrollPane.getViewport().setPreferredSize(new Dimension((int) (getWidth() * 0.95), (int) (getHeight() * 0.90)));
                scrollPane.revalidate();


            }
        });
    }


    public ListPanel getListPanel() {
        return listPanel;
    }

}
