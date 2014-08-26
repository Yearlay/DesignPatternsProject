package com.amt.designpatterns.B_fragment;

import java.util.ArrayList;

import com.amt.designpatterns.R;
import com.amt.designpatterns.E_view.ObserverButton;
import com.amt.designpatterns.Y_data.ShowStyle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class G_ObserverFragment extends Z_BaseFragment 
                implements OnCheckedChangeListener {
    
    private RadioGroup mRadioGroup;
    
    private LinearLayout mShowLayout;
    
    protected ArrayList<ObserverButton> mButtonArrayList = new ArrayList<ObserverButton>();
    
    private ShowStyle mShowStyle = ShowStyle.RED;

    public void setShowStyle(ShowStyle mShowStyle) {
        this.mShowStyle = mShowStyle;
    }

    public ShowStyle getShowStyle() {
        return mShowStyle;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.observer, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Observer:");
        
        mRadioGroup = (RadioGroup) rootView.findViewById(R.id.style_radiogroup);
        mShowLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);
        
        mRadioGroup.check(R.id.red_radiobutton);
        mRadioGroup.setOnCheckedChangeListener(this);
        
        for (int i = 0; i <20; i++) {
            ObserverButton button = new ObserverButton(getActivity());
            button.setOnClickListener(this);
            mShowLayout.addView(button);
            // mButtonArrayList.add(button);    // TODO: Add.
        }
        
        return rootView;
    }
    
    public void notifyButton(ShowStyle showStyle) {
        for (ObserverButton button : mButtonArrayList) {
            button.updateStyle(showStyle);
        }
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
        if (view instanceof ObserverButton) {
            ObserverButton observerButton = (ObserverButton) view;
            observerButton.setObserver(!observerButton.isObserver());
            observerButton.updateStyle(getShowStyle());
            // TODO : delete
            if (observerButton.isObserver()) {
                mButtonArrayList.add(observerButton);
            } else {
                mButtonArrayList.remove(observerButton);
            }
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
        notifyButton(getShowStyle());
    }

}
