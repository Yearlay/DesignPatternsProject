package com.amt.designpatterns.D_animation;

import com.amt.designpatterns.Z_utils.AppLog;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public abstract class AnimationTemplate implements AnimationListener {
    protected Animation mAnimationOne;
    protected Animation mAnimationTwo;
    
    private View mView;
    
    public AnimationTemplate(View view) {
        mView = view;
    }
    
    public void runAnimation() {
        initAnimationOne();
        initAnimationTwo();
        regiserAnimationListener();
        startAnimation();
    }
    
    protected abstract void initAnimationOne();
    
    protected abstract void initAnimationTwo();
    
    private void regiserAnimationListener() {
        if (mAnimationOne != null) {
            mAnimationOne.setAnimationListener(this);
        }
    }
    
    @Override
    public void onAnimationEnd(Animation arg0) {
        AppLog.e("Animation", "----------END--------------");
        mView.startAnimation(mAnimationTwo);
    }

    @Override
    public void onAnimationRepeat(Animation arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onAnimationStart(Animation arg0) {
        // TODO Auto-generated method stub
        
    }

    private void startAnimation() {
        if (mAnimationOne != null) {
            mView.startAnimation(mAnimationOne);
        }
        
    }
}
