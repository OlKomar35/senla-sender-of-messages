package org.senla.komar.spring.handler;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.senla.komar.spring.dto.AuditDto;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.event.MessageSentEvent;
import org.senla.komar.spring.service.AuditService;
import org.senla.komar.spring.service.ChangingTemplateToPageService;
import org.senla.komar.spring.service.MessageTemplateService;
import org.senla.komar.spring.service.impl.EmailSendStrategyImpl;
import org.senla.komar.spring.strategy.SendStrategy;
import org.senla.komar.spring.strategy.impl.SmsSendStrategyImpl;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
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
  private final ChangingTemplateToPageService changingTemplateToPageService;
  private SendStrategy sendStrategy;

  @KafkaListener(topics = "message-send-topic")
  public void handle(MessageSentEvent messageSentEvent) {

    log.info("Event received: " + messageSentEvent.toString());

    String templateName =
        messageTemplateService.getTemplateByDeliveryChannelAndMessageType(
            messageSentEvent.getDeliveryChannel(),
            messageSentEvent.getMessageType());

    if(messageSentEvent.getDeliveryChannel().equals(DeliveryChannel.EMAIL)){
      sendStrategy = new EmailSendStrategyImpl(javaMailSender,mailProperties,changingTemplateToPageService);
    } else {
      sendStrategy = new SmsSendStrategyImpl(changingTemplateToPageService);
    }

    if(sendStrategy.sendMessage(messageSentEvent, templateName)){
      auditService.createAudit(new AuditDto(messageSentEvent.getUserId(),
          LocalDateTime.now(),
          messageSentEvent.getDeliveryChannel(),
          messageSentEvent.getMessageType()));
    }

  }

}
