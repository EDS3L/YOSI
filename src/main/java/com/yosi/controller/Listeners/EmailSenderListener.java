package com.yosi.controller.Listeners;


import com.yosi.additions.emailAdditions.EmailSender;
import com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels.EmailSection;
import com.yosi.view.frame.mainFrame.TopBar.Support.EmailSectionPanels.LeftEmailSection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public interface EmailSenderListener {

    default ActionListener emailSender() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailSender emailSender = new EmailSender();
                EmailSection mail = new EmailSection();


                LeftEmailSection leftEmailSection = mail.getLeftEmailSection();
                if (leftEmailSection != null) {
                    JTextField emailTextField = leftEmailSection.getMail().getTextField();
                    String emailText = emailTextField.getText();
                    System.out.println("Email: " + emailText);
                } else {
                    System.out.println("LeftEmailSection is null");
                }
            }
        };
    }
}
