
package com.amt.designpatterns.B_fragment;

import java.util.ArrayList;

import com.amt.designpatterns.Y_data.ShowStyle;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public abstract class Z_BaseFragment extends Fragment implements 
                OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(inflater, container, savedInstanceState);
    }
    
    @Override
    public void onDestroy() {
        clearData();
        super.onDestroy();
    }


    @Override
    public void onStart() {
        initData();
        super.onStart();
    }

    @Override
    public void onResume() {
        refreshView();
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        clickWidget(view);
    }

    protected abstract View initView(LayoutInflater inflater, 
            ViewGroup container, Bundle savedInstanceState);
    
    protected abstract void refreshView();
    
    protected abstract void initData();
    
    protected abstract void clearData();
    
    protected abstract void clickWidget(View view);
    
    // Observer mode.
    protected ArrayList<Button> mButtonArrayList = new ArrayList<Button>();
    
    public void register(Button button) {
        mButtonArrayList.add(button);
    }
    
    public void unregister(Button button) {
        mButtonArrayList.remove(button);
    }
    
    public void notifyButton(ShowStyle showStyle) {
        int color = Color.BLACK;
        if (showStyle == ShowStyle.RED) {
            color = Color.RED;
        } else if (showStyle == ShowStyle.BLUE) {
            color = Color.BLUE;
        }
        for (Button button : mButtonArrayList) {
            button.setTextColor(color);
        }
    }

}
