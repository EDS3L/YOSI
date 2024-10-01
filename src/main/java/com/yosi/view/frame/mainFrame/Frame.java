package com.yosi.view.frame.mainFrame;

import com.yosi.additions.Colors;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame implements Colors {
    private static final int WIDTH = 1140;
    private static final int HEIGHT = 620;

    public Frame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(bg);
        setLayout(new BorderLayout());
    }
}
