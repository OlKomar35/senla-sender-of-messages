package org.senla.komar.spring.service.impl;

import java.nio.file.Path;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.senla.komar.spring.dto.MessageTemplateDto;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;
import org.senla.komar.spring.exception.TemplateNotFoundException;
import org.senla.komar.spring.mapper.MessageTemplateMapper;
import org.senla.komar.spring.repository.MessageTemplateRepository;
import org.senla.komar.spring.service.MessageTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Olga Komar
 * <p>
 * Created at 16.08.2024
 */
@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MessageTemplateServiceImpl implements MessageTemplateService {

  private final MessageTemplateRepository messageTemplateRepository;
  private final MessageTemplateMapper messageTemplateMapper;

  @Override
  public String getTemplateByDeliveryChannelAndMessageType(DeliveryChannel deliveryChannel, MessageType messageType) {
    MessageTemplateDto message = messageTemplateRepository
        .findByDeliveryChannelAndMessageType(deliveryChannel, messageType)
        .map(messageTemplateMapper::toMessageTemplateDto)
        .orElseThrow(() -> {
              log.debug("Not found Message template");
              return new TemplateNotFoundException("Not found Message template");
            }
        );
    log.info("Template name: " + message.getTemplateName());
    return message.getTemplateName();
  }
}
