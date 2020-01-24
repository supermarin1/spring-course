package com.syrovets.demo.onetoone;

import com.syrovets.demo.onetoone.entity.Instructor;
import com.syrovets.demo.onetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateBiDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println(">>>>>>>>>" + instructorDetail.getInstructor().getFirstName() + "<<<<<<<<<<<");

            session.getTransaction().commit();

            System.out.println("\n >>>>>>DONE<<<<<< \n");
        } finally {
            factory.close();
        }
    }
}
