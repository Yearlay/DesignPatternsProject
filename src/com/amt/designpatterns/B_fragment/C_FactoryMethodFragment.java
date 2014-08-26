package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.E_view.StyleButton;
import com.amt.designpatterns.E_view.StyleTextView;
import com.amt.designpatterns.F_factory.StyleFactory;
import com.amt.designpatterns.Y_data.ShowStyle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class C_FactoryMethodFragment extends Z_BaseFragment 
                implements OnCheckedChangeListener {
    
    private RadioGroup mRadioGroup;
    
    private Button mClickButton;
    
    private LinearLayout mShowLayout;
    
    private ShowStyle mShowStyle = ShowStyle.RED;

    public void setShowStyle(ShowStyle mShowStyle) {
        this.mShowStyle = mShowStyle;
    }

    public ShowStyle getShowStyle() {
        return mShowStyle;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.factory, container, false);
        
        mRadioGroup = (RadioGroup) rootView.findViewById(R.id.style_radiogroup);
        mClickButton = (Button) rootView.findViewById(R.id.click_button);
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);
        ((TextView) rootView.findViewById(R.id.description)).setText("Factory method:");
        
        mRadioGroup.check(R.id.red_radiobutton);
        mRadioGroup.setOnCheckedChangeListener(this);
        
        mClickButton.setOnClickListener(this);
        
        return rootView;
    }

    @Override
    protected void refreshView() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void initData() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void clearData() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void clickWidget(View view) {
        if (view.getId() == R.id.click_button) {
            mShowLayout.removeAllViews();
            
            // Get the factory according to the style.
            StyleFactory styleFactory = StyleFactory.getStyleFactory(getShowStyle());
            
            // get the styleButton of the styleFactory.
            StyleButton styleButton = styleFactory.createStyleButton(getActivity());
            mShowLayout.addView(styleButton);
            
            // get the styleTextView of the styleFactory.
            StyleTextView styleTextView = styleFactory.createStyleTextView(getActivity());
            mShowLayout.addView(styleTextView);
        }
        
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
        switch (checkId) {
            case R.id.red_radiobutton:
                setShowStyle(ShowStyle.RED);
                break;

            case R.id.blue_radiobutton:
                setShowStyle(ShowStyle.BLUE);
                break;
                
            default:
                break;
        }
        
    }

}
