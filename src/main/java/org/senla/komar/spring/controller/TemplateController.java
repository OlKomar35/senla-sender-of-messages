package org.senla.komar.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Olga Komar
 * <p>
 * Created at 26.08.2024
 */
@RestController
@RequestMapping("/templates")
public class TemplateController {

  @GetMapping("/message-types")
  public List<String> getMessageTypes() {
      return Arrays.stream(MessageType.values())
        .map(MessageType::getName)
        .collect(Collectors.toList());
  }

  @GetMapping("/delivery-channels")
  public List<String> getDeliveryChannels() {
      return Arrays.stream(DeliveryChannel.values())
        .map(DeliveryChannel::getName)
        .collect(Collectors.toList());
  }
}
