package org.nicholas.aop;

import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component("libraryBean")
public class Library {
    public String getBook(String name){
        System.out.println("Мы берем книгу " + name);
//        if (Math.round(Math.random()*100)%2==0)
//            throw new IllegalStateException("AAAAA");
        return name;
    }
}
