package com.amt.designpatterns.F_factory;

import com.amt.designpatterns.E_view.StyleButton;

public abstract class ButtonBuilder {
    public static final boolean NEED_TO_BUILD = true;
    
    public abstract ButtonBuilder setStyle(int color, String text);
    public abstract StyleButton create();
}
