package com.yosi.controller.Listeners;


import com.yosi.additions.emailAdditions.EmailSender;
import com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels.EmailSection;
import com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels.LeftEmailSection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public interface EmailSenderListener {

    default ActionListener emailSender(EmailSection mail) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailSender emailSender = new EmailSender();

                    String eMail = mail.getLeftEmailSection().getMail().getText();
                String title = mail.getLeftEmailSection().getTitle().getText();
                String caseAbout = mail.getLeftEmailSection().getCaseAbout().getText();
                String to = mail.getLeftEmailSection().getMail().getText();
                emailSender.send("mta1997@wp.pl", title, caseAbout,eMail);

            }
        };
    }
}
