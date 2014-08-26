package com.amt.designpatterns.E_view;

import android.content.Context;
import android.graphics.Color;

public class BlueButton extends StyleButton {

    public BlueButton(Context context) {
        super(context);
    }

    @Override
    protected StyleButton setDefaultStyle() {
        setTextColor(Color.BLUE);
        setText("Default Blue-Button!");
        return this;
    }

}
