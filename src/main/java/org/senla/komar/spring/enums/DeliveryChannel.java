package org.senla.komar.spring.enums;

import lombok.Getter;

/**
 * @author Olga Komar
 * <p>
 * Created at 16.08.2024
 */
@Getter
public enum DeliveryChannel {
  EMAIL("EMAIL"), SMS("SMS");
  private final String name;
  DeliveryChannel(String name) {
    this.name = name;

  }

}
