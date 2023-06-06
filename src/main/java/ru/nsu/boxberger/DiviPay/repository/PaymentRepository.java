package ru.nsu.boxberger.DiviPay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.boxberger.DiviPay.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
