package br.com.thiaguten.javamail.client.web;

import br.com.thiaguten.javamail.core.Email;
import br.com.thiaguten.javamail.core.EmailSender;
import br.com.thiaguten.javamail.core.SimpleEmail;
import br.com.thiaguten.javamail.core.SimpleEmailSender;
import br.com.thiaguten.javamail.core.support.ProxyAuthenticator;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/emailServlet")
public class EmailServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        java.net.Authenticator.setDefault(new ProxyAuthenticator("", ""));

        final String from = req.getParameter("from");
        final String to = req.getParameter("to");
        final String subject = req.getParameter("subject");
        final String message = req.getParameter("message");

        EmailSender sender = new SimpleEmailSender();
        Email email = new SimpleEmail(from, to, subject, message);
        try {
            sender.send(email);
            printOutput(resp, "Sent message successfully!");
        } catch (MessagingException e) {
            printOutput(resp, "Message not sent! " + e.getMessage());
        }
    }

    private void printOutput(HttpServletResponse resp, String... outputs) {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            writer.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
            writer.write("<html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"><title>Message</title></head><body>");
            for (Object output : outputs) {
                writer.write("<pre>" + output + "</pre>");
            }
            writer.write("<a href=\"index.jsp\">Back</a>");
            writer.write("</body></html>");
            writer.flush();
        } catch (IOException e) {
            getServletContext().log("Error printing output", e);
            e.printStackTrace();
        } finally {
            close(writer);
        }
    }

    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException ignore) {
                // NOP
            }
        }
    }
}
