package com.syrovets.crud;

import com.syrovets.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        System.out.println("open session");
        Session session = factory.openSession();

        try {
            System.out.println("creating studenr");
            Student student = new Student("Paul", "Wall", "paul@gmail.com");

            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("saving student");
            session.save(student);

            System.out.println("commit");
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
