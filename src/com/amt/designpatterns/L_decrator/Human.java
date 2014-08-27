package com.amt.designpatterns.L_decrator;

public class Human extends Primates {

    public Human(Animal decratorAnimal) {
        super(decratorAnimal);
        this.property = "wisdom";
    }

}
