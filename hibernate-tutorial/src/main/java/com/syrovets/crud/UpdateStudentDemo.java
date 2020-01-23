package com.syrovets.crud;

import com.syrovets.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            int studentId = 1;

            session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            student.setFirstName("Scooby");

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
