package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.F_factory.StyleButtonBuilder;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class D_BuilderFragment extends Z_BaseFragment {
    
    private LinearLayout mShowLayout;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.builder, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Prototype:");
        
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);
        
        mShowLayout.addView(new StyleButtonBuilder(getActivity()).setStyle(Color.RED, "Builder One").create());
        mShowLayout.addView(new StyleButtonBuilder(getActivity()).setStyle(Color.BLUE, "Builder Two").create());
        mShowLayout.addView(new StyleButtonBuilder(getActivity()).setStyle(Color.GREEN, "Builder Three").create());
        mShowLayout.addView(new StyleButtonBuilder(getActivity()).setStyle(Color.YELLOW, "Builder Four").create());
        mShowLayout.addView(new StyleButtonBuilder(getActivity()).setStyle(Color.GRAY, "Builder Five").create());
        
        return rootView;
    }

    @Override
    protected void refreshView() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void initData() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void clearData() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void clickWidget(View view) {}

}
