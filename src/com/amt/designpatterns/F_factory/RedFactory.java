package com.amt.designpatterns.F_factory;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amt.designpatterns.E_view.RedButton;
import com.amt.designpatterns.E_view.RedTextView;
import com.amt.designpatterns.E_view.StyleButton;
import com.amt.designpatterns.E_view.StyleTextView;

public class RedFactory extends StyleFactory {

    @Override
    public StyleButton createStyleButton(Context context) {
        return (new RedButton(context)).clone(context);
    }

    @Override
    public StyleTextView createStyleTextView(Context context) {
        return new RedTextView(context);
    }

    @Override
    public void addView(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("This is Red style.");
        layout.addView(textView);
        
        layout.addView(new StyleButtonBuilder(context).setStyle(Color.RED, "Red Button").create());
    }

}
