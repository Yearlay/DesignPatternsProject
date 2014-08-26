package com.amt.designpatterns.I_Memento;

import java.util.ArrayList;

public class Caretaker {
    private Memento memento;
    
    public Memento retrieveMemento() {
        return memento;
    }
    
    public void saveMemento(Memento memento) {
        this.memento = memento;
    }
    
    private ArrayList<Memento> mMementoList = new ArrayList<Memento>();
    
    public Memento retrieveMementoFromList() {
        if (mMementoList.size() > 0) {
            memento = mMementoList.remove(mMementoList.size() - 1);
        } else {
            memento = null;
        }
        return memento;
    }
    
    public void saveMementoToList(Memento memento) {
        this.memento = memento;
        mMementoList.add(memento);
    }
    
    public Memento getTheTopMemento() {
        if (mMementoList.size() > 0) {
            return mMementoList.get(mMementoList.size() - 1);
        }
        return null;
    }
}
