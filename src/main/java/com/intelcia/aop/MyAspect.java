package com.intelcia.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Administrateur on 12/03/2015.
 */
@Aspect
@Component
public class MyAspect {

//    @PersistenceContext
//    EntityManager myEmf;
//    @Before("execution(* printName(..))")
//    private void advice() {
//
//    }

//    @AfterReturning(pointcut="execution(* com.intelcia.aop.CustomerService.getUrl()))",returning="retVal")
//    public void afterReturn(Object retVal) {
//        System.out.println("methode returned :" +retVal);
//    }


//    @Around("execution(* com.intelcia.aop.*.*(..))")
//    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        System.out.println("Going to call the method.");
//        Object output = pjp.proceed();
//        System.out.println("Method execution completed.");
//        long elapsedTime = System.currentTimeMillis() - start;
//        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
//        return output;
//    }

    @Around(value = "@annotation(secured)")
    public Object isSecured(ProceedingJoinPoint pjp, final Secured secured) {

        if (!secured.role().equals("user")) {
            try {
                return pjp.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            System.out.println("not allowed");
            return null;
        }
        return null;

    }


    @Around(value = "@annotation(ann)")
    public Object transaction(ProceedingJoinPoint pjp, final Transactionnal ann) throws Throwable {
//        if(!myEmf.getTransaction().isActive())
//            myEmf.getTransaction().begin();
//        myEmf.clear();
        Object o;
        System.out.println("begin the transtaction");
        try {
            System.out.println("exec the transaction");
             o = pjp.proceed();

        } catch (IllegalArgumentException throwable) {
//            myEmf.getTransaction().rollback();
            System.out.println("erreur: rooling back");
            return null;
        }
        System.out.println("done, commiting");
//        myEmf.getTransaction().commit();
        return o;
    }
}
