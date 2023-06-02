package ru.nsu.boxberger.DiviPay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.boxberger.DiviPay.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    // Additional custom query methods can be defined here
}
