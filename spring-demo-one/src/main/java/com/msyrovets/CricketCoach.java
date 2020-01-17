package com.msyrovets;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    private String email;

    private String team;

    public CricketCoach() {
        System.out.println("CricketCoach: inside non-args constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setFortuneService method");
        this.fortuneService = fortuneService;
    }

    public void setEmail(String email) {
        System.out.println("CricketCoach: inside setEmail method");
        this.email = email;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setTeam method");
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 min";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
