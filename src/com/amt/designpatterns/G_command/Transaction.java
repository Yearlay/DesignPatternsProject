package com.amt.designpatterns.G_command;

import java.util.ArrayList;

import android.content.Context;
import android.widget.LinearLayout;

public abstract class Transaction {
    
    ArrayList<Memble> mMemblesList = new ArrayList<Memble>();
    
    public abstract Transaction buildTeam();
    
    public abstract void validateToAddMemble(Memble memble);
    
    public abstract void execute(Context context, LinearLayout showLayout);
    
    public abstract void undoToRemoveMemble(Memble memble);
}
