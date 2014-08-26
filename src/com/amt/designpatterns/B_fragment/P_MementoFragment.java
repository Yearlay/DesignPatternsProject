
package com.amt.designpatterns.B_fragment;

import java.util.ArrayList;
import java.util.Iterator;

import com.amt.designpatterns.R;
import com.amt.designpatterns.I_Memento.Caretaker;
import com.amt.designpatterns.I_Memento.Memento;
import com.amt.designpatterns.I_Memento.MementoData;

import android.annotation.SuppressLint;
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
public class P_MementoFragment extends Z_BaseFragment {

    private String[] mText = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "#"
    };

    private StringBuffer mShowStringBuffer = new StringBuffer("");
    
    protected ArrayList<Button> mButtonList = new ArrayList<Button>();
    
    private Caretaker mCaretaker = new Caretaker();

    public P_MementoFragment() {
    }

    @Override
    public void clickWidget(View view) {
        switch (view.getId()) {
            case R.id.undo_button: {
                Memento memento = mCaretaker.retrieveMementoFromList();
                if (memento != null) {
                    mButtonList.get(memento.getData().index).setText(memento.getData().showStr);
                }
                
                memento = mCaretaker.getTheTopMemento();
                if (memento != null) {
                    mButtonList.get(memento.getData().index).setText("(" + 
                                    memento.getData().showStr + ")");
                }
                
                break;
            }

            default: {
                Memento memento = mCaretaker.getTheTopMemento();
                if (memento != null) {
                    mButtonList.get(memento.getData().index).setText(memento.getData().showStr);
                }
                
                int index = (Integer) view.getTag();
                mButtonList.get(index).setText("(" + index + ")");
                mCaretaker.saveMementoToList(new Memento(new MementoData("" + index, index)));
                break;
            }
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

    @SuppressLint("UseValueOf")
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.memento, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Memento:");

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
        mButtonList.add((Button) rootView.findViewById(R.id.undo_button));

        // Iterator mode.
        for (Iterator<Button> iterator = mButtonList.iterator(); iterator.hasNext();) {
            iterator.next().setOnClickListener(this);
        }
        
        for (int index = 0; index < mButtonList.size() - 1; index++) {
            mButtonList.get(index).setText("" + index);
            mButtonList.get(index).setTag(new Integer(index));
        }

        return rootView;
    }

    @Override
    protected void refreshView() {
        // new UpdateTextTask().execute();
        
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
            super.onPostExecute(result);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            randomText();
            return null;
        }
    }
}
