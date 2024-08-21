package org.senla.komar.spring.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.senla.komar.spring.event.MessageSentEvent;
import org.senla.komar.spring.service.ChangingTemplateToPageService;
import org.senla.komar.spring.strategy.SendStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @author Olga Komar
 * <p>
 * Created at 21.08.2024
 */
@AllArgsConstructor
public class EmailSendStrategyImpl implements SendStrategy {

  private JavaMailSender javaMailSender;
  private MailProperties mailProperties;
  private ChangingTemplateToPageService changingTemplateToPageService;


  @Override
  public boolean sendMessage(MessageSentEvent messageSentEvent, String templateName) {
    try {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED,
          StandardCharsets.UTF_8.name());
      helper.setFrom(mailProperties.getUsername());
      helper.setTo(messageSentEvent.getMessageData().get("guestEmail").toString());
      helper.setSubject("Booking hotel");
      helper.setText(changingTemplateToPageService.getHtmlFromFtl(templateName, messageSentEvent.getMessageData()),
          true);
      javaMailSender.send(message);
      return true;
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}
