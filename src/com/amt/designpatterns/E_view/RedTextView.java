package com.amt.designpatterns.E_view;

import android.content.Context;
import android.graphics.Color;

public class RedTextView extends StyleTextView {

    public RedTextView(Context context) {
        super(context);
    }

    @Override
    protected void setDefaultStyle() {
        this.setTextColor(Color.RED);
        setText("Default Red TextView!");
    }

}
