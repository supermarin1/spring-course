package com.msyrovets;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] data = {
            "Beware of the wolf",
            "Diligence is the mother of good luck",
            "The journey is reward"
    };

    private Random random = new Random();

    @Override
    public String getDailyFortune() {
        return data[random.nextInt(data.length)];
    }
}
