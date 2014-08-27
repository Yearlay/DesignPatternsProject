package com.amt.designpatterns.L_decrator;

public class Animal {
    public String property;
    
    public Animal mDecratorAnimal;
    
    public Animal(Animal decratorAnimal) {
        mDecratorAnimal = decratorAnimal;
        property = "alive";
    }
    
    public String getProperty() {
        if (mDecratorAnimal != null) {
            property = property + " && " + mDecratorAnimal.getProperty();
        }
        return property;
    }
}
