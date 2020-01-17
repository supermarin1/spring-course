package com.msyrovets;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
    String[] fortunes = new String[]{
            "You're the best today",
            "Love yourself",
            "You can do everything"
    };

    Random random = new Random();
    @Override
    public String getFortune() {
        return fortunes[random.nextInt(fortunes.length)];
    }
}
