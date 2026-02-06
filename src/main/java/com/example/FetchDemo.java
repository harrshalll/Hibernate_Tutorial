package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        //get or find-student 101
        Student student = session.find(Student.class,101);
        System.out.println(student);
        EntityManagerFactory emf =
                new Configuration().configure("hibernate.cfg.xml")
                        .buildSessionFactory();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String city = em.createQuery(
                        "SELECT a.city FROM Address a WHERE a.addressId = :id",
                        String.class
                )
                .setParameter("id", 1)
                .getSingleResult();

        System.out.println(city);
        em.getTransaction().commit();
        em.close();
        emf.close();
        session.close();
        sessionFactory.close();


    }
}
