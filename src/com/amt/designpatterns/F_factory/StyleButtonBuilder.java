package com.amt.designpatterns.F_factory;

import android.content.Context;

import com.amt.designpatterns.E_view.BlueButton;
import com.amt.designpatterns.E_view.StyleButton;

public class StyleButtonBuilder extends ButtonBuilder {
    private StyleButton mBlueButton;
    
    public StyleButtonBuilder(Context context) {
        super();
        mBlueButton = new BlueButton(context);
    }

    public ButtonBuilder setStyle(int color, String text) {
        mBlueButton.setTextColor(color);
        mBlueButton.setText(text);
        return this;
    }

    public StyleButton create() {
        return mBlueButton;
    }

}
