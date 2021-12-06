package org.leti.Repo;

import org.leti.Domain.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepo extends JpaRepository<TransactionType, Long> {
    TransactionType findByTitle(String title);
}
