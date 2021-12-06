package org.leti.Repo;

import org.leti.Domain.TxOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxOutputRepo extends JpaRepository<TxOutput, Long> {
}
