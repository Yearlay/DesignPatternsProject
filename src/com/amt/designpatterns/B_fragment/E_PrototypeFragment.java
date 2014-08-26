package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.E_view.RedButton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class E_PrototypeFragment extends Z_BaseFragment {
    
    private LinearLayout mShowLayout;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.builder, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Prototype:");
        
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);
        
        RedButton redButton = new RedButton(getActivity());
        mShowLayout.addView(redButton);
        
        RedButton cloneButton = redButton.clone(getActivity());
        cloneButton.setText("Clone From redButton");
        mShowLayout.addView(cloneButton);
        
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
