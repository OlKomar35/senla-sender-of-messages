package org.senla.komar.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.senla.komar.spring.dto.AuditDto;
import org.senla.komar.spring.mapper.AuditMapper;
import org.senla.komar.spring.repository.AuditRepository;
import org.senla.komar.spring.service.AuditService;
import org.springframework.stereotype.Service;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */
@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

  private final AuditRepository auditRepository;
  private final AuditMapper auditMapper;
  @Override
  public void createAudit(AuditDto auditDto) {
   auditRepository.save(auditMapper.toAudit(auditDto));
  }
}
