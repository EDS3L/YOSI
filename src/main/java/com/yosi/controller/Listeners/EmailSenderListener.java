package com.yosi.controller.Listeners;


import com.yosi.additions.EmailSender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public interface EmailSenderListener {

    default ActionListener emailSender() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailSender emailSender = new EmailSender();
                emailSender.send("mta1997@wp.pl", "Wielka promocja", "w dniu dzisjejszym jest mega promocja");

            }
        };
    }
}
