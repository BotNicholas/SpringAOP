package org.nicholas;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        List <B> list1 = a.getList();
        List <B> list2 = a.getList();

        list1.get(0).n=100;

        System.out.println(list1.get(0).n);
        System.out.println(list2.get(0).n); //the same, because List stores pointers to memory cells. When we obtain
        // this object and change its value, It will change in memory...
//
//        list2.forEach(b -> System.out.println(b.n));
    }
}