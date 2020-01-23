package com.syrovets.crud;

import com.syrovets.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        System.out.println("open session");
        Session session = factory.openSession();

        try {
            Student student1 = new Student("John", "Doe", "john@gmail.com");
            Student student2 = new Student("Mary", "Public", "mary@gmail.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@gmail.com");

            session.beginTransaction();

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
