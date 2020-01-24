package com.syrovets.demo.onetoone;

import com.syrovets.demo.onetoone.entity.Instructor;
import com.syrovets.demo.onetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteBiDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-hb01.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            if(instructorDetail != null) {
                session.delete(instructorDetail);
            }

            session.getTransaction().commit();

            System.out.println("\n >>>>>>DONE<<<<<< \n");
        } finally {
            factory.close();

        }
    }
}
