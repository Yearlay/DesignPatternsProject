package com.amt.designpatterns.E_view;

import android.content.Context;
import android.graphics.Color;

public class RedButton extends StyleButton {
    private int mTextColor;
    private String mText;

    public RedButton(Context context) {
        super(context);
    }

    @Override
    protected StyleButton setDefaultStyle() {
        mTextColor = Color.RED;
        mText ="Default Red Button";
        setTextColor(mTextColor);
        setText(mText);
        return this;
    }
    
    /**
     * Prototype Mode
     * @param context the context.
     * @return the clone button.
     */
    public RedButton clone(Context context) {
        RedButton mCloneButton = new RedButton(context);
        mCloneButton.mText = mText + " Clone";
        mCloneButton.mTextColor = mTextColor;
        mCloneButton.setTextColor(mCloneButton.mTextColor);
        mCloneButton.setText(mCloneButton.mText);
        return mCloneButton;
    }

}
