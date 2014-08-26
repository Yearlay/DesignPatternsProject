
package com.amt.designpatterns.B_fragment;

import java.util.ArrayList;
import java.util.Iterator;

import com.amt.designpatterns.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class F_IteratorFragment extends Z_BaseFragment {

    private TextView mShowTextView;

    private String[] mText = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "#"
    };

    private StringBuffer mShowStringBuffer = new StringBuffer("");
    
    protected ArrayList<Button> mButtonList = new ArrayList<Button>();

    public F_IteratorFragment() {
    }

    @Override
    public void clickWidget(View view) {
        switch (view.getId()) {

            case R.id.back_button:
                if (mShowStringBuffer.length() > 0) {
                    mShowStringBuffer = mShowStringBuffer.deleteCharAt(mShowStringBuffer.length() - 1);
                }
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
        }
        View rootView = inflater.inflate(R.layout.iterator, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Iterator:");

        mButtonList.add((Button) rootView.findViewById(R.id.button0));
        mButtonList.add((Button) rootView.findViewById(R.id.button1));
        mButtonList.add((Button) rootView.findViewById(R.id.button2));
        mButtonList.add((Button) rootView.findViewById(R.id.button3));
        mButtonList.add((Button) rootView.findViewById(R.id.button4));
        mButtonList.add((Button) rootView.findViewById(R.id.button5));
        mButtonList.add((Button) rootView.findViewById(R.id.button6));
        mButtonList.add((Button) rootView.findViewById(R.id.button7));
        mButtonList.add((Button) rootView.findViewById(R.id.button8));
        mButtonList.add((Button) rootView.findViewById(R.id.button9));
        mButtonList.add((Button) rootView.findViewById(R.id.button10));
        mButtonList.add((Button) rootView.findViewById(R.id.button11));
        mButtonList.add((Button) rootView.findViewById(R.id.back_button));

        // Iterator mode.
        for (Iterator<Button> iterator = mButtonList.iterator(); iterator.hasNext();) {
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
    }

    class UpdateTextTask extends AsyncTask<Void , Void, Void> {

        @Override
        protected void onPostExecute(Void result) {
            for (int index = 0; index < mButtonList.size() && index < mText.length; index++) {
                mButtonList.get(index).setText(mText[index]);
            }
            mShowTextView.setText(mShowStringBuffer);
            super.onPostExecute(result);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            randomText();
            return null;
        }
        
    }
}
