package com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import com.yosi.additions.emailAdditions.TextAreaField;
import com.yosi.additions.emailAdditions.TextFieldMail;

import javax.swing.*;
import java.awt.*;

public class LeftEmailSection implements Borders, Colors {
    private static final int WIDTH = 565;
    private static final int HEIGHT = 620;

    private TextFieldMail toMail;
    private TextFieldMail title;
    private TextFieldMail eMail;
    private TextAreaField areaField;


    public LeftEmailSection() {

    }

    public JPanel getLeftSide() {
        JPanel leftSidePanel = new JPanel();
        leftSidePanel.setBackground(white);
        leftSidePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        leftSidePanel.setBorder(detailsBorder("Formularz"));

        eMail = new TextFieldMail("Twój e-mail");
        toMail = new TextFieldMail("Gdzie chcesz wysłać");
        title = new TextFieldMail("Tytuł");
        areaField = new TextAreaField("Treść");


        leftSidePanel.add(toMail.getPanel());
        leftSidePanel.add(title.getPanel());
        leftSidePanel.add(eMail.getPanel());
        leftSidePanel.add(areaField.getPanel());


        return leftSidePanel;
    }



    public TextFieldMail getToMail() {
        return toMail;
    }

    public TextFieldMail getTitle() {
        return title;
    }

    public TextFieldMail getMail() {
        return eMail;
    }

    public TextAreaField getAreaField() {
        return areaField;
    }


}
