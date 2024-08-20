package org.senla.komar.spring.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.senla.komar.spring.dto.AuditDto;
import org.senla.komar.spring.entity.Audit;
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
@Log4j2
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

  private final AuditRepository auditRepository;
  private final AuditMapper auditMapper;
  @Override
  public void createAudit(AuditDto auditDto) {
   Audit audit = auditRepository.save(auditMapper.toAudit(auditDto));
   log.info("The audit with id={} was successfully saved in the database", audit.getId() );
  }
}
