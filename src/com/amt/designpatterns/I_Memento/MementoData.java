package com.amt.designpatterns.I_Memento;

public class MementoData {
    public String showStr;
    public int index;
    
    public MementoData(String str, int i) {
        showStr = str;
        index = i;
    }

    @Override
    public String toString() {
        return "show String : " + showStr + " && index : " + index;
    }
    
    
}
