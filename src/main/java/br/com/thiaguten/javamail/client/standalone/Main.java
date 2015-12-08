package br.com.thiaguten.javamail.client.standalone;

import br.com.thiaguten.javamail.core.*;

import javax.mail.MessagingException;

public class Main {

//    static {
//        // proxy
//        System.setProperty("http.proxyHost", "");
//        System.setProperty("http.proxyPort", "");
//        java.net.Authenticator.setDefault(new java.net.Authenticator() {
//            @Override
//            protected java.net.PasswordAuthentication getPasswordAuthentication() {
//                return new java.net.PasswordAuthentication("", "".toCharArray());
//            }
//        });
//    }

    public static void main(String[] args) {
        final String from = "";
        final String to = "";
        final String subject = "";
        final String message = "";

        Email email = new SimpleEmail(from, to, subject, message);
        EmailSender sender = new SimpleEmailSender(new EmailConfiguration());
        try {
            sender.send(email);
            System.out.println("Sent message successfully!");
        } catch (MessagingException e) {
            System.err.println("Message not sent!");
            e.printStackTrace();
        }
    }
}
