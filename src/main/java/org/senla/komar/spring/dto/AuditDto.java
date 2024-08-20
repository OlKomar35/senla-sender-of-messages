package org.senla.komar.spring.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditDto {

  @NotNull
  private Long userId;

  @FutureOrPresent
  private LocalDateTime createdAt;

  @NotNull
  private DeliveryChannel deliveryChannel;

  @NotNull
  private MessageType messageType;
}
