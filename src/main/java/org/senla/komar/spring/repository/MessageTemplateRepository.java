package org.senla.komar.spring.repository;

import java.util.Optional;
import org.senla.komar.spring.entity.MessageTemplate;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Olga Komar
 * <p>
 * Created at 16.08.2024
 */
@Repository
public interface MessageTemplateRepository extends JpaRepository<MessageTemplate, Integer> {
 Optional<MessageTemplate> findByDeliveryChannelAndMessageType(DeliveryChannel deliveryChannel, MessageType messageType);
}
