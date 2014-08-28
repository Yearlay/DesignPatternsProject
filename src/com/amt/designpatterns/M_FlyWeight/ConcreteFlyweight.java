package com.amt.designpatterns.M_FlyWeight;

public class ConcreteFlyweight extends Flyweight {
    private String string;

    public ConcreteFlyweight(String str) {
        string = str;
    }

    public Object operation() {
        return ("Concrete---Flyweight : " + string);
    }

}
