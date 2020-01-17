package com.msyrovets;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        String[] fortunes = new String[]{
                "You're the best today",
                "Love yourself",
                "You can do everything"
        };

        Random random = new Random();

        return fortunes[random.nextInt(3)];
    }
}
