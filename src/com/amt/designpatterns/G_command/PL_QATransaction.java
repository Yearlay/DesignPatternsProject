package com.amt.designpatterns.G_command;

import android.content.Context;
import android.widget.LinearLayout;

public class PL_QATransaction extends Transaction {
    
    public PL_QATransaction() {
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
        validateToAddMemble(new Memble("xujie", true, "the PL of QA"));
        validateToAddMemble(new Memble("fumengying", true, "the engineer of QA-team"));
        validateToAddMemble(new Memble("chenxiaopei", false, "the back-engineer of QA-team"));
        return this;
    }
}
