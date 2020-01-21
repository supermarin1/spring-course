package com.syrovets.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Getter
@Setter
public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private String[] operatingSystems;

    private HashMap<String, String> countryOptions;

    public Student() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brasil");
        countryOptions.put("FR", "France");
        countryOptions.put("GE", "Germany");
        countryOptions.put("IN", "India");
    }
}
