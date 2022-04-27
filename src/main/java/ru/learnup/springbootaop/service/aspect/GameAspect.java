package ru.learnup.springbootaop.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GameAspect {

    long startTime = 0;
    long stopTime = 0;

    private static final Logger log = LoggerFactory.getLogger(GameAspect.class);


    @Pointcut("execution(* ru.learnup.springbootaop.*.*(..))")
    public void callInGamePath(){}


    //логгируем имя метода, аргументы и возвращаемое значение
    @AfterReturning(value = "@annotation(ru.learnup.springbootaop.service.LogMethod)", returning = "returningValue")
    public void afterReturnCall(JoinPoint joinPoint, Object returningValue) throws Throwable{
        Object nameMethod = joinPoint.getSignature().getName(); //имя метода
        log.info("name method: " + nameMethod);

        Object[] argsMethod = joinPoint.getArgs();//аргументы метода
        for(Object x : argsMethod){
            log.info("arg: {}", x);
        }
        log.info("return value: " + returningValue);     //возвращаемое значение
    }

    @After("@annotation(ru.learnup.springbootaop.service.WorkTime)")
    public void afterWorkTimeCall(JoinPoint joinPoint){
        log.info("name method: " + joinPoint.getSignature().getName());
        stopTime = System.currentTimeMillis();
        System.out.println("Время работы метода " + (stopTime - startTime) + " миллисекунд");
    }

    @Before("@annotation(ru.learnup.springbootaop.service.WorkTime)")
    public void beforeWorkTimeCall(JoinPoint joinPoint){
        stopTime = System.currentTimeMillis();
    }
}
