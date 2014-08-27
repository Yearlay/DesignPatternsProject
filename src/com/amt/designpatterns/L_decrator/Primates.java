package com.amt.designpatterns.L_decrator;

public class Primates extends Animal {

    public Primates(Animal decratorAnimal) {
        super(decratorAnimal);
        this.property = "can running";
    }

}
