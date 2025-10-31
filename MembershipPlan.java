package com.example.fitcenter.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class MembershipPlan {
    @Id
    private String planCode;
    private String description;
    private double totalCost;

    @OneToMany(mappedBy = "membershipPlan")
    private List<Member> members;

    public MembershipPlan() {}

}
