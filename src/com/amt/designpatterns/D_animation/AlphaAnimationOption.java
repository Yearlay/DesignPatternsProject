package com.amt.designpatterns.D_animation;

import android.view.View;
import android.view.animation.AlphaAnimation;

public class AlphaAnimationOption extends AnimationTemplate {

    public AlphaAnimationOption(View view) {
        super(view);
    }

    @Override
    protected void initAnimationOne() {
        mAnimationOne = new AlphaAnimation(1.0f, 0.1f); 
        mAnimationOne.setDuration(1000);
    }

    @Override
    protected void initAnimationTwo() {
        mAnimationTwo = new AlphaAnimation(0.1f, 1.0f);
        mAnimationTwo.setDuration(1000);

    }

}
