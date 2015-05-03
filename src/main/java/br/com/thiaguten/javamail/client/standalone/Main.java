package br.com.thiaguten.javamail.client.standalone;

import br.com.thiaguten.javamail.core.Email;
import br.com.thiaguten.javamail.core.EmailSender;
import br.com.thiaguten.javamail.core.SimpleEmail;
import br.com.thiaguten.javamail.core.SimpleEmailSender;
import br.com.thiaguten.javamail.core.support.ProxyAuthenticator;

import javax.mail.MessagingException;

public class Main {

    public static void main(String[] args) {

//        java.net.Authenticator.setDefault(new ProxyAuthenticator("", ""));

        final String from = "";
        final String to = "";
        final String subject = "";
        final String message = "";

        EmailSender sender = new SimpleEmailSender();
        Email email = new SimpleEmail(from, to, subject, message);

        try {
            sender.send(email);
            System.out.println("Sent message successfully!");
        } catch (MessagingException e) {
            System.err.println("Message not sent!");
            e.printStackTrace();
        }

    }
}
