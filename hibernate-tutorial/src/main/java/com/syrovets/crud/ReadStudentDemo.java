package com.syrovets.crud;

import com.syrovets.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Daffy", "Duck", "daffu@gmail.com");

            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            System.out.println("id " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student retrievedStudent = session.get(Student.class,student.getId());

            System.out.println(retrievedStudent);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
