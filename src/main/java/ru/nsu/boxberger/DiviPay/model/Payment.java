package ru.nsu.boxberger.DiviPay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "payment_id")
    private Long paymentID;

    @Column(name = "purchase_id")
    private Long purchaseID;

    @Column(name = "user_id")
    private Long userID;
}
