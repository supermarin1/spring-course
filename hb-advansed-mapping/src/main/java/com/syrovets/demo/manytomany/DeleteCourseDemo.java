package com.syrovets.demo.manytomany;

import com.syrovets.demo.manytomany.entity.Course;
import com.syrovets.demo.manytomany.entity.Instructor;
import com.syrovets.demo.manytomany.entity.InstructorDetail;
import com.syrovets.demo.manytomany.entity.Review;
import com.syrovets.demo.manytomany.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-hb05.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            int id = 11;

            Course student = session.get(Course.class, id);
            session.delete(student);

            session.getTransaction().commit();

            System.out.println("\n >>>>>>DONE<<<<<< \n");
        } finally {
            factory.close();
        }
    }
}
