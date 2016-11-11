package br.com.thiaguten.javamail.client.standalone;

import br.com.thiaguten.javamail.core.*;

import javax.mail.MessagingException;

public class Main {

    public static void main(String[] args) {
        final String from = "me@gmail.com";
        final String to = "test@gmail.com";
        final String subject = "test";
        final String message = "test";

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
