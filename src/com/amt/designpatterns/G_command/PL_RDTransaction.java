package com.amt.designpatterns.G_command;

import android.content.Context;
import android.widget.LinearLayout;

public class PL_RDTransaction extends Transaction {
    
    public PL_RDTransaction() {
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
        validateToAddMemble(new Memble("gewei", true, "the PL of RD"));
        validateToAddMemble(new Memble("zhangfei", true, "the engineer of DB"));
        validateToAddMemble(new Memble("wanghao", true, "the engineer of SDK"));
        validateToAddMemble(new Memble("guogansheng", false, "the engineer of manage, off-line."));
        return this;
    }

}
