package com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels;

import com.yosi.additions.Borders;
import com.yosi.additions.Colors;
import com.yosi.additions.emailAdditions.TextAreaField;
import com.yosi.additions.emailAdditions.TextFieldMail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftEmailSection implements Borders, Colors {
    private static final int WIDTH = 565;
    private static final int HEIGHT = 620;

    private TextFieldMail userName;
    private TextFieldMail title;
    private TextFieldMail caseAbout;
    private TextFieldMail eMail;

    private TextAreaField areaField;


    public LeftEmailSection() {
        eMail = new TextFieldMail("Twój e-mail");
        userName = new TextFieldMail("Nazwa użytkownika");
        title = new TextFieldMail("Tytuł");
        caseAbout = new TextFieldMail("Czego dotyczy sprawa // mail wysyłki");
        areaField = new TextAreaField("Treść");

        
        eMail.getTextField().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailText = eMail.getTextField().getText();
                System.out.println("Email entered: " + emailText);
            }
        });
    }

    public JPanel getLeftSide() {
        JPanel leftSidePanel = new JPanel();
        leftSidePanel.setBackground(white);
        leftSidePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        leftSidePanel.setBorder(detailsBorder("Formularz"));



        leftSidePanel.add(userName.getPanel());
        leftSidePanel.add(title.getPanel());
        leftSidePanel.add(caseAbout.getPanel());
        leftSidePanel.add(eMail.getPanel());
        leftSidePanel.add(areaField.getPanel());


        return leftSidePanel;
    }



    public TextFieldMail getUserName() {
        return userName;
    }

    public TextFieldMail getTitle() {
        return title;
    }

    public TextFieldMail getCaseAbout() {
        return caseAbout;
    }

    public TextFieldMail getMail() {
        return eMail;
    }

    public TextAreaField getAreaField() {
        return areaField;
    }

}
