package com.amt.designpatterns.H_memble;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QAChain extends MembleChain {
    
    public QAChain(Mediator mediator) {
        super(mediator);
        mResponsibility = MembleChain.TEST_REPORT;
    }

    @Override
    public void doResponsibility(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("I am QA.  My responsibility : " + mResponsibility);
        
        layout.addView(textView);

    }

    @Override
    public void executeOrder(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("I am QA.  get the order : " + mOrder);
        
        layout.addView(textView);
    }

    @Override
    public void acceptVisitor(BaseVisitor visitor) {
        visitor.visit(this);
        
    }
    
    /** Component : Composite Mode */

    @Override
    public void add(MembleChain memble) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remove(MembleChain memble) {
        // TODO Auto-generated method stub
        
    }
}
