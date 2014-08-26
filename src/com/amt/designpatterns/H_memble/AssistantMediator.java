package com.amt.designpatterns.H_memble;

import android.content.Context;
import android.widget.LinearLayout;

public class AssistantMediator implements Mediator {

    private Project mProject;
    
    private ProductManagerChain mProductManager;
    
    private ProjectManagerChain mProjectManager;
    
    private RDChain mRD;
    
    private QAChain mQA;
    
    private CustomerChain mCustomer;
    
    private Context mContext;
    
    private LinearLayout mLayout;
    
    public void setProject(Project project) {
        mProject = project;
    }
    
    public void setProductManager(ProductManagerChain productManager) {
        mProductManager = productManager;
    }
    
    public void setProjectManager(ProjectManagerChain projectManager) {
        mProjectManager = projectManager;
    }
    
    public void setRD(RDChain rd) {
        mRD = rd;
    }
    
    public void setQA(QAChain qa) {
        mQA = qa;
    }
    
    public void setCustomer(CustomerChain customer) {
        mCustomer = customer;
    }
    
    public void setContext(Context context) {
        mContext = context;
    }
    
    public void setLayout(LinearLayout layout) {
        mLayout = layout;
    }
    
    @Override
    public void notifyToUpdate(MembleChain chain) {
        if (chain == mProductManager) {
            notifyFromProductManager();
        } else if (chain == mProjectManager) {
            
        } else if (chain == mRD) {
            
        } else if (chain == mQA) {
            
        } else if (chain == mCustomer) {
            notifyFromCustomer();
        }
        
    }
    
    private void notifyFromProductManager() {
        String order = mProductManager.getOrder();
        mProject.getRootChain().executeOrderToNext(mContext, mLayout, order);
    }
    
    private void notifyFromCustomer() {
        String order = mCustomer.getOrder();
        mProject.getRootChain().executeOrderToNext(mContext, mLayout, order);
    }

}
