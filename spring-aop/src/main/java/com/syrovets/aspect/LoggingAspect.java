package com.syrovets.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    //match any 'addAccount()' in any class
    //@Before("execution(public void addAccount())")

//    match only 'addAccount' method in AccountDao class
//    @Before("execution(public void com.syrovets.dao.AccountDao.addAccount())")

//    match ANY method strarts with 'add'
//    @Before("execution(public void add*())")

//    match ANY access modifier methos starts with 'add'
//    @Before("execution(void add*())")

//    match any number of arguments with Account first
//    @Before("execution(* add*(com.syrovets.Account, ..))")

//    match any RETURN type, any PACKAGE/CLASS/METHOD NAME, any PARAMS (from zero)
    @Before("execution(* com.syrovets.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
