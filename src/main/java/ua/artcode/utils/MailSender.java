package ua.artcode.utils;

import ua.artcode.model.User;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MailSender {

    private static final String ENCODING = "UTF-8";
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String APPLICATION_ADDRESS = "aco16regsys@gmail.com";
    private static final String LOGIN = "aco16regsys";
    private static final String PASSWORD = "dreams_come_true";
    private static final String SMTP_PORT = "587";
    private static final String SUBJECT = "ACO16 registration";


    public static void sendEmail(User user) {

        String userEmail = user.getEmail();
        String userName = user.getName();
        String userSurname = user.getSurname();
        String userPhone = user.getPhone();
        String userPassword = user.getPassword();

        String content = String.format("Hello %s %s, you've been successfully registered in ACO16 application." +
                                            "%n Your password - %s, phone - %s",
                                                userName, userSurname, userPassword, userPhone);

        try {
            sendSimpleMessage(userEmail, content);
        } catch (MessagingException | UnsupportedEncodingException e) {
//            todo logger
            e.printStackTrace();
        }

    }

    /**
     * Send plain text massage
     */
    private static void sendSimpleMessage(String to, String content)
            throws MessagingException, UnsupportedEncodingException {
        Authenticator auth = new MyAuthenticator(LOGIN, PASSWORD);

        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.mime.charset", ENCODING);
        Session session = Session.getDefaultInstance(props, auth);

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(APPLICATION_ADDRESS));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(SUBJECT);
        msg.setText(content);
        Transport.send(msg);
    }

    private static class MyAuthenticator extends Authenticator {
        private String user;
        private String password;

        MyAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            String user = this.user;
            String password = this.password;
            return new PasswordAuthentication(user, password);
        }
    }
}