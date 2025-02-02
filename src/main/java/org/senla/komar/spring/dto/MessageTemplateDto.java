package org.senla.komar.spring.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;

/**
 * @author Olga Komar
 * <p>
 * Created at 16.08.2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageTemplateDto {

  private Integer id;

  @NotNull
  private DeliveryChannel deliveryChannel;

  @NotNull
  private MessageType messageType;

  @NotNull
  private String templateName;

  private String title;
}
