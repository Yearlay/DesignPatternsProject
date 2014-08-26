
package com.amt.designpatterns.G_command;

import java.util.ArrayList;

import android.content.Context;
import android.widget.LinearLayout;

public class PM_Invoker {
    
    private ArrayList<Transaction> mTransactionsList = new ArrayList<Transaction>();
    
    public PM_Invoker() {
    }

    public PM_Invoker buildPLTeam() {
        addTransaction((new PL_QATransaction()).buildTeam());
        addTransaction((new PL_RDTransaction()).buildTeam());
        addTransaction((new PL_UIUETransaction()).buildTeam());
        return this;
    }

    public ArrayList<Transaction> getTransactions() {
        return mTransactionsList;
    }

    public void addTransaction(final Transaction transaction) {
        mTransactionsList.add(transaction);
    }

    public void showAllMembleDetails(Context context, LinearLayout showLayout) {
        for (Transaction transaction : mTransactionsList) {
            transaction.execute(context, showLayout);
        }
    }
}
