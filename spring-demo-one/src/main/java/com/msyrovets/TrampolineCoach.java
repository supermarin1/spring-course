package com.msyrovets;

public class TrampolineCoach implements Coach {

  private FortuneService fortuneService;

  public TrampolineCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Jump high for 10 minutes";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }
}
