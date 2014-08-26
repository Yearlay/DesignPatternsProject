
package com.amt.designpatterns.B_fragment;

import java.util.Iterator;

import com.amt.designpatterns.R;
import com.amt.designpatterns.D_animation.AlphaAnimationOption;
import com.amt.designpatterns.D_animation.AnimationTemplate;
import com.amt.designpatterns.D_animation.RotateAnimationOption;
import com.amt.designpatterns.D_animation.TranslateAnimationOption;
import com.amt.designpatterns.F_factory.StyleFactory;
import com.amt.designpatterns.Y_data.ShowStyle;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class Z_SetSkinStyleFragment extends Z_BaseFragment implements 
            OnCheckedChangeListener {

    private CheckBox mRedCheckBox;

    private CheckBox mBlueCheckBox;

    private Button mShowButton;

    private LinearLayout mShowLinearLayout;

    /** State Mode. */
    private ShowStyle mShowStyle = ShowStyle.RED;

    public void setShowStyle(ShowStyle mShowStyle) {
        this.mShowStyle = mShowStyle;
    }

    public ShowStyle getShowStyle() {
        return mShowStyle;
    }

    private TextView mShowTextView;

    private String[] mText = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "#"
    };

    private StringBuffer mShowStringBuffer = new StringBuffer("");

    public Z_SetSkinStyleFragment() {
    }

    @Override
    public void clickWidget(View view) {
        switch (view.getId()) {
            case R.id.click_button:
                mShowLinearLayout.removeAllViews();
                StyleFactory styleFactory = StyleFactory.getStyleFactory(getShowStyle());
                mShowLinearLayout.addView(styleFactory.createStyleButton(getActivity()));
                mShowLinearLayout.addView(styleFactory.createStyleTextView(getActivity()));
                
                // observer mode. notify.
                notifyButton(getShowStyle());
                break;

            case R.id.back_button:
                if (mShowStringBuffer.length() > 0) {
                    mShowStringBuffer = mShowStringBuffer.deleteCharAt(mShowStringBuffer.length() - 1);
                }
                break;
                
            case R.id.button_animation_alpha:
                AnimationTemplate optionAlpha = new AlphaAnimationOption(view);
                optionAlpha.runAnimation();
                break;
                
            case R.id.button_animation_translate:
                AnimationTemplate optionTranslate = new TranslateAnimationOption(view);
                optionTranslate.runAnimation();
                break;
                
            case R.id.button_animation_rotate:
                AnimationTemplate optionRotate = new RotateAnimationOption(view);
                optionRotate.runAnimation();
                break;

            default:
                if (view instanceof Button) {
                    mShowStringBuffer = mShowStringBuffer.append(((Button) view).getText());
                }
                break;
        }
        mShowTextView.setText(mShowStringBuffer);

    }

    @Override
    public void onCheckedChanged(CompoundButton view, boolean checked) {
        switch (view.getId()) {
            case R.id.red_skin_checkbox:
                mBlueCheckBox.setChecked(!checked);
                if (checked) {
                    setShowStyle(ShowStyle.RED);
                }
                break;

            case R.id.blue_skin_checkbox:
                mRedCheckBox.setChecked(!checked);
                if (checked) {
                    setShowStyle(ShowStyle.BLUE);
                }
                break;

            default:
                break;
        }
    }

    @Override
    protected void initData() {
        
    }

    private void randomText() {
        int index = 0;
        for (int i = 0; i < mText.length; i++) {
            index = (int) ((Math.random() * 1000) % 12);
            String tmp = mText[i];
            mText[i] = mText[index];
            mText[index] = tmp;
        }
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mShowStringBuffer = new StringBuffer(savedInstanceState.getString("mShowStringBuffer"));
            mShowStyle = savedInstanceState.getInt("mShowStyle", 1) == 1 ? ShowStyle.RED : ShowStyle.BLUE;
        }
        View rootView = inflater.inflate(R.layout.fragment_skin_select, container, false);

        mRedCheckBox = (CheckBox) rootView.findViewById(R.id.red_skin_checkbox);
        mBlueCheckBox = (CheckBox) rootView.findViewById(R.id.blue_skin_checkbox);
        mShowButton = (Button) rootView.findViewById(R.id.click_button);
        mShowLinearLayout = (LinearLayout) rootView.findViewById(R.id.show_layout);

        mRedCheckBox.setOnCheckedChangeListener(this);
        mBlueCheckBox.setOnCheckedChangeListener(this);
        mRedCheckBox.setChecked(true);
        mBlueCheckBox.setChecked(false);
        mShowButton.setOnClickListener(this);

        register((Button) rootView.findViewById(R.id.button0));
        register((Button) rootView.findViewById(R.id.button1));
        register((Button) rootView.findViewById(R.id.button2));
        register((Button) rootView.findViewById(R.id.button3));
        register((Button) rootView.findViewById(R.id.button4));
        register((Button) rootView.findViewById(R.id.button5));
        register((Button) rootView.findViewById(R.id.button6));
        register((Button) rootView.findViewById(R.id.button7));
        register((Button) rootView.findViewById(R.id.button8));
        register((Button) rootView.findViewById(R.id.button9));
        register((Button) rootView.findViewById(R.id.button10));
        register((Button) rootView.findViewById(R.id.button11));
        register((Button) rootView.findViewById(R.id.back_button));
        register((Button) rootView.findViewById(R.id.button_animation_alpha));
        register((Button) rootView.findViewById(R.id.button_animation_translate));
        register((Button) rootView.findViewById(R.id.button_animation_rotate));

        // Iterator mode.
        for (Iterator<Button> iterator = mButtonArrayList.iterator(); iterator.hasNext();) {
            iterator.next().setOnClickListener(this);
        }

        mShowTextView = (TextView) rootView.findViewById(R.id.show_input_textview);

        return rootView;
    }

    @Override
    protected void refreshView() {
        new UpdateTextTask().execute();
        
    }

    @Override
    protected void clearData() {
        // 
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mShowStringBuffer", mShowStringBuffer.toString());
        outState.putInt("mShowStyle", mShowStyle == ShowStyle.RED ? 1 : 2);
    }

    class UpdateTextTask extends AsyncTask<Void , Void, Void> {

        @Override
        protected void onPostExecute(Void result) {
            for (int index = 0; index < mButtonArrayList.size() && index < mText.length; index++) {
                mButtonArrayList.get(index).setText(mText[index]);
            }
            mShowTextView.setText(mShowStringBuffer);
            notifyButton(getShowStyle());
            super.onPostExecute(result);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            randomText();
            return null;
        }
        
    }
}
