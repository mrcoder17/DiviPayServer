package ru.nsu.boxberger.DiviPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.boxberger.DiviPay.model.Payment;
import ru.nsu.boxberger.DiviPay.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Другие методы сервиса
}
