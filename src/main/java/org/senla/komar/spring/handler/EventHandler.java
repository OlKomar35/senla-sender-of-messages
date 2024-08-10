package org.senla.komar.spring.handler;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;
import org.apache.kafka.common.protocol.types.Field.Str;
import org.senla.komar.spring.event.MessageSentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author Olga Komar
 * <p>
 * Created at 05.08.2024
 */
@Component
public class EventHandler {

  @Autowired
  private JavaMailSender javaMailSender;

  @KafkaListener(topics = "message-send-topic")
  public void handle(MessageSentEvent bookingMessageEvent) {
    System.out.println("***********************************************");
    System.out.println("Event received: " + bookingMessageEvent.toString());

    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    try {
      helper.setFrom("komar.olga.v@gmail.com");
      helper.setTo(bookingMessageEvent.getGuestEmail());
      helper.setSubject("Тестовое письмо");
      helper.setText("<p>Сообщение в формате <b>Html</b>.<br>Вторая строка.</p>", true);
      javaMailSender.send(message);
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }

}
