package com.amt.designpatterns.H_memble;

import android.content.Context;
import android.widget.LinearLayout;

public class ProjectFacade {
    private Project mProject;
    
    private ProductManagerChain mProdutManager;
    
    private ProjectManagerChain mProjectManager;
    
    private RDChain mRD;
    
    private QAChain mQA;
    
    private CustomerChain mCustomer;
    
    private AssistantMediator mAssistant;
    
    public ProjectFacade buildTeam(Context context, LinearLayout showLayout) {
        initMemble();
        initAssistant(context, showLayout);
        initChain();
        return this;
    }

    private void initAssistant(Context context, LinearLayout showLayout) {
        mAssistant.setContext(context);
        mAssistant.setProject(mProject);
        mAssistant.setLayout(showLayout);
        mAssistant.setProductManager(mProdutManager);
        mAssistant.setProjectManager(mProjectManager);
        mAssistant.setRD(mRD);
        mAssistant.setQA(mQA);
        mAssistant.setCustomer(mCustomer);
    }

    private void initMemble() {
        mAssistant = new AssistantMediator();
        mProdutManager = new ProductManagerChain(mAssistant);
        mProjectManager = new ProjectManagerChain(mAssistant);
        mRD = new RDChain(mAssistant);
        mQA = new QAChain(mAssistant);
        mCustomer = new CustomerChain(mAssistant);
        mProject = new Project();
    }

    private void initChain() {
        mProject.setRootChain(mProdutManager);
        mProdutManager.setNextChain(mProjectManager);
        mProjectManager.setNextChain(mRD);
        mRD.setNextChain(mQA);
        mQA.setNextChain(mCustomer);
    }
    
    public void notifyOrderFromProductManager(String order) {
        mProdutManager.notifyOrder("First order: Design!");
    }
    
    public void notifyOrderFromCustomer(String order) {
        new CustomerProxy(mCustomer).notifyOrder(order);
    }
}
