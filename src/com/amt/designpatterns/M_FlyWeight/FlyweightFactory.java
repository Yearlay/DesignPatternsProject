package com.amt.designpatterns.M_FlyWeight;

import java.util.Hashtable;

public class FlyweightFactory {
    private Hashtable<Object, Flyweight> flyweights = new Hashtable<Object, Flyweight>();

    public FlyweightFactory() {
    }

    public Flyweight getFlyWeight(Object obj) {
        Flyweight flyweight = (Flyweight) flyweights.get(obj);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight((String) obj);
            flyweights.put(obj, flyweight);
        }
        return flyweight;

    }

    public int getFlyweightSize() {
        return flyweights.size();
    }

}
