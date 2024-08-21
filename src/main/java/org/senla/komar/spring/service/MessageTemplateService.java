package org.senla.komar.spring.service;

import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;

/**
 * @author Olga Komar
 * <p>
 * Created at 16.08.2024
 */

public interface MessageTemplateService {
  String getTemplateByDeliveryChannelAndMessageType(DeliveryChannel deliveryChannel, MessageType messageType);
}
