package org.senla.komar.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "audit")
public class Audit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  protected Long id;

  @Column(name = "user_id")
  protected Long userId;

  @Column(name = "send_at")
  private LocalDateTime createdAt;


  @Column(name = "delivery_channel")
  @Enumerated(EnumType.STRING)
  private DeliveryChannel deliveryChannel;

  @Column(name = "message_type")
  @Enumerated(EnumType.STRING)
  private MessageType messageType;

}
