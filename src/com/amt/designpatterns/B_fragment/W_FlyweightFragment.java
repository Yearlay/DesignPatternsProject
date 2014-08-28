package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.M_FlyWeight.Flyweight;
import com.amt.designpatterns.M_FlyWeight.FlyweightFactory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class W_FlyweightFragment extends Z_BaseFragment {
    
    Flyweight[] mFlyweights = new Flyweight[5];
    
    private LinearLayout mLayout;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.builder, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Flyweight: TODO.");
        
        mLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);
        
        FlyweightFactory factory = new FlyweightFactory();
        
        mFlyweights[0] = factory.getFlyWeight("Google");
        mFlyweights[1] = factory.getFlyWeight("Intel");
        mFlyweights[2] = factory.getFlyWeight("Google");
        mFlyweights[3] = factory.getFlyWeight("Intel");
        mFlyweights[4] = factory.getFlyWeight("Intel");
        
        for (Flyweight flyweight : mFlyweights) {
            TextView textView = new TextView(getActivity());
            textView.setText((String) flyweight.operation());
            mLayout.addView(textView);
        }
        
        TextView textView = new TextView(getActivity());
        textView.setText("object Size = " + factory.getFlyweightSize());
        mLayout.addView(textView);
        
        return rootView;
    }

    @Override
    protected void refreshView() {}

    @Override
    protected void initData() {}

    @Override
    protected void clearData() {}

    @Override
    protected void clickWidget(View view) {}

}
