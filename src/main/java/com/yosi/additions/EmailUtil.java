package com.yosi.additions;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class EmailUtil {

    public static void sendEmail(Session session, String toEmail, String subject, String body){
        try {
            MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress("turborower@serwer2492574.home.pl", "YOSI"));

            msg.setReplyTo(InternetAddress.parse("turborower@serwer2492574.home.pl", false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            Transport.send(msg);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
