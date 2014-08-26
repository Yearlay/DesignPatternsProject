package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.Y_data.LoginInfo;
import com.amt.designpatterns.Z_utils.ImSharedPreferences;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class A_SingletonFragment extends Z_BaseFragment {
    
    /**  */
    private EditText mUserNameEditView;
    /**  */
    private EditText mPasswordEditView;
    /**  */
    private EditText mServerEditView;

    /**  */
    private CheckBox mSavePasswordCheckBox;
    /**  */
    private CheckBox mAutoLoginCheckBox;
    /**  */
    private Button mCancelButton;
    /**  */
    private Button mLoginButton;

    /** The information of login : user name, password, server. */
    private LoginInfo mLoginInfo = new LoginInfo();
    
    /** mContext : The context. */
    private Context mContext;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = container.getContext();
        // Init editviews.
        View rootView = inflater.inflate(R.layout.fragment_login,
                container, false);
        mUserNameEditView = (EditText) rootView
                .findViewById(R.id.username_editview);
        mPasswordEditView = (EditText) rootView
                .findViewById(R.id.password_editview);
        mServerEditView = (EditText) rootView
                .findViewById(R.id.server_editview);

        // Init checkboxs, set on checked change listener.
        mSavePasswordCheckBox = (CheckBox) rootView
                .findViewById(R.id.save_Password_CheckBox);
        mAutoLoginCheckBox = (CheckBox) rootView
                .findViewById(R.id.auto_Login_CheckBox);

        // Init buttons, set on click listener.
        mCancelButton = (Button) rootView.findViewById(R.id.cancel_Button);
        mLoginButton = (Button) rootView.findViewById(R.id.login_Button);
        mCancelButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    protected void refreshView() {

    }

    @Override
    protected void initData() {
        mLoginInfo = ImSharedPreferences.instance(mContext)
                .getLoginInfoFromSharedPreferences();
        mUserNameEditView.setText(mLoginInfo.username);
        mPasswordEditView.setText(mLoginInfo.password);
        mServerEditView.setText(mLoginInfo.server);
        mSavePasswordCheckBox.setChecked(mLoginInfo.savePassword);
        mAutoLoginCheckBox.setChecked(mLoginInfo.autoLogin);
    }

    @Override
    protected void clearData() {

    }

    @Override
    protected void clickWidget(View view) {
        switch (view.getId()) {
            case R.id.login_Button:
                updateLoginInfo();
                ImSharedPreferences.instance(mContext)
                        .saveDataToSharedPreferences(mLoginInfo);
                break;

            case R.id.cancel_Button:

                break;

            default:
                break;
        }
    }
    
    /** */
    private void updateLoginInfo() {
        mLoginInfo.username = mUserNameEditView.getText().toString();
        mLoginInfo.password = mPasswordEditView.getText().toString();
        mLoginInfo.server = mServerEditView.getText().toString();
        mLoginInfo.savePassword = mSavePasswordCheckBox.isChecked();
        mLoginInfo.autoLogin = mAutoLoginCheckBox.isChecked();
    }

}
