package com.msyrovets;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach coach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        boolean result = coach == alphaCoach;
        System.out.println("Pointing to the same objects: " + result);

        System.out.println("Memory location for the coach: " + coach);
        System.out.println("Memory location for the alphaCoach: " + alphaCoach);

        context.close();
    }
}
