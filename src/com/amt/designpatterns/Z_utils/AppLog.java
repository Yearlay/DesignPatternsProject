package com.amt.designpatterns.Z_utils;

import com.amt.designpatterns.A_activity.BaseActivity;

import android.util.Log;

public class AppLog {
    private static final boolean DEBUG = true;
    
    private static final String TAG = "Singleton";
    
    public static void debug(String string) {
        if (DEBUG) {
            Log.e(TAG, string);
        }
        
    }
    
    public static void state(Class<? extends BaseActivity> class1, String string) {
        if (DEBUG) {
            Log.i(class1.toString(), string);
        }
    }
    
    public static void v(String tag,String msg){
        if(DEBUG){
            Log.v(tag, msg);
        }
    }
    
    public static void d(String tag,String msg){
        if(DEBUG){
            Log.d(tag, msg);
        }
    }
    
    public static void i(String tag,String msg){
        if(DEBUG){
            Log.i(tag, msg);
        }
    }
    
    public static void w(String tag,String msg){
        if(DEBUG){
            Log.w(tag, msg);
        }
    }
    
    public static void e(String tag,String msg){
        if(DEBUG){
            Log.e(tag, msg);
        }
    }
    
    public static void w(String tag,String msg,Throwable t){
        if(DEBUG){
            Log.w(tag, msg, t);
        }
    }
    
    public static void e(String tag,String msg,Throwable t){
        if(DEBUG){
            Log.e(tag, msg, t);
        }
    }


}
