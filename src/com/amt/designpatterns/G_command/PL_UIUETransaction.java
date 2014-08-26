package com.amt.designpatterns.G_command;

import android.content.Context;
import android.widget.LinearLayout;

public class PL_UIUETransaction extends Transaction {
    
    public PL_UIUETransaction() {
    }
    
    @Override
    public void validateToAddMemble(Memble memble) {
        if (memble.isReady()) {
            mMemblesList.add(memble);
        }
    }

    @Override
    public void execute(Context context, LinearLayout showLayout) {
        for (Memble memble : mMemblesList) {
            if (!memble.isRelease()) {
                memble.action(context, showLayout);
            }
        }

    }

    @Override
    public void undoToRemoveMemble(Memble memble) {
        if (memble.isReady()) {
            mMemblesList.remove(memble);
        }

    }

    @Override
    public Transaction buildTeam() {
        mMemblesList.clear();
        validateToAddMemble(new Memble("fangshu", true, "the PL of UIUE"));
        validateToAddMemble(new Memble("shudan", true, "the ui-design of QiXin"));
        return this;
    }

}
