package br.com.thiaguten.javamail.core;

import br.com.thiaguten.javamail.core.support.MailAuthenticator;
import br.com.thiaguten.javamail.core.support.MailConfiguration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SimpleEmailSender implements EmailSender {

    @Override
    public void send(Email email) throws MessagingException {
        Properties properties = MailConfiguration.getConfiguration();
        Session session = Session.getInstance(
                properties,
                new MailAuthenticator(
                        properties.getProperty("mail.user"),
                        properties.getProperty("mail.password")
                )
        );
        Message message = new MimeMessage(session);

        // extract and creates addresses (to)
        String[] to = getEmails(email.getTo());
        Address[] addresses = new Address[to.length];
        for (int i = 0; i < to.length; i++) {
            if (to[i].isEmpty())
                continue;
            addresses[i] = new InternetAddress(to[i]);
        }
        message.addRecipients(Message.RecipientType.TO, addresses);

        // extract and creates address (from)
        String from = email.getFrom();
        if (from == null || from.trim().isEmpty()) {
            message.setFrom();
        } else {
            String[] froms = getEmails(from);
            message.setFrom(new InternetAddress(froms[0]));
        }

        message.setSentDate(new Date());
        message.setSubject(email.getSubject());
        message.setText(email.getMessage());
        Transport.send(message);
    }

    /**
     * Parse the given comma, semi-colons or whitespace character [ \t\n\x0b\r\f] separated sequence of addresses
     */
    private String[] getEmails(String recipients) {
        if (recipients == null) return null;
        return recipients.split("\\s*(,|;|\\s)\\s*");
    }
}
