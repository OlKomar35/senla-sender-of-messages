package org.senla.komar.spring.strategy.impl;

import lombok.AllArgsConstructor;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.event.MessageSentEvent;
import org.senla.komar.spring.processor.TemplateProcessor;
import org.senla.komar.spring.strategy.SendStrategy;
import org.springframework.stereotype.Service;

/**
 * @author Olga Komar
 * <p>
 * Created at 21.08.2024
 */
@AllArgsConstructor
@Service(DeliveryChannel.SMS_TYPE)
public class SmsSendStrategyImpl implements SendStrategy {


  private TemplateProcessor templateProcessor;
  @Override
  public boolean sendMessage(MessageSentEvent messageSentEvent, String templateName) {
    System.out.println(templateProcessor.getHtmlFromFtl(templateName, messageSentEvent.getMessageData()));
    return true;
  }
}
