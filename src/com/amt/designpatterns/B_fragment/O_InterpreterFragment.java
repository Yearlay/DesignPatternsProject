
package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.Z_utils.AppLog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class O_InterpreterFragment extends Z_BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.builder, container, false);

        String text = "Interpreter: 22 + 45 - 25 = " + theValue();

        ((TextView) rootView.findViewById(R.id.description)).setText(text);
        AppLog.e("Strategy", " ----- StrategyFragment   initView");

        return rootView;
    }

    @Override
    protected void refreshView() {
        AppLog.e("Strategy", " ----- StrategyFragment   refreshView");
    }

    @Override
    protected void initData() {
        AppLog.e("Strategy", " ----- StrategyFragment   initData");
    }

    @Override
    protected void clearData() {
        AppLog.e("Strategy", " ----- StrategyFragment   clearData");
    }

    @Override
    protected void clickWidget(View view) {
        AppLog.e("Strategy", " ----- StrategyFragment   initData");
    }

    class Calculator {
        private int num1;
        private int num2;

        public Calculator(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getNum1() {
            return num1;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }
    }

    interface Expression {
        public int interpret(Calculator cal);
    }

    class IPlus implements Expression {
        public int interpret(Calculator cal) {
            return cal.getNum1() + cal.getNum2();
        }
    }

    class IMinue implements Expression {
        public int interpret(Calculator cal) {
            return cal.getNum1() - cal.getNum2();
        }
    }

    public int theValue() {
        // 22 + 45 - 25
        return new IMinue().interpret(new Calculator(new IPlus().interpret(new Calculator(22, 45)),
                25));
    }

}
