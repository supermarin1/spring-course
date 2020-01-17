package com.msyrovets;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    Coach coach = context.getBean("myCoach", Coach.class);

    System.out.println(coach.getDailyWorkout());

    context.close();
  }

}
