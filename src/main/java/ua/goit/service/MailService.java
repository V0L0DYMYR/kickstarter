package ua.goit.service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {

  private final Properties props;
  private final String username;
  private final String password;

  public MailService() {
    props = System.getProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.mail.yahoo.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.stmp.user", "yyy@yahoo.com");
    props.put("mail.smtp.password", "ppp");

    username = props.getProperty("mail.stmp.user");
    password = props.getProperty("mail.smtp.password");
  }

  public void sendMail(String recipient, String subject, String text) {
    Session session = Session.getDefaultInstance(props, new EmailAuthenticator(username, password));

    try {
      MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(username));
      msg.setRecipients(Message.RecipientType.TO,
          InternetAddress.parse(recipient));
      msg.setText(text);
      msg.setSubject(subject);

      Transport.send(msg);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {

    MailService mailService = new MailService();
    mailService.sendMail("xxx@gmail.com", "KickStarter registration", "Hello");

  }

  private static class EmailAuthenticator extends javax.mail.Authenticator {
    private final String username;
    private final String password;

    private EmailAuthenticator(String username, String password) {
      this.username = username;
      this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(username, password);
    }
  }

}
