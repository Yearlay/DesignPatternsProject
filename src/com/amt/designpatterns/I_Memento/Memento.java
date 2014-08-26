
package com.amt.designpatterns.I_Memento;

public class Memento {
    
    private MementoData mementoData;
    
    public Memento(MementoData mementoData) {
        this.mementoData = mementoData;
    }
    
    public MementoData getData() {
        return mementoData;
    }
    
    public void setData(MementoData mementoData) {
        this.mementoData = mementoData;
    }
}
