package com.yosi.additions.emailAdditions;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class EmailSender {
    final String fromEmail = "turborower@serwer2492574.home.pl";
    final String password = "Tajne123!";

    public EmailSender() {
    }

    public void send(String toEmail, String subject, String content, String userEmail) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "serwer2492574.home.pl");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);

        String finalContent = content + userEmail;

        EmailUtil.sendEmail(session, toEmail, subject, finalContent);

    }
}
