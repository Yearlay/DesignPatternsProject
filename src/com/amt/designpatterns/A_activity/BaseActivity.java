
package com.amt.designpatterns.A_activity;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.amt.designpatterns.R;
import com.amt.designpatterns.C_manager.AppManager;
import com.amt.designpatterns.Z_utils.AppLog;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public abstract class BaseActivity extends SlidingFragmentActivity {
    private int mTitleRes;
    protected ListFragment mFrag;
    
    private static final int ACTIVITY_RESUME = 0;
    private static final int ACTIVITY_STOP = 1;
    private static final int ACTIVITY_PAUSE = 2;
    private static final int ACTIVITY_DESTROY = 3;
    
    private boolean mSupportOrientation = false;
    
    public boolean isSupportOrientation() {
        return mSupportOrientation;
    }

    public void setSupportOrientation(boolean mSupportOrientation) {
        this.mSupportOrientation = mSupportOrientation;
    }

    public int activityState;

    public BaseActivity(int titleRes) {
        mTitleRes = titleRes;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(mTitleRes);

        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setFadeDegree(0.35f);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        if (!isSupportOrientation()) {
            AppManager.getAppManager().addActivity(this);
        }
        
        initView(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                toggle();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.hello_world, menu);
        return true;
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        AppLog.state(this.getClass(), "---------onStart ");
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityState = ACTIVITY_RESUME;
        AppLog.state(this.getClass(), "---------onResume ");
        refreshView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        activityState = ACTIVITY_STOP;
        AppLog.state(this.getClass(), "---------onStop ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityState = ACTIVITY_PAUSE;
        AppLog.state(this.getClass(), "---------onPause ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        AppLog.state(this.getClass(), "---------onRestart ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityState = ACTIVITY_DESTROY;
        AppLog.state(this.getClass(), "---------onDestroy ");
        clearData();
        if (!isSupportOrientation()) {
            AppManager.getAppManager().finishActivity(this);
        }
    }
    
    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void refreshView();
    
    protected abstract void clearData();
    
}
