package com.example.fitcenter.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id
    private String membershipId;
    private String name;
    private String phoneNumber;
    private String address;
    private String fitnessGoal;

    @ManyToOne
    private MembershipPlan membershipPlan;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    public Member() {}

    // getters and setters...
}

