package br.com.thiaguten.javamail.core.support;

public class MailAuthenticator extends javax.mail.Authenticator {

    private final String username, password;

    public MailAuthenticator(final String username, final String password) {
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty())
            throw new IllegalArgumentException("username and password must not be null");

        this.username = username;
        this.password = password;
    }

    @Override
    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
        return new javax.mail.PasswordAuthentication(username, password);
    }

}
