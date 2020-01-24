package com.syrovets.demo.onetomany;

import com.syrovets.demo.onetomany.entity.Course;
import com.syrovets.demo.onetomany.entity.Instructor;
import com.syrovets.demo.onetomany.entity.InstructorDetail;
import com.syrovets.demo.onetomany.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-hb04.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            int id = 10;

            Course course = session.get(Course.class, id);

            if(course != null) {
                course.getReviewList().forEach(System.out::println);
            }

            session.getTransaction().commit();

            System.out.println("\n >>>>>>DONE<<<<<< \n");
        } finally {
            factory.close();
        }
    }
}
