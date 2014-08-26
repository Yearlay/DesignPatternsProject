
package com.amt.designpatterns.B_fragment;

import java.util.Iterator;

import com.amt.designpatterns.R;
import com.amt.designpatterns.D_animation.AlphaAnimationOption;
import com.amt.designpatterns.D_animation.AnimationTemplate;
import com.amt.designpatterns.D_animation.RotateAnimationOption;
import com.amt.designpatterns.D_animation.TranslateAnimationOption;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class H_TemplateMethodFragment extends Z_BaseFragment {

    private ImageView mImageView;

    public H_TemplateMethodFragment() {
    }

    @Override
    public void clickWidget(View view) {
        switch (view.getId()) {
                
            case R.id.button_animation_alpha:
                AnimationTemplate optionAlpha = new AlphaAnimationOption(mImageView);
                optionAlpha.runAnimation();
                break;
                
            case R.id.button_animation_translate:
                AnimationTemplate optionTranslate = new TranslateAnimationOption(mImageView);
                optionTranslate.runAnimation();
                break;
                
            case R.id.button_animation_rotate:
                AnimationTemplate optionRotate = new RotateAnimationOption(mImageView);
                optionRotate.runAnimation();
                break;

            default:
                break;
        }

    }
    
    @Override
    protected void initData() {
        
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.template_method, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Template method:");

        register((Button) rootView.findViewById(R.id.button_animation_alpha));
        register((Button) rootView.findViewById(R.id.button_animation_translate));
        register((Button) rootView.findViewById(R.id.button_animation_rotate));
        
        mImageView = (ImageView) rootView.findViewById(R.id.imageview);

        // Iterator mode.
        for (Iterator<Button> iterator = mButtonArrayList.iterator(); iterator.hasNext();) {
            iterator.next().setOnClickListener(this);
        }

        return rootView;
    }

    @Override
    protected void refreshView() {
        
    }

    @Override
    protected void clearData() {
        // 
    }
}
