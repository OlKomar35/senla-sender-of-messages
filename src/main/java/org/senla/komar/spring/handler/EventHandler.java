package org.senla.komar.spring.handler;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.senla.komar.spring.dto.AuditDto;
import org.senla.komar.spring.event.MessageSentEvent;
import org.senla.komar.spring.processor.TemplateProcessor;
import org.senla.komar.spring.service.AuditService;
import org.senla.komar.spring.service.MessageTemplateService;
import org.springframework.boot.autoconfigure.mail.MailProperties;
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
  private final MailProperties mailProperties;
  private final MessageTemplateService messageTemplateService;
  private final AuditService auditService;
  private final TemplateProcessor templateProcessor;


  @KafkaListener(topics = "message-send-topic")
  public void handle(MessageSentEvent messageSentEvent) {

    log.info("Event received: " + messageSentEvent.toString());

    String templateName =
        messageTemplateService.getTemplateByDeliveryChannelAndMessageType(
            messageSentEvent.getDeliveryChannel(),
            messageSentEvent.getMessageType());

    try {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED,
          StandardCharsets.UTF_8.name());
      helper.setFrom(mailProperties.getUsername());
      helper.setTo(messageSentEvent.getMessageData().get("guestEmail").toString());
      helper.setSubject("Booking hotel");
      helper.setText(templateProcessor.getHtmlFromFtl(templateName, messageSentEvent.getMessageData()),
          true);
      javaMailSender.send(message);

      auditService.createAudit(new AuditDto(messageSentEvent.getUserId(),
          LocalDateTime.now(),
          messageSentEvent.getDeliveryChannel(),
          messageSentEvent.getMessageType()));
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }

}
