package com.amt.designpatterns.H_memble;

import java.util.ArrayList;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProductManagerChain extends MembleChain {
    
    public ProductManagerChain(Mediator mediator) {
        super(mediator);
        mResponsibility = MembleChain.INIT_PROJECT;
    }

    @Override
    public void doResponsibility(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("I am product manager.  My responsibility : " + mResponsibility);
        
        layout.addView(textView);

    }

    @Override
    public void executeOrder(Context context, LinearLayout layout) {
        TextView textView = new TextView(context);
        textView.setText("I am product manager.  get the order : " + mOrder);
        layout.addView(textView);
        
        if (mMembleList.size() > 0) {
            for (MembleChain memble : mMembleList) {
                memble.executeOrder(context, layout);
            }
        }
    }

    @Override
    public void acceptVisitor(BaseVisitor visitor) {
        visitor.visit(this);
        
    }
    
    /** Component : Composite Mode */
    private ArrayList<MembleChain> mMembleList = new ArrayList<MembleChain>();
    
    @Override
    public void add(MembleChain memble) {
        mMembleList.add(memble);
    }

    @Override
    public void remove(MembleChain memble) {
        mMembleList.remove(memble);
    }
}
