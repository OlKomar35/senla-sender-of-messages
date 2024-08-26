package org.senla.komar.spring.exception;

/**
 * @author Olga Komar
 * <p>
 * Created at 10.08.2024
 */
public class StrategyNotCreatedException extends RuntimeException {
  public StrategyNotCreatedException(String message) {
    super(message);
  }

}
