package com.amt.designpatterns.H_memble;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomerChain extends MembleChain {
    
    public CustomerChain(Mediator mediator) {
        super(mediator);
        mResponsibility = MembleChain.OVER_PROJECT;
    }

    @Override
    public void doResponsibility(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("I am Customer.  My responsibility : " + mResponsibility);
        
        layout.addView(textView);

    }

    @Override
    public void executeOrder(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("I am Customer.  get the order : " + mOrder);
        
        layout.addView(textView);
    }

    @Override
    public void acceptVisitor(BaseVisitor visitor) {
        visitor.visit(this);
    }

    
    /** Component : Composite Mode */
    
    @Override
    public void add(MembleChain memble) {
        
    }

    @Override
    public void remove(MembleChain memble) {
        
    }
}
