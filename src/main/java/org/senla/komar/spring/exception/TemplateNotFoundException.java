package org.senla.komar.spring.exception;

/**
 * @author Olga Komar
 * <p>
 * Created at 10.08.2024
 */
public class TemplateNotFoundException extends RuntimeException {
  public TemplateNotFoundException(String message) {
    super(message);
  }

}
