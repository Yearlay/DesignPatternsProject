package com.amt.designpatterns.D_animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public class RotateAnimationOption extends AnimationTemplate {

    public RotateAnimationOption(View view) {
        super(view);
    }

    @Override
    protected void initAnimationOne() {
        mAnimationOne = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
        mAnimationOne.setDuration(1000);
    }

    @Override
    protected void initAnimationTwo() {
        mAnimationTwo = new RotateAnimation(360, 0, 
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
        mAnimationTwo.setDuration(1000);
    }

}
