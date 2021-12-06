package org.leti.Repo;

import org.leti.Domain.PaymentGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentGateWayRepo extends JpaRepository<PaymentGateway, Long> {
}
