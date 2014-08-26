
package com.amt.designpatterns.B_fragment;

import com.amt.designpatterns.R;
import com.amt.designpatterns.A_activity.DesignPatternsActivity;
import com.amt.designpatterns.Y_data.DesignPatterns;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Y_SlidingMenuFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] colors = getResources().getStringArray(R.array.design_patterns_names);
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, colors);
        setListAdapter(colorAdapter);
    }

    @Override
    public void onListItemClick(ListView listview, View v, int position, long id) {
        Fragment newContent = null;
        switch (position) {
            case DesignPatterns.A_Singleton:
                newContent = new A_SingletonFragment();
                break;
            case DesignPatterns.B_Abstract_Factory:
                newContent = new B_AbstractFactoryFragment();
                break;
            case DesignPatterns.C_Factory_Method:
                newContent = new C_FactoryMethodFragment();
                break;
            case DesignPatterns.D_Builder:
                newContent = new D_BuilderFragment();
                break;
            case DesignPatterns.E_Prototype:
                newContent = new E_PrototypeFragment();
                break;
            case DesignPatterns.F_Iterator:
                newContent = new F_IteratorFragment();
                break;
            case DesignPatterns.G_Observer:
                newContent = new G_ObserverFragment();
                break;
            case DesignPatterns.H_Template_Method:
                newContent = new H_TemplateMethodFragment();
                break;
            case DesignPatterns.I_Command:
                newContent = new I_CommandFragment();
                break;
            case DesignPatterns.J_State:
                newContent = new J_StateFragment();
                break;
            case DesignPatterns.K_Strategy:
                newContent = new K_StrategyFragment();
                break;
            case DesignPatterns.L_Chain_of_Responsibility:
                newContent = new L_ChainOfResponsibilityFragment();
                break;
            case DesignPatterns.M_Mediator:
                newContent = new M_MediatorFragment();
                break;
            case DesignPatterns.N_Visitor:
                newContent = new N_VisitorFragment();
                break;
            case DesignPatterns.O_Interpreter:
                newContent = new O_InterpreterFragment();
                break;
            case DesignPatterns.P_Memento:
                newContent = new P_MementoFragment();
                break;
            case DesignPatterns.Q_Composite:
                newContent = new Q_CompositeFragment();
                break;
            case DesignPatterns.R_Facade:
                newContent = new R_FacadeFragment();
                break;
            case DesignPatterns.S_Proxy:
                newContent = new S_ProxyFragment();
                break;
            case DesignPatterns.T_Adapter:
                newContent = new T_AdapterFragment();
                break;
            case DesignPatterns.U_Decrator:
                newContent = new U_DecratorFragment();
                break;
            case DesignPatterns.V_Bridge:
                newContent = new V_BridgeFragment();
                break;
            case DesignPatterns.W_Flyweight:
                newContent = new W_FlyweightFragment();
                break;
        }
        if (newContent != null) {
            switchFragment(newContent);
        }
    }

    // the meat of switching the above fragment
    private void switchFragment(Fragment fragment) {
        if (getActivity() == null)
            return;

        if (getActivity() instanceof DesignPatternsActivity) {
            DesignPatternsActivity fca = (DesignPatternsActivity) getActivity();
            fca.switchContent(fragment);
        }
    }

}
