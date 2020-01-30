package com.syrovets.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount(){
        System.out.println("\n" + getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP \n");
    }

    public void addSomethingStrange(){
        System.out.println("\n" + getClass() + ": DOING MY DB WORK: ADDING SOMETHING STRANGE \n");
    }
}
