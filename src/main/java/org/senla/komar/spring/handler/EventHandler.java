package org.senla.komar.spring.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.senla.komar.spring.event.MessageSentEvent;
import org.senla.komar.spring.service.MessageTemplateService;
import org.senla.komar.spring.strategy.SendStrategyFactory;
import org.springframework.kafka.annotation.KafkaListener;
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

  private final MessageTemplateService messageTemplateService;
  private final SendStrategyFactory sendStrategyFactory;

  @KafkaListener(topics = "message-send-topic")
  public void handle(MessageSentEvent messageSentEvent) {

    log.info("Event received: " + messageSentEvent.toString());

    String templateName =
        messageTemplateService.getTemplateByDeliveryChannelAndMessageType(
            messageSentEvent.getDeliveryChannel(),
            messageSentEvent.getMessageType());

    sendStrategyFactory.execute(messageSentEvent.getDeliveryChannel(), messageSentEvent, templateName);

  }

}
