package com.msyrovets;

public class TrackCoach implements Coach {
  private FortuneService fortuneService;

  public TrackCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5k";
  }

  @Override
  public String getDailyFortune() {
    return "Just do it: " + fortuneService.getFortune();
  }

  private void doMyStartupStaff() {
    System.out.println("TrackCoach: inside method doMyStartupStaff");
  }

  private void doMyCleanupStaff() {
    System.out.println("TrackCoach: inside method doMyCleanupStaff");
  }


}
