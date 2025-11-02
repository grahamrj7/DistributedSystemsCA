package com.example.dit.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dit.model.MembershipPlan;

public class MembershipPlanDAO {

    protected static EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("fitcenter_db");

    public MembershipPlanDAO() {}

    public void persist(MembershipPlan plan) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(plan);
        em.getTransaction().commit();
        em.close();
    }

    public void removePlan(MembershipPlan plan) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(plan));
        em.getTransaction().commit();
        em.close();
    }

    public MembershipPlan merge(MembershipPlan plan) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MembershipPlan updatedPlan = em.merge(plan);
        em.getTransaction().commit();
        em.close();
        return updatedPlan;
    }

    public List<MembershipPlan> getAllPlans() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<MembershipPlan> plans = new ArrayList<MembershipPlan>();
        plans = em.createQuery("from MembershipPlan").getResultList();
        em.getTransaction().commit();
        em.close();
        return plans;
    }

    public MembershipPlan getPlanByCode(String planCode) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MembershipPlan plan = em.find(MembershipPlan.class, planCode);
        em.getTransaction().commit();
        em.close();
        return plan;
    }
}
