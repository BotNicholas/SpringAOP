package org.nicholas.aop;

import org.nicholas.aop.aspects.LoggingAspect;
import org.nicholas.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Library library = context.getBean("libraryBean", Library.class);

        System.out.println(library.getBook("Crime and punishment"));

        Something something = context.getBean("something", Something.class);

        something.getBook();





        Library library1 = new Library();

        library1.getBook("AAAAAA");

        context.close();
    }
}
