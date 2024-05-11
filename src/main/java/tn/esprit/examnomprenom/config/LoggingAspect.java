package tn.esprit.examnomprenom.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @After("execution(* tn.esprit.examnomprenom.services.*.get*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Bon courage!");
    }
}
