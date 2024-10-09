package org.senla.komar.spring.strategy;

import org.senla.komar.spring.event.MessageSentEvent;

/**
 * @author Olga Komar
 * <p>
 * Created at 21.08.2024
 */
public interface SendStrategy {
  boolean sendMessage(MessageSentEvent messageSentEvent, String templateName);
}
