package com.example.dit.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dit.model.Member;

public class MemberDAO {

    protected static EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("fitcenter_db");

    public MemberDAO() {}

    public void persist(Member member) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(member);
        em.getTransaction().commit();
        em.close();
    }

    public void removeMember(Member member) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(member));
        em.getTransaction().commit();
        em.close();
    }

    public Member merge(Member member) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Member updatedMember = em.merge(member);
        em.getTransaction().commit();
        em.close();
        return updatedMember;
    }

 
    public List<Member> getAllMembers() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Member> members = new ArrayList<Member>();
        members = em.createQuery("from Member").getResultList();
        em.getTransaction().commit();
        em.close();
        return members;
    }

    public Member getMemberById(String membershipId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Member m = em.find(Member.class, membershipId);
        em.getTransaction().commit();
        em.close();
        return m;
    }
}
