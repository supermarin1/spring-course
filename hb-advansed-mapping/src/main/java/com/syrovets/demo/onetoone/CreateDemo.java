package com.syrovets.demo.onetoone;

import com.syrovets.demo.onetoone.entity.Instructor;
import com.syrovets.demo.onetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com.luv2code", "Guitar");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();

            System.out.println("\n >>>>>>DONE<<<<<< \n");
        } finally {
            factory.close();
        }
    }
}
