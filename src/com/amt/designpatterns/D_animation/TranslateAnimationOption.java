package com.amt.designpatterns.D_animation;

import android.view.View;
import android.view.animation.TranslateAnimation;

public class TranslateAnimationOption extends AnimationTemplate {

    public TranslateAnimationOption(View view) {
        super(view);
    }

    @Override
    protected void initAnimationOne() {
        mAnimationOne = new TranslateAnimation(0, 0, 0, 250);
        mAnimationOne.setDuration(1000);
    }

    @Override
    protected void initAnimationTwo() {
        mAnimationTwo = new TranslateAnimation(0, 0, 250, 0);
        mAnimationTwo.setDuration(1000);
    }

}
