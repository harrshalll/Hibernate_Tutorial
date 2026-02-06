package com.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Project started..." );
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Student student = new Student();
        student.setStudent_id(101L);
        student.setName("JOHN");
        student.setCity("NEWYORK");
        System.out.println(student);
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        session.persist(student);
//        tx.commit();
//        session.close();

        //creating object of address class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("Mumbai");
        ad.setOpen(true);
        ad.setAddedDate(LocalDate.of(2003,5,21));
        ad.setX(123.455);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(ad);
        tx.commit();
        session.close();

    }
}
//find() -> find method of Hibernate Session return null if object is not found in cache as well as on database.
//find() involves database hit if object doesn't exist in session cache and returns fully initialized object which may involves several database call
//