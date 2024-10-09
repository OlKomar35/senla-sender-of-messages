package org.senla.komar.spring.strategy;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.senla.komar.spring.dto.AuditDto;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.event.MessageSentEvent;
import org.senla.komar.spring.exception.StrategyNotCreatedException;
import org.senla.komar.spring.service.AuditService;
import org.springframework.stereotype.Component;

/**
 * @author Olga Komar
 * <p>
 * Created at 26.08.2024
 */
@Component
@RequiredArgsConstructor
public class SendStrategyFactory {

  private final Map<String, SendStrategy> sendStrategyMap;
  private final AuditService auditService;

  public SendStrategy getSendStrategy(DeliveryChannel deliveryChanel) {
    SendStrategy sendStrategy = sendStrategyMap.get(deliveryChanel.getName());
    if(sendStrategy == null){
      throw new StrategyNotCreatedException("The strategy has not been created");
    }
    return sendStrategy;
  }

  public void execute(DeliveryChannel deliveryChanel, MessageSentEvent messageSentEvent, String templateName ){
    SendStrategy sendStrategy = getSendStrategy(deliveryChanel);
    if (sendStrategy.sendMessage(messageSentEvent, templateName)) {
      auditService.createAudit(new AuditDto(messageSentEvent.getUserId(),
          LocalDateTime.now(),
          messageSentEvent.getDeliveryChannel(),
          messageSentEvent.getMessageType()));
    }
  }
}
