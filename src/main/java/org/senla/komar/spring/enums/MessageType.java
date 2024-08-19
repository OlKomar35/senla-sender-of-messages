package org.senla.komar.spring.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Olga Komar
 * <p>
 * Created at 07.08.2024
 */
@Getter
@RequiredArgsConstructor
public enum MessageType {
  NEW_BOOKING("NEW_BOOKING"), CANCELLED_BOOKING("CANCELLED_BOOKING");
  private final String name;

}
