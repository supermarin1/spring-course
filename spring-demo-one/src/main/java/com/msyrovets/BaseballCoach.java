package com.msyrovets;

public class BaseballCoach implements Coach {

  private FortuneService fortuneService;

  public BaseballCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  public String getDailyWorkout() {
    return "Spend 30 min on batting practice";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }
}
