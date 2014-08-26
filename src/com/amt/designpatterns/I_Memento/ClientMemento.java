package com.amt.designpatterns.I_Memento;

import com.amt.designpatterns.Z_utils.AppLog;

public class ClientMemento {
    public void main() {
        Orignation orignation = new Orignation();
        
        // init data
        orignation.setData(new MementoData("111111111111111", 1));
        AppLog.e("Memento", "orignation state : " + orignation.getData());
        
        Caretaker caretaker = new Caretaker();
        // use caretaker to save data.
        caretaker.saveMementoToList(orignation.createMemento());
        
        // change data;
        orignation.setData(new MementoData("222222222222222", 2));
        
        // restore data;
        Memento memento;
        do {
            memento = caretaker.retrieveMementoFromList();
            if (memento != null) {
                orignation.restoreMemento(memento);
            }
        } while (memento != null);
        AppLog.e("Memento", "orignation state : " + orignation.getData());
    }
}
