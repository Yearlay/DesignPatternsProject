package com.amt.designpatterns.E_view;

import android.content.Context;
import android.graphics.Color;

public class BlueTextView extends StyleTextView {

    public BlueTextView(Context context) {
        super(context);
    }

    @Override
    protected void setDefaultStyle() {
        setTextColor(Color.BLUE);
        setText("Default Blue TextView!");
        setSingleLine();
    }

}
