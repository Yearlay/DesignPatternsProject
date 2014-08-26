package com.amt.designpatterns.I_Memento;

public class Orignation {
    private MementoData mementoData;
    
    public MementoData getData() {
        return mementoData;
    }
    
    public void setData(MementoData mementoData) {
        this.mementoData = mementoData;
    }
    
    public Memento createMemento() {
        return new Memento(mementoData);
    }
    
    public void restoreMemento(Memento memento) {
        mementoData = memento.getData();
    }
    
}
