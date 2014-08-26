package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.H_memble.AssistantMediator;
import com.amt.designpatterns.H_memble.CustomerChain;
import com.amt.designpatterns.H_memble.Mediator;
import com.amt.designpatterns.H_memble.ProductManagerChain;
import com.amt.designpatterns.H_memble.ProjectManagerChain;
import com.amt.designpatterns.H_memble.QAChain;
import com.amt.designpatterns.H_memble.RDChain;
import com.amt.designpatterns.H_memble.SimpleVisitor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class N_VisitorFragment extends Z_BaseFragment {
    
    private LinearLayout mShowLayout;
    
    private ProductManagerChain mProductManagerChain;
    private ProjectManagerChain mProjectManagerChain;
    private RDChain mRdChain;
    private QAChain mQaChain;
    private CustomerChain mCustomerChain;
    
    private SimpleVisitor mSimpleVisitor;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.command, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Visitor: simple visitor to get the Responsibility.");
        Button mBuildTeamButton = (Button) rootView.findViewById(R.id.build_team);
        mBuildTeamButton.setOnClickListener(this);
        mBuildTeamButton.setText("get the Responsibility");
        
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);
        
        ((Button) rootView.findViewById(R.id.order_buttom)).setVisibility(View.GONE);
        ((LinearLayout) rootView.findViewById(R.id.show_layout_order)).setVisibility(View.GONE);
        
        initTeam();
        
        return rootView;
    }
    
    public void initTeam() {
        Mediator assistant = new AssistantMediator();
        mProductManagerChain = new ProductManagerChain(assistant);
        mProjectManagerChain = new ProjectManagerChain(assistant);
        mRdChain = new RDChain(assistant);
        mQaChain = new QAChain(assistant);
        mCustomerChain = new CustomerChain(assistant);
        
        // init Chain
        mProductManagerChain.setNextChain(mProjectManagerChain);
        mProjectManagerChain.setNextChain(mRdChain);
        mRdChain.setNextChain(mQaChain);
        mQaChain.setNextChain(mCustomerChain);
        
        mSimpleVisitor = new SimpleVisitor();
    }
    
    @Override
    protected void clickWidget(View view) {
        mShowLayout.removeAllViews();
        
        mSimpleVisitor.clearVisitorMessage();
        mProductManagerChain.acceptVisitor(mSimpleVisitor);
        mProjectManagerChain.acceptVisitor(mSimpleVisitor);
        mRdChain.acceptVisitor(mSimpleVisitor);
        mQaChain.acceptVisitor(mSimpleVisitor);
        mCustomerChain.acceptVisitor(mSimpleVisitor);
        
        for(String message : mSimpleVisitor.getVisitorMessage()){
            TextView textView = new TextView(getActivity());
            textView.setText(message);
            mShowLayout.addView(textView);
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
