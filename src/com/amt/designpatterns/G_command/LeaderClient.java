package com.amt.designpatterns.G_command;

import android.content.Context;
import android.widget.LinearLayout;

public class LeaderClient {
    
    /**
     * Assemble the commands. <br>
     * And run the commands.
     */
    public void teamBuilding(Context context, LinearLayout showLayout) {
        new PM_Invoker().buildPLTeam().showAllMembleDetails(context, showLayout);
    }
    
    public void teamWorking() {
        
    }
    
    public void teamRelease() {
        
    }

}
