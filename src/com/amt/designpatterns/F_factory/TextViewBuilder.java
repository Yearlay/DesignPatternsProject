package com.amt.designpatterns.F_factory;

import com.amt.designpatterns.E_view.StyleTextView;

public abstract class TextViewBuilder {
    public static final boolean NEED_TO_BUILD = true;
    
    public abstract TextViewBuilder setStyle(int color, String text);
    public abstract StyleTextView getStyleTextView();
}
