package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.H_memble.AssistantMediator;
import com.amt.designpatterns.H_memble.CustomerChain;
import com.amt.designpatterns.H_memble.MembleChain;
import com.amt.designpatterns.H_memble.ProductManagerChain;
import com.amt.designpatterns.H_memble.Project;
import com.amt.designpatterns.H_memble.ProjectManagerChain;
import com.amt.designpatterns.H_memble.QAChain;
import com.amt.designpatterns.H_memble.RDChain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class M_MediatorFragment extends Z_BaseFragment {
    
    private LinearLayout mShowLayout;
    
    private Project mProject;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.command, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Mediator: use the assistant notify order.");
        Button mBuildTeamButton = (Button) rootView.findViewById(R.id.order_buttom);
        mBuildTeamButton.setOnClickListener(this);
        
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout_order);
        
        ((Button) rootView.findViewById(R.id.build_team)).setVisibility(View.GONE);
        ((LinearLayout) rootView.findViewById(R.id.show_layout)).setVisibility(View.GONE);
        
        initTeam();
        
        return rootView;
    }
    
    public void initTeam() {
        mProject = new Project();
        
        AssistantMediator assistant = new AssistantMediator();
        ProductManagerChain mProductManagerChain = new ProductManagerChain(assistant);
        ProjectManagerChain mProjectManagerChain = new ProjectManagerChain(assistant);
        RDChain mRdChain = new RDChain(assistant);
        QAChain mQaChain = new QAChain(assistant);
        CustomerChain mCustomerChain = new CustomerChain(assistant);
        
        assistant.setContext(getActivity());
        assistant.setLayout(mShowLayout);
        assistant.setProject(mProject);
        assistant.setProductManager(mProductManagerChain);
        assistant.setProjectManager(mProjectManagerChain);
        assistant.setRD(mRdChain);
        assistant.setQA(mQaChain);
        assistant.setCustomer(mCustomerChain);
        
        mProject.setRootChain(mProductManagerChain);
        
        // init Chain
        mProductManagerChain.setNextChain(mProjectManagerChain);
        mProjectManagerChain.setNextChain(mRdChain);
        mRdChain.setNextChain(mQaChain);
        mQaChain.setNextChain(mCustomerChain);
    }
    
    @Override
    protected void clickWidget(View view) {
        mShowLayout.removeAllViews();
        MembleChain rootChain = mProject.getRootChain();
        if (rootChain instanceof ProductManagerChain) {
            ((ProductManagerChain) rootChain).notifyOrder("require overtime!");
        }
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
