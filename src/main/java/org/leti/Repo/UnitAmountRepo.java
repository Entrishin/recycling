package org.leti.Repo;


import org.leti.Domain.UnitAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitAmountRepo extends JpaRepository<UnitAmount, Long> {
    UnitAmount findByTitle(String title);
}
