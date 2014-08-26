package com.amt.designpatterns.F_factory;

import android.content.Context;
import android.widget.LinearLayout;

import com.amt.designpatterns.E_view.StyleButton;
import com.amt.designpatterns.E_view.StyleTextView;
import com.amt.designpatterns.Y_data.ShowStyle;

public abstract class StyleFactory {
    
    public static StyleFactory getStyleFactory(ShowStyle showStyle) {
        StyleFactory mStyleFactory = (showStyle == ShowStyle.RED) ?
                (new RedFactory()) : (new BlueFactory());
        return mStyleFactory;
    }
    
    public abstract StyleButton createStyleButton(Context context);
    public abstract StyleTextView createStyleTextView(Context context);
    public abstract void addView(Context context, LinearLayout layout);
}
