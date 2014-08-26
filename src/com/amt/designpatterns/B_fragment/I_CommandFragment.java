package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.G_command.PM_Invoker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class I_CommandFragment extends Z_BaseFragment {
    
    private LinearLayout mShowLayout;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.command, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Command: Building team of CMCC");
        Button mBuildTeamButton = (Button) rootView.findViewById(R.id.build_team);
        mBuildTeamButton.setOnClickListener(this);
        
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);
        
        ((Button) rootView.findViewById(R.id.order_buttom)).setVisibility(View.INVISIBLE);
        ((LinearLayout) rootView.findViewById(R.id.show_layout_order)).setVisibility(View.INVISIBLE);
        
        return rootView;
    }
    
    @Override
    protected void clickWidget(View view) {
        mShowLayout.removeAllViews();
        teamBuilding();
    }
    
    /**
     * Assemble the commands. <br>
     * And run the commands.
     */
    public void teamBuilding() {
        new PM_Invoker().buildPLTeam().showAllMembleDetails(this.getActivity(), mShowLayout);
    }
    
    public void teamWorking() {
        
    }
    
    public void teamRelease() {
        
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

}
