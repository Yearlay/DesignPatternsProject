package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.L_decrator.Animal;
import com.amt.designpatterns.L_decrator.Developer;
import com.amt.designpatterns.L_decrator.Human;
import com.amt.designpatterns.L_decrator.PManager;
import com.amt.designpatterns.L_decrator.Primates;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class U_DecratorFragment extends Z_BaseFragment {
    
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.builder, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Decrator: TODO.");
        
        Animal animal = new Animal(null);
        Animal primates = new Primates(animal);
        Animal human = new Human(primates);
        Animal developer = new Developer(human);
        Animal pmanager = new PManager(developer);
        
        
        String text = "The pmanager's property: " + pmanager.getProperty();
        TextView textView = new TextView(this.getActivity());
        textView.setText(text);
        ((LinearLayout) rootView.findViewById(R.id.show_layout)).addView(textView);
        
        return rootView;
    }

    @Override
    protected void refreshView() {}

    @Override
    protected void initData() {}

    @Override
    protected void clearData() {}

    @Override
    protected void clickWidget(View view) {}

}
