package com.amt.designpatterns.E_view;

import android.content.Context;
import android.widget.TextView;

public abstract class StyleTextView extends TextView {

    public StyleTextView(Context context) {
        super(context);
        setDefaultStyle();
    }
    
    protected abstract void setDefaultStyle();

}
