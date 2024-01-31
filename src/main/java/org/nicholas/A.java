package org.nicholas;

import java.util.ArrayList;
import java.util.List;

public class A {
    public List<B> numbers = new ArrayList<>();

    public List<B> getList(){
        numbers.add(new B(1));
        numbers.add(new B(2));
        numbers.add(new B(3));
        return numbers;
    }
}
