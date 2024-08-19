package org.senla.komar.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;

/**
 * @author Olga Komar
 * <p>
 * Created at 16.08.2024
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = false)

@Entity
@Table(name = "message_template")
public class MessageTemplate extends BaseEntity<Integer> {

  @Column(name = "delivery_channel")
  @Enumerated(EnumType.STRING)
  private DeliveryChannel deliveryChannel;

  @Column(name = "message_type")
  @Enumerated(EnumType.STRING)
  private MessageType messageType;

  @Column(name = "name")
  private String templateName;

  @Column(name = "title")
  private String title;
}
