package com.syrovets.demo.dao;

import com.syrovets.demo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {

    public void addAccount(){
        System.out.println("\n" + getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT \n");
    }

    public void addAccount(Account account, boolean vip){
        System.out.println("\n" + getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT: " + account.toString() + " \n");
    }

    public List<Account> getAccountList(){
        List<Account> accounts = new ArrayList<>();
        accounts.add( new Account("me", "1"));
        accounts.add( new Account("you", "2"));
        accounts.add( new Account("she", "3"));
        return accounts;
    }

    public List<Account> getAccountListWithEx(){
        List<Account> accounts = new ArrayList<>();
        accounts.add( new Account("me", "1"));
        accounts.add( new Account("you", "2"));
        accounts.add(5, new Account("she", "3"));
        return accounts;
    }

}
