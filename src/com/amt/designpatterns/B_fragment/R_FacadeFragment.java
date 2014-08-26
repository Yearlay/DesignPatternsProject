package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.H_memble.ProjectFacade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class R_FacadeFragment extends Z_BaseFragment {
    
    private LinearLayout mShowLayout;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.command, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Facade: use ProjectFacade to notify order.");
        Button mBuildTeamButton = (Button) rootView.findViewById(R.id.order_buttom);
        mBuildTeamButton.setOnClickListener(this);
        
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout_order);
        
        ((Button) rootView.findViewById(R.id.build_team)).setVisibility(View.GONE);
        ((LinearLayout) rootView.findViewById(R.id.show_layout)).setVisibility(View.GONE);
        
        return rootView;
    }
    
    @Override
    protected void clickWidget(View view) {
        mShowLayout.removeAllViews();
        new ProjectFacade().buildTeam(getActivity(), mShowLayout).notifyOrderFromProductManager("First order: Design");
    }
    
    @Override
    protected void refreshView() {
        
    }

    @Override
    protected void initData() {
        
    }

    @Override
    protected void clearData() {
        
    }

}
