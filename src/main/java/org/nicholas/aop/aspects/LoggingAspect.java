package org.nicholas.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect //Shows to spring that this is not a simple class
//Aspect is a class which contains only cross-cutting logic
public class LoggingAspect {

//    @Before("execution(public void getBook())") //in the brackets is located pointcut EXPRESSION.
    //Pointcut - говорит, где именно этот Advice должен быть выполнен. они также бывают разные (execution pointcut и др)

    //    @Before("execution(public void get*())") //метод без параметров
//    @Before("execution(public void get*())") // * - is a wildcard that accepts everything. This pointcut pattern will trigger on each getter (without parameters)
    @Before("execution(public * get*(String))") //String parameter is required
//    @Before("execution(public void get*(Book))") // Для своего класса. Так не сработает.
//    @Before("execution(public void get*(package.to.class.Book))") // Для своего класса. Так сработает.

//    @Before("execution(public void get*(*))") //метод с любым параметром
//    @Before("execution(public void get*(..))") //метод с любым числом любых параметров
    // Pointcut is an expression, that determines when the cross-cutting code should be executed, where the advice should be applied

    //Тут мы описываем шаблон. Для любого метода, который будет подходить под этот шаблон, будет вызван описанный Advice
    public void beforeGetBookAdvice() {//Advice - is a method in aspect class. It determines what exactly should happen before/after/when the method is called
        System.out.println("beforeGetBookAdvice: Попытка взять книгу");
    }

    @AfterReturning(pointcut = "execution(public * get*(String))", returning = "bookname")
    public void afterReturningGetBookAdvice(Object bookname){
//        System.out.println("\t" + bookname);
        bookname = new String("No-no-no-no"); // не сработает, так как мы пытаемся изменить значение у другой переменной
//        Создастся новая строка с новым адрсом и просто сюда поместиться, никак не изменив старую
        System.out.println("afterReturningGetBookAdvice: Взята книга");
//        System.out.println("\t" + bookname);
    }

    @AfterThrowing(pointcut = "execution(public * get*(String))")
    public void afterThrowingGetBookAdvice(){
        System.out.println("Exception thrown");
    }

    @Around("execution(public * get*(String))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundAdvice: Begin");
        System.out.println("Method " + proceedingJoinPoint.getSignature().getName() + " call");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("aroundAdvice: End");

        return object;
    }

}
//AspectJ ... Language