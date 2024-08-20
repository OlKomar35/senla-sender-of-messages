package org.senla.komar.spring.mapper;

import org.mapstruct.Mapper;
import org.senla.komar.spring.dto.AuditDto;
import org.senla.komar.spring.entity.Audit;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */
@Mapper(componentModel = "spring")
public interface AuditMapper {
  Audit toAudit(AuditDto auditDto);
  AuditDto toAuditDto(Audit audit);
}
