package com.syrovets;

import com.syrovets.config.DemoConfig;
import com.syrovets.dao.AccountDao;
import com.syrovets.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        Account account = new Account();

        AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
        accountDao.addAccount(account, true);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addAccount();

        System.out.println("\n >>>>> wait <<<<< \n");
        membershipDAO.addAccount();

        System.out.println("\n >>>>> wait <<<<< \n");
        membershipDAO.addSomethingStrange();

        context.close();
    }
}
