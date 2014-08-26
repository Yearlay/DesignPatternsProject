package com.amt.designpatterns.F_factory;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amt.designpatterns.E_view.BlueButton;
import com.amt.designpatterns.E_view.BlueTextView;
import com.amt.designpatterns.E_view.StyleButton;
import com.amt.designpatterns.E_view.StyleTextView;

public class BlueFactory extends StyleFactory {
    
    @Override
    public StyleButton createStyleButton(Context context) {
        StyleButton styleButton;
        if (ButtonBuilder.NEED_TO_BUILD) {
            styleButton = new StyleButtonBuilder(context)
                            .setStyle(Color.BLUE, "Build Blue-Button")
                            .create();
        } else {
            styleButton = new BlueButton(context);
        }
        return styleButton;
    }

    @Override
    public StyleTextView createStyleTextView(Context context) {
        StyleTextView styleTextView;
        if (TextViewBuilder.NEED_TO_BUILD) {
            styleTextView = new BlueTextViewBuilder(context)
                            .setStyle(Color.BLUE, "Build Blue-TextView")
                            .getStyleTextView();
        } else {
            styleTextView = new BlueTextView(context);
        }
        return styleTextView;
    }

    @Override
    public void addView(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("This is Blue style.");
        layout.addView(textView);
        
        layout.addView(new StyleButtonBuilder(context).setStyle(Color.BLUE, "Blue Button").create());
    }

}
