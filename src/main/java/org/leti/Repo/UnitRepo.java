package org.leti.Repo;

import org.leti.Domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepo  extends JpaRepository<Unit,Long> {
    Unit findByTitle(String title);
}
