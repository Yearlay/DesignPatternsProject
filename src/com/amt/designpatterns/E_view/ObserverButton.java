package com.amt.designpatterns.E_view;

import com.amt.designpatterns.Y_data.ShowStyle;

import android.content.Context;
import android.graphics.Color;

public class ObserverButton extends StyleButton {
    
    private boolean mIsObserver;

    public boolean isObserver() {
        return mIsObserver;
    }

    public void setObserver(boolean isObserver) {
        mIsObserver = isObserver;
        setText(mIsObserver ? "Observer Register" : "Observer Un-register");
        if (!mIsObserver) {
            setTextColor(Color.BLACK);
        }
    }

    public ObserverButton(Context context) {
        super(context);
        setDefaultStyle();
    }

    @Override
    protected StyleButton setDefaultStyle() {
        setTextColor(Color.BLACK);
        setText("Observer Un-register");
        return this;
    }
    
    public void updateStyle(ShowStyle showStyle) {
        if (!mIsObserver) {
            return;
        }
        if (ShowStyle.RED == showStyle) {
            setTextColor(Color.RED);
        } else if (ShowStyle.BLUE == showStyle) {
            setTextColor(Color.BLUE);
        }
    }

}
