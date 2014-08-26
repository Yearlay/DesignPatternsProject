
package com.amt.designpatterns.Z_utils;

import com.amt.designpatterns.Y_data.LoginInfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ImSharedPreferences {
    private static final String LOGINFO_FILE_NAME = "login_info";

    static ImSharedPreferences mSharedPreferences;

    public Context mContext;

    public synchronized static ImSharedPreferences instance(Context context) {
        if (mSharedPreferences == null) {
            mSharedPreferences = new ImSharedPreferences(context);
        }
        return mSharedPreferences;
    }

    public ImSharedPreferences(Context context) {
        mContext = context;
    }

    public void saveDataToSharedPreferences(LoginInfo loginInfo) {
        SharedPreferences sPreferences = mContext.getSharedPreferences(LOGINFO_FILE_NAME,
                Context.MODE_PRIVATE);
        Editor editor = sPreferences.edit();
        editor.putString("username", loginInfo.username);
        editor.putString("password", loginInfo.password);
        editor.putString("server", loginInfo.server);
        editor.putBoolean("savePassword", loginInfo.savePassword);
        editor.putBoolean("autoLogin", loginInfo.autoLogin);
        editor.commit();
    }

    public LoginInfo getLoginInfoFromSharedPreferences() {
        LoginInfo loginInfo = new LoginInfo();
        SharedPreferences sPreferences = mContext.getSharedPreferences(LOGINFO_FILE_NAME,
                Context.MODE_PRIVATE);
        loginInfo.username = sPreferences.getString("username", "");
        loginInfo.password = sPreferences.getString("password", "");
        loginInfo.server = sPreferences.getString("server", "");
        loginInfo.savePassword =
                sPreferences.getBoolean("savePassword", false);
        loginInfo.autoLogin =
                sPreferences.getBoolean("autoLogin", false);
        return loginInfo;
    }
}
