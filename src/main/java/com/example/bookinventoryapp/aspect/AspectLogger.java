package com.example.bookinventoryapp.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectLogger {

    private static final Logger logger = LoggerFactory.getLogger(AspectLogger.class);
    @Pointcut("execution(* com.example.bookinventoryapp.service.BookService.*(..))")
    public void servicePointCut(){}
    @Pointcut("execution(* com.example.bookinventoryapp.controller.BookController.*(..))")
    public void controllerPointCut(){}

    @Before("servicePointCut()")
    public void logBeforeService(JoinPoint joinPoint){
        logger.info("Service started with");
        logger.info("signature Name : {} "+joinPoint.getSignature().getName());
        logger.info("parameters : {} "+joinPoint.getArgs());
    }

    @After("servicePointCut()")
    public void logAfterService(JoinPoint joinPoint){
        System.out.println("Requested service completed successfully");
    }

    @AfterThrowing("servicePointCut()")
    public void logAfterThrowingServiceException(JoinPoint joinPoint){
        logger.error("Exception occured in executing service");
        logger.error("Service Name : {} "+joinPoint.getSignature().getName());
        logger.error("with Parameters : {} "+joinPoint.getArgs());
        System.out.println("Check with the constraints on arguments");
    }

    @Before("controllerPointCut()")
    public void logBeforeController(JoinPoint joinPoint){
        logger.info("Controller started with");
        logger.info("signature Name : {} "+joinPoint.getSignature().getName());
        logger.info("parameters : {} "+joinPoint.getArgs());
    }

    @After("controllerPointCut()")
    public void logAfterController(JoinPoint joinPoint){
        System.out.println("Requested controller path returned successfully");
    }

    @AfterThrowing("controllerPointCut()")
    public void logAfterThrowingControllerException(JoinPoint joinPoint){
        logger.error("Exception occured in executing controller");
        logger.error("Controller Name : {} "+joinPoint.getSignature().getName());
        logger.error("with Parameters : {} "+joinPoint.getArgs());
        System.out.println("Check with the path or url of controller,HTTP methods associated with the path or constraints on arguments");
    }












}
