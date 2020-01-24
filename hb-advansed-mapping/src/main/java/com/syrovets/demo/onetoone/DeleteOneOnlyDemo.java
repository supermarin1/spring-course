package com.syrovets.demo.onetoone;

import com.syrovets.demo.onetoone.entity.Instructor;
import com.syrovets.demo.onetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOneOnlyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            int id = 3;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            if(instructorDetail != null) {
                instructorDetail.getInstructor().setInstructorDetail(null); // <--- need to break the link
                session.delete(instructorDetail);
            }

            session.getTransaction().commit();

            System.out.println("\n >>>>>>DONE<<<<<< \n");
        } finally {
            factory.close();

        }
    }
}
