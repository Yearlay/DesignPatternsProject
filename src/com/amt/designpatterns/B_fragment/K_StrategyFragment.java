package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.Z_utils.AppLog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class K_StrategyFragment extends Z_BaseFragment {
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.builder, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Strategy: look at the BaseFragment, and child-Fragments");
        AppLog.e("Strategy", " ----- StrategyFragment   initView");
        
        return rootView;
    }

    @Override
    protected void refreshView() {
        AppLog.e("Strategy", " ----- StrategyFragment   refreshView");
    }

    @Override
    protected void initData() {
        AppLog.e("Strategy", " ----- StrategyFragment   initData");
    }

    @Override
    protected void clearData() {
        AppLog.e("Strategy", " ----- StrategyFragment   clearData");
    }

    @Override
    protected void clickWidget(View view) {
        AppLog.e("Strategy", " ----- StrategyFragment   initData");
    }

}
