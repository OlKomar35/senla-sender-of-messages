package org.senla.komar.spring.mapper;

import org.mapstruct.Mapper;
import org.senla.komar.spring.dto.MessageTemplateDto;
import org.senla.komar.spring.entity.MessageTemplate;

/**
 * @author Olga Komar
 * <p>
 * Created at 16.08.2024
 */
@Mapper(componentModel = "spring")
public interface MessageTemplateMapper {
  MessageTemplate toMessageTemplate(MessageTemplateDto messageTemplateDto);
  MessageTemplateDto toMessageTemplateDto(MessageTemplate messageTemplate);
}
