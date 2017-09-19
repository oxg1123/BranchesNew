package com.oxg.branch.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.stereotype.Component;

import com.oxg.branch.documents.Branch;

@Aspect
@Component
public class Logger extends AbstractMongoEventListener<Branch> {

	   /** Handle to the log file */
    private final Log log = LogFactory.getLog(getClass());

    public Logger () {}

    @AfterReturning("execution(* com.oxg.branch..*.*(..))")
    public void logMethodAccessAfter(JoinPoint joinPoint) {
        log.info("***** Completed: " + joinPoint.getSignature().getName() + " *****");
        System.out.println("***** Completed: " + joinPoint.getSignature().getName() + " *****");
    }

    @Before("execution(* com.oxg.branch..*.*(..))")
    public void logMethodAccessBefore(JoinPoint joinPoint) {
        log.info("***** Starting: " + joinPoint.getSignature().getName() + " *****");
        joinPoint.getArgs();
        System.out.println("***** Starting: " + joinPoint.getSignature().getName() + " *****");
    }
}
