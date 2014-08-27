package com.amt.designpatterns.L_decrator;

public class PManager extends Developer {

    public PManager(Animal decratorAnimal) {
        super(decratorAnimal);
        this.property = "Project manager";
    }

}
