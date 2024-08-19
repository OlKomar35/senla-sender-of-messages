package org.senla.komar.spring.handler;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.senla.komar.spring.dto.MessageTemplateDto;
import org.senla.komar.spring.event.MessageSentEvent;
import org.senla.komar.spring.service.MessageTemplateService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author Olga Komar
 * <p>
 * Created at 05.08.2024
 */
@Component
@Log4j2
@RequiredArgsConstructor
public class EventHandler {

  private final JavaMailSender javaMailSender;
  private final MessageTemplateService messageTemplateService;

  @KafkaListener(topics = "message-send-topic")
  public void handle(MessageSentEvent messageSentEvent) {

    log.info("Event received: " + messageSentEvent.toString());

    String templateName =
        messageTemplateService.getTemplateByDeliveryChannelAndMessageType(
            messageSentEvent.getDeliveryChannel(),
            messageSentEvent.getMessageType());
    log.info("Template name: " + templateName);

    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    try {
      helper.setFrom("komar.olga.v@gmail.com");
      helper.setTo(messageSentEvent.getGuestEmail());
     // helper.setSubject(messageTemplateDto.getTitle());
      helper.setText("<p>Сообщение в формате <b>Html</b>.<br>Вторая строка.</p>", true);
      javaMailSender.send(message);
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }

}
