package org.senla.komar.spring.service;

import org.senla.komar.spring.dto.AuditDto;
import org.senla.komar.spring.enums.DeliveryChannel;
import org.senla.komar.spring.enums.MessageType;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */

public interface AuditService {
  void createAudit(AuditDto auditDto);
}
