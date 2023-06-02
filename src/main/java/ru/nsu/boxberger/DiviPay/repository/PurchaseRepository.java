package ru.nsu.boxberger.DiviPay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.boxberger.DiviPay.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    // Additional custom query methods can be defined here
}
