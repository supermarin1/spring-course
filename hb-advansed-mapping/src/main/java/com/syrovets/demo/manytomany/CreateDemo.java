package com.syrovets.demo.manytomany;

import com.syrovets.demo.manytomany.entity.InstructorDetail;
import com.syrovets.demo.manytomany.entity.Review;
import com.syrovets.demo.manytomany.entity.Student;
import com.syrovets.demo.manytomany.entity.Course;
import com.syrovets.demo.manytomany.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
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

            Course course = new Course("Pacman - how to score one million points");
            session.save(course);

            Student student1 = new Student("John", "Doe", "john@gmail.com");
            Student student2 = new Student("Mary", "Public", "mary@gmail.com");

            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student1);
            session.save(student2);


            session.getTransaction().commit();

            System.out.println("\n >>>>>>DONE<<<<<< \n");
        } finally {
            factory.close();
        }
    }
}
