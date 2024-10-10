package org.senla.komar.spring.event;


import lombok.*;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;

import java.util.Map;

/**
 * @author Olga Komar
 * <p>
 * Created at 03.08.2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MessageSentEvent {
  private MessageType messageType;
  private DeliveryChannel deliveryChannel;
  private Long userId;
  private Map<String , Object> messageData;

}
