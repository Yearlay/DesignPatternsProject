package com.amt.designpatterns.G_command;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Memble {
    private String mName;
    
    private String mAbility;
    
    private boolean mIsReady;
    
    private boolean mIsRelease = false;
    
    public boolean isReady() {
        return mIsReady;
    }
    
    public boolean isRelease() {
        return mIsRelease;
    }
    
    public void setReleaseState(boolean isRelease) {
        mIsRelease = isRelease;
    }

    public Memble() {
        
    }
    
    public Memble(String name, boolean isReady, String ability) {
        mName = name;
        mIsReady = isReady;
        mAbility = ability;
    }
    
    public void action(Context context, LinearLayout showLayout) {
        String text = new String(mName + " --> Ability: " + mAbility);
        TextView textView = new TextView(context);
        textView.setText(text);
        showLayout.addView(textView);
    }
}
