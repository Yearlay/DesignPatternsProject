package com.amt.designpatterns.H_memble;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RDChain extends MembleChain {
    
    public RDChain(Mediator mediator) {
        super(mediator);
        mResponsibility = MembleChain.DESIGN_CODE;
    }

    @Override
    public void doResponsibility(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("I am RD.  My responsibility : " + mResponsibility);
        
        layout.addView(textView);

    }

    @Override
    public void executeOrder(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("I am RD.  get the order : " + mOrder);
        
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
