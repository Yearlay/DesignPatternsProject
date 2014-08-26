package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.H_memble.AssistantMediator;
import com.amt.designpatterns.H_memble.CustomerChain;
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

public class Q_CompositeFragment extends Z_BaseFragment {
    
    private LinearLayout mShowLayout;
    
    private ProductManagerChain mProductManagerChain;
    
    private ProjectManagerChain mProjectManagerChain;
    private RDChain mRdChain;
    private QAChain mQaChain;
    private CustomerChain mCustomerChain;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.command, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Composite: notify order.");
        Button mBuildTeamButton = (Button) rootView.findViewById(R.id.order_buttom);
        mBuildTeamButton.setOnClickListener(this);
        
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout_order);
        
        ((Button) rootView.findViewById(R.id.build_team)).setVisibility(View.GONE);
        ((LinearLayout) rootView.findViewById(R.id.show_layout)).setVisibility(View.GONE);
        
        initTeam();
        
        return rootView;
    }
    
    public void initTeam() {
        
        AssistantMediator assistant = new AssistantMediator();
        mProductManagerChain = new ProductManagerChain(assistant);
        mProjectManagerChain = new ProjectManagerChain(assistant);
        mRdChain = new RDChain(assistant);
        mQaChain = new QAChain(assistant);
        mCustomerChain = new CustomerChain(assistant);
        
        Project mProject = new Project();
        
        assistant.setContext(getActivity());
        assistant.setProject(mProject);
        assistant.setLayout(mShowLayout);
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
        mProductManagerChain.notifyOrder("require overtime!");
        
        TextView textview = new TextView(getActivity());
        textview.setText("---------------Composite-------");
        mShowLayout.addView(textview);
        
        /** Composite */
        mProductManagerChain.add(mProjectManagerChain);
        mProductManagerChain.add(mRdChain);
        mProductManagerChain.add(mQaChain);
        mProductManagerChain.add(mCustomerChain);
        
        mProductManagerChain.executeOrder(getActivity(), mShowLayout);
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
