package com.egurel.petClinic.Repository;

import com.egurel.petClinic.Entity.Visit;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface VisitRepository  extends JpaRepository<Visit, Long> {
}
