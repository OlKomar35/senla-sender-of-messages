package org.senla.komar.spring.strategy.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import lombok.AllArgsConstructor;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.event.MessageSentEvent;
import org.senla.komar.spring.processor.TemplateProcessor;
import org.senla.komar.spring.strategy.SendStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author Olga Komar
 * <p>
 * Created at 21.08.2024
 */
@AllArgsConstructor
@Service(DeliveryChannel.EMAIL_TYPE)
public class EmailSendStrategyImpl implements SendStrategy {

  private static final Logger log = LoggerFactory.getLogger(EmailSendStrategyImpl.class);
  private JavaMailSender javaMailSender;
  private MailProperties mailProperties;
  private TemplateProcessor templateProcessor;

  @Override
  public boolean sendMessage(MessageSentEvent messageSentEvent, String templateName) {
    try {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED,
          StandardCharsets.UTF_8.name());
        log.info("E-mail: {}", mailProperties.getUsername());
        log.info("Password: {}", mailProperties.getPassword());
      helper.setFrom(mailProperties.getUsername());
      helper.setTo(messageSentEvent.getMessageData().get("guestEmail").toString());
      helper.setSubject("Booking hotel");
      helper.setText(templateProcessor.getHtmlFromFtl(templateName, messageSentEvent.getMessageData()), true);
      javaMailSender.send(message);
      return true;
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}
