package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class V_BridgeFragment extends Z_BaseFragment {
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.builder, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Bridge: TODO.");
        
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
