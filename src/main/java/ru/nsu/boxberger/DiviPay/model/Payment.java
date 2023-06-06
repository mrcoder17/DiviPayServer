package ru.nsu.boxberger.DiviPay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "amount")
    private double amount;

}
