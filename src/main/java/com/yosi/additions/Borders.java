package com.yosi.additions;

import javax.swing.border.*;

import java.awt.*;

import static com.yosi.additions.Colors.*;

public interface Borders {


    public default Border border(String title) {
        Border lineBorder = new LineBorder(bg,2);
        TitledBorder titledBorder = new TitledBorder(lineBorder, title);
        titledBorder.setTitleColor(bg);
        titledBorder.setTitleFont(new Font("Sans-serif", Font.BOLD,15));

        Border marginBorder = new EmptyBorder(5,5,5,5);

        return new CompoundBorder(marginBorder,titledBorder);
    }

    public default Border detailsBorder(String title) {
        Border lineBorder = new LineBorder(blue,2);
        TitledBorder titledBorder = new TitledBorder(lineBorder, title);
        titledBorder.setTitleColor(blue);
        titledBorder.setTitleFont(new Font("Sans-serif", Font.BOLD,15));

        Border marginBorder = new EmptyBorder(5,5,5,5);

        return new CompoundBorder(marginBorder,titledBorder);
    }
}
