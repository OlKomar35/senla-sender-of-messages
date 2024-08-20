package org.senla.komar.spring.config;

import java.util.Properties;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author Olga Komar
 * <p>
 * Created at 10.08.2024
 */
@Configuration

public class MailConfig {

  @Bean
  public MailProperties mailProperties() {
    return new MailProperties();
  }
  @Bean
  public JavaMailSender mailSender(MailProperties mailProperties) {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(mailProperties.getHost());
    mailSender.setPort(mailProperties.getPort());
    mailSender.setUsername(mailProperties.getUsername());
    mailSender.setPassword(mailProperties.getPassword());

    Properties properties = mailSender.getJavaMailProperties();
    properties.put("mail.transport.protocol", mailProperties.getProtocol());
    properties.put("mail.smtp.auth", mailProperties.getProperties().get("mail.smtp.auth"));
    properties.put("mail.smtp.starttls.enable", mailProperties.getProperties().get("mail.smtp.starttls.enable"));
    properties.put("mail.debug", "true");
    return mailSender;
  }

}
