package com.syrovets.demo;

import com.syrovets.demo.config.DemoConfig;
import com.syrovets.demo.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        Account account = new Account();

        AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
        accountDao.addAccount(account, true);

//        System.out.println("THE RESULT SIZE IS " + accountDao.getAccountList().size());

        try{
            System.out.println("THE RESULT SIZE IS " + accountDao.getAccountListWithEx().size());
        } catch (Throwable e) {
            System.out.println("An exception thrown");
        }

        context.close();
    }
}
