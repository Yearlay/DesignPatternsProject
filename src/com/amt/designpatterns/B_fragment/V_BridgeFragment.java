package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.H_memble.ProductManagerChain;
import com.amt.designpatterns.H_memble.ProductManagerJob;
import com.amt.designpatterns.H_memble.ProjectManagerChain;
import com.amt.designpatterns.H_memble.ProjectManagerJob;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class V_BridgeFragment extends Z_BaseFragment {
    
    private LinearLayout mLayout;
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.builder, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Bridge:");
        
        mLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);
        
        ProductManagerChain productManager = new ProductManagerChain(null);
        ProjectManagerChain projectManager = new ProjectManagerChain(null);
        
        productManager.setmJobImpl(new ProductManagerJob("create the product!"));
        projectManager.setmJobImpl(new ProjectManagerJob("create the team of developer"));
        
        TextView text1 = new TextView(getActivity());
        text1.setText("Product Manager job:" + productManager.getmJobImpl().getjob());
        mLayout.addView(text1);
        
        TextView text2 = new TextView(getActivity());
        text2.setText("Project Manager job:" + projectManager.getmJobImpl().getjob());
        mLayout.addView(text2);
        
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
