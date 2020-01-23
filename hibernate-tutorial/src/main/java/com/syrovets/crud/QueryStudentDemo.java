package com.syrovets.crud;

import com.syrovets.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            List<Student> studentList = session.createQuery("from Student").getResultList();
            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").getResultList();
            displayStudents(studentList);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        System.out.println("\n");
        studentList.forEach(System.out::println);
        System.out.println("\n");
    }
}
