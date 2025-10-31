package com.example.fitcenter.model;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    private String paymentRef;
    private String dateString;
    private double amount;

    @ManyToOne
    private Member member;

    public Payment() {}

    // getters and setters...
}
