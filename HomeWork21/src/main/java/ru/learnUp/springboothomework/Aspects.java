package ru.learnUp.springboothomework;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Aspects {

    private static final Logger log = LoggerFactory.getLogger(SpringBootHomeWorkApplication.class);

    @AfterReturning(pointcut = "@annotation(ru.learnUp.springboothomework.logAnnotation.LogMethod)",returning = "result")
    public void logMethod(JoinPoint joinPoint, Object result) {
        log.info("LogMethod! MethodName: {}", joinPoint.getSignature().getName());
        log.info("Return: {}", result);
        log.info("Args:", joinPoint.getSignature().getName(), result);

        Object[] args = joinPoint.getArgs();
        if (args.length == 0) {
            log.info("this function hus no args");
        } else {
            for (Object arg : args) {
                log.info((String) arg );
            }
        }
    }

    @Around("@annotation(ru.learnUp.springboothomework.logAnnotation.WorkTime)")
    public void workTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long m = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        double worktime = (double) (System.currentTimeMillis() - m);
        log.info("WorkTime! MethodName: {}; worktime: {}",proceedingJoinPoint.getSignature().getName(), worktime);
    }
}
