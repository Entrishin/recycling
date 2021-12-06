package org.leti.Repo;

import org.leti.Domain.TxInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxInputRepo extends JpaRepository<TxInput, Long> {
}
