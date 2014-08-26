package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.H_memble.AssistantMediator;
import com.amt.designpatterns.H_memble.CustomerChain;
import com.amt.designpatterns.H_memble.Mediator;
import com.amt.designpatterns.H_memble.MembleChain;
import com.amt.designpatterns.H_memble.ProductManagerChain;
import com.amt.designpatterns.H_memble.Project;
import com.amt.designpatterns.H_memble.ProjectManagerChain;
import com.amt.designpatterns.H_memble.QAChain;
import com.amt.designpatterns.H_memble.RDChain;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class L_ChainOfResponsibilityFragment extends Z_BaseFragment {
    
    private LinearLayout mShowLayout;
    
    private Project mProject;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.command, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Chain of Responsibility: ask responsibility");
        Button mBuildTeamButton = (Button) rootView.findViewById(R.id.build_team);
        mBuildTeamButton.setOnClickListener(this);
        mBuildTeamButton.setText("Ask Responsibility");
        
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);
        
        ((Button) rootView.findViewById(R.id.order_buttom)).setVisibility(View.GONE);
        ((LinearLayout) rootView.findViewById(R.id.show_layout_order)).setVisibility(View.GONE);
        
        initTeam();
        
        return rootView;
    }
    
    public void initTeam() {
        mProject = new Project();
        
        Mediator assistant = new AssistantMediator();
        ProductManagerChain mProductManagerChain = new ProductManagerChain(assistant);
        ProjectManagerChain mProjectManagerChain = new ProjectManagerChain(assistant);
        RDChain mRdChain = new RDChain(assistant);
        QAChain mQaChain = new QAChain(assistant);
        CustomerChain mCustomerChain = new CustomerChain(assistant);
        
        mProject.setRootChain(mProductManagerChain);
        
        // init Chain
        mProductManagerChain.setNextChain(mProjectManagerChain);
        mProjectManagerChain.setNextChain(mRdChain);
        mRdChain.setNextChain(mQaChain);
        mQaChain.setNextChain(mCustomerChain);
    }
    
    public void askResponsibility(Context context, LinearLayout layout) {
        if (mProject != null) {
            mProject.getRootChain().askResponsibility(context, layout, MembleChain.INIT_PROJECT);
            mProject.getRootChain().askResponsibility(context, layout, MembleChain.BUILD_TEAM);
            mProject.getRootChain().askResponsibility(context, layout, MembleChain.DESIGN_CODE);
            mProject.getRootChain().askResponsibility(context, layout, MembleChain.TEST_REPORT);
            mProject.getRootChain().askResponsibility(context, layout, MembleChain.OVER_PROJECT);
        }
    }
    
    @Override
    protected void clickWidget(View view) {
        mShowLayout.removeAllViews();
        askResponsibility(getActivity(), mShowLayout);
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
