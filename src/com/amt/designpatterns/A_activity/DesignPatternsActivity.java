
package com.amt.designpatterns.A_activity;

import com.amt.designpatterns.R;
import com.amt.designpatterns.B_fragment.A_SingletonFragment;
import com.amt.designpatterns.B_fragment.Y_SlidingMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class DesignPatternsActivity extends BaseActivity {

    private Fragment mContent;

    public DesignPatternsActivity() {
        super(R.string.design_patterns_title);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "mContent", mContent);
    }

    public void switchContent(Fragment fragment) {
        mContent = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        getSlidingMenu().showContent();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        // set the Above View
        if (savedInstanceState != null) {
            mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
        }
        if (mContent == null) { // TODO description the design patterns.
            mContent = new A_SingletonFragment();
        }

        setSupportOrientation(true);
        
        // set the Above View
        setContentView(R.layout.content_frame);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, mContent)
                .commit();

        // set the Behind View
        setBehindContentView(R.layout.menu_frame);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.menu_frame, new Y_SlidingMenuFragment())
                .commit();

        // customize the SlidingMenu
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }

    @Override
    protected void initData() {
        
    }

    @Override
    protected void refreshView() {
        
    }

    @Override
    protected void clearData() {
        
    }

}
