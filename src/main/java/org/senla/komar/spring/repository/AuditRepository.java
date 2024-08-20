package org.senla.komar.spring.repository;

import org.senla.komar.spring.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */
@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {

}
