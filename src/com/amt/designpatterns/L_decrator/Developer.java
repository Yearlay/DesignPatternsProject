package com.amt.designpatterns.L_decrator;

public class Developer extends Human {

    public Developer(Animal decratorAnimal) {
        super(decratorAnimal);
        this.property = "understand DesignPatterns";
    }

}
