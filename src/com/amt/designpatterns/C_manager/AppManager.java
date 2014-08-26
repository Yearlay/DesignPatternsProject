package com.amt.designpatterns.C_manager;

import java.util.Stack;

import com.amt.designpatterns.A_activity.BaseActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;


public class AppManager {
    
    private static Stack<BaseActivity> mActivityStack;
    private static AppManager mInstance;
 
    private AppManager() {
    }
 
    /**
     * Use Singleton Mode.
     */
    public synchronized static AppManager getAppManager() {
        if (mInstance == null) {
            mInstance = new AppManager();
        }
        return mInstance;
    }
 
    /**
     * Add the Activity into stack.
     */
    public void addActivity(BaseActivity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<BaseActivity>();
        }
        mActivityStack.add(activity);
    }
 
    /**
     * Get the current Activity（the last Activity）
     */
    public BaseActivity currentActivity() {
        if (mActivityStack == null || mActivityStack.isEmpty()) {
            return null;
        }
        BaseActivity activity = mActivityStack.lastElement();
        return activity;
    }
 
    /**
     * Get the Activity of "cls" from the Stack;
     * @param cls the name of activity.
     * @return activity, null.
     */
    public BaseActivity findActivity(Class<?> cls) {
        BaseActivity activity = null;
        for (BaseActivity aty : mActivityStack) {
            if (aty.getClass().equals(cls)) {
                activity = aty;
                break;
            }
        }
        return activity;
    }
 
    /**
     * 结束当前Activity（栈顶Activity）
     */
    public void finishActivity() {
        BaseActivity activity = mActivityStack.lastElement();
        finishActivity(activity);
    }
 
    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }
 
    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(Class<?> cls) {
        for (BaseActivity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }
 
    /**
     * 关闭除了指定activity以外的全部activity 如果cls不存在于栈中，则栈全部清空
     * 
     * @param cls
     */
    public void finishOthersActivity(Class<?> cls) {
        for (BaseActivity activity : mActivityStack) {
            if (!(activity.getClass().equals(cls))) {
                finishActivity(activity);
            }
        }
    }
 
    /**
     * Force to finish all activitys.
     */
    public void finishAllActivity() {
        for (int i = 0, size = mActivityStack.size(); i < size; i++) {
            if (null != mActivityStack.get(i)) {
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }
 
    /**
     * App exit.
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            System.exit(0);
        }
    }
}