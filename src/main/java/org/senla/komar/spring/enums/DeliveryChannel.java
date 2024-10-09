package org.senla.komar.spring.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Olga Komar
 * <p>
 * Created at 16.08.2024
 */
@Getter

public enum DeliveryChannel {
  EMAIL("EMAIL"), SMS("SMS");

  public static final String EMAIL_TYPE = "EMAIL";
  public static final String SMS_TYPE = "SMS";

  private final String name;

  DeliveryChannel(String name) {
    this.name = name;
  }
}

