package com.syrovets.dao;

import com.syrovets.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public void addAccount(){
        System.out.println("\n" + getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT \n");
    }

    public void addAccount(Account account, boolean vip){
        System.out.println("\n" + getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT: " + account.toString() + " \n");
    }
}
