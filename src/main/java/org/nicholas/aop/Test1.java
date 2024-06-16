package org.nicholas.aop;

import org.nicholas.aop.aspects.LoggingAspect;
import org.nicholas.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Library library = context.getBean("libraryBean", Library.class);

        System.out.println("\n" + library.getBook("Book got: Crime and punishment"));

        context.close();
    }
}
