package org.senla.komar.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.springframework.stereotype.Component;


/**
 * @author Olga Komar
 * <p>
 * Created at 26.08.2024
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface ServiceWithType {
  String ttype();
}
