package com.amt.designpatterns.E_view;

import android.content.Context;
import android.widget.Button;

public abstract class StyleButton extends Button {

    public StyleButton(Context context) {
        super(context);
        setDefaultStyle();
    }
    
    protected abstract StyleButton setDefaultStyle();
}
