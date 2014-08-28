package com.amt.designpatterns.H_memble;

import android.content.Context;
import android.widget.LinearLayout;

public abstract class MembleChain {
    
    public static final String INIT_PROJECT = "init project";
    
    public static final String BUILD_TEAM = "Build team";
    
    public static final String DESIGN_CODE = "Degine code";
    
    public static final String TEST_REPORT = "Test report";
    
    public static final String OVER_PROJECT = "Over";
    
    private final Mediator mAssistant;
    
    protected MembleChain mNextChain;
    
    protected String mResponsibility;
    
    protected String mOrder;
    
    protected JobImpl mJobImpl;
    
    public JobImpl getmJobImpl() {
        return mJobImpl;
    }

    public void setmJobImpl(JobImpl mJobImpl) {
        this.mJobImpl = mJobImpl;
    }

    public MembleChain(Mediator mediator) {
        mAssistant = mediator;
    }
    
    public Mediator getMediator() {
        return mAssistant;
    }
    
    public MembleChain getNextChain() {
        return mNextChain;
    }
    
    public void setResponsibility(String responsibility) {
        mResponsibility = responsibility;
    }
    
    public String getResponsibility() {
        return mResponsibility;
    }
    

    public String getOrder() {
        return mOrder;
    }
    
    public void setOrder(String order) {
        mOrder = order;
    }
    
    public void notifyOrder(String order) {
        setOrder(order);
        this.getMediator().notifyToUpdate(this);
    }
    
    public void executeOrderToNext(Context context, LinearLayout layout, String order) {
        mOrder = order;
        executeOrder(context, layout);
        if (mNextChain != null) {
            mNextChain.executeOrderToNext(context, layout, mOrder);
        }
    }
    
    public abstract void executeOrder(Context context, LinearLayout layout);
    
    public void askResponsibility(Context context, LinearLayout layout, String string) {
        if (string.equals(mResponsibility)) {
            doResponsibility(context, layout);
        } else {
            if (mNextChain != null) {
                mNextChain.askResponsibility(context, layout, string);
            }
        }
    }
    
    public void setNextChain(MembleChain chain) {
        mNextChain = chain;
    }
    
    public abstract void acceptVisitor(BaseVisitor visitor);
    
    public abstract void doResponsibility(Context context, LinearLayout layout);
    
    /** Component : Composite Mode */
    public abstract void add(MembleChain memble);
    public abstract void remove(MembleChain memble);
}
