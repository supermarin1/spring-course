package com.msyrovets;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class FileRandomFortuneService implements FortuneService {
    private String path = "/Users/supermarin/IdeaProjects/spring-course/spring-demo-annotations/src/main/resources/fortunes.txt";
    private List<String> fortunes = new ArrayList<>();

    private Random random = new Random();

    File file = new File(path);

    public FileRandomFortuneService() {
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
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
