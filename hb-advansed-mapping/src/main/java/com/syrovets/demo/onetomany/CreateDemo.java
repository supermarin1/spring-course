package com.syrovets.demo.onetomany;

import com.syrovets.demo.onetomany.entity.Course;
import com.syrovets.demo.onetomany.entity.Instructor;
import com.syrovets.demo.onetomany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-hb03.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            Instructor instructor = new Instructor("Susan", "Public", "susan@luv2code.com");

            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/susan", "Gamer");
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
