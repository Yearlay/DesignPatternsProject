package com.amt.designpatterns.F_factory;

import android.content.Context;

import com.amt.designpatterns.E_view.BlueTextView;
import com.amt.designpatterns.E_view.StyleTextView;

public class BlueTextViewBuilder extends TextViewBuilder {

    private StyleTextView mBlueTextView;
    
    public BlueTextViewBuilder(Context context) {
        mBlueTextView = new BlueTextView(context);
    }
    @Override
    public TextViewBuilder setStyle(int color, String text) {
        mBlueTextView.setTextColor(color);
        mBlueTextView.setText(text);;
        return this;
    }

    @Override
    public StyleTextView getStyleTextView() {
        return mBlueTextView;
    }

}
