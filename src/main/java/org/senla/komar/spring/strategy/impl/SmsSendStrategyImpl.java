package org.senla.komar.spring.strategy.impl;

import lombok.AllArgsConstructor;
import org.senla.komar.spring.event.MessageSentEvent;
import org.senla.komar.spring.service.ChangingTemplateToPageService;
import org.senla.komar.spring.strategy.SendStrategy;

/**
 * @author Olga Komar
 * <p>
 * Created at 21.08.2024
 */
@AllArgsConstructor
public class SmsSendStrategyImpl implements SendStrategy {

  private ChangingTemplateToPageService changingTemplateToPageService;
  @Override
  public boolean sendMessage(MessageSentEvent messageSentEvent, String templateName) {
    System.out.println(changingTemplateToPageService.getHtmlFromFtl(templateName, messageSentEvent.getMessageData()));
    return true;
  }
}
