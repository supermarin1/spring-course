package com.syrovets.demo.aspect;

import com.syrovets.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Order(1) //define order of loading aspects (negative number are allowed)
@Component
public class LoggingAspect {

    /**
     * Advice types:
     *
     * @Before run before the method
     * @AfterReturning run after the method (success execution)
     * @AfterThrowing run after method (if exception thrown)
     * @After run after the method (finally) - always run no matter success or failed
     * @Around run before and after method (you can swallow/handle/stop exception)
     */

    @Pointcut("execution(* com.syrovets.demo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* com.syrovets.demo.dao.*.get*(..))")
    private void forDaoPackageGetter() {
    }

    @Pointcut("!(execution(* com.syrovets.demo.dao.*.set*(..)) && forDaoPackageGetter())")
    private void forDaoPackageExcludeSetterAndGetter() {
    }

    //match any 'addAccount()' in any class
    //@Before("execution(public void addAccount())")

//    match only 'addAccount' method in AccountDao class
//    @Before("execution(public void com.syrovets.demo.dao.AccountDao.addAccount())")

//    match ANY method strarts with 'add'
//    @Before("execution(public void add*())")

//    match ANY access modifier methos starts with 'add'
//    @Before("execution(void add*())")

//    match any number of arguments with Account first
//    @Before("execution(* add*(com.syrovets.demo.Account, ..))")

    //    match any RETURN type, any PACKAGE/CLASS/METHOD NAME, any PARAMS (from zero)
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice");
    }

    // display information about method
    @Before("forDaoPackage()")
    public void getParameters(JoinPoint joinPoint) {
        System.out.println("\n=====>>> method:" + joinPoint.getSignature());
        System.out.println("\n=====>>> parameters:" + Arrays.toString(joinPoint.getArgs()));
    }

    //after the method returns the successful execution
    @AfterReturning(value = "forDaoPackage()", returning = "result")
    public void afterReturningAccountAdvice(List<Account> result) {
        System.out.println("\n=====>>> Executing @AfterReturning advice. The result size is " + result.size());
        result.add(new Account("duck", "0")); //modify the result
    }

    @AfterThrowing(value = "forDaoPackage()", throwing = "exception")
    public void afterTrowingAccountAdvice(Throwable exception) {
        System.out.println("\n=====>>> Executing @AfterThrowing advice. The exeption is " + exception.getMessage());
    }

    @After(value = "forDaoPackage()")
    public void afterAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @After advice." + joinPoint.getSignature().getName());
    }

    @Around(value = "forDaoPackage()")
    public void aroundAccountAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        long begin = System.currentTimeMillis();

        joinPoint.proceed();
        System.out.println("\n>>>>=====>>> Executing @Around advice." + joinPoint.getSignature().getName());

        System.out.println("Duration: " + (begin - System.currentTimeMillis()));
    }
}
