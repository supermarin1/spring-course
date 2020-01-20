package com.msyrovets;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class FileRandomFortuneService implements FortuneService {
    private List<String> fortunes = new ArrayList<>();

    @PostConstruct
    public void readTheFile() {
        String path = "/Users/supermarin/IdeaProjects/spring-course/spring-demo-annotations/src/main/resources/fortunes.txt";
        File file = new File(path);
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNext()) {
                fortunes.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDailyFortune() {
        Random random = new Random();
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
