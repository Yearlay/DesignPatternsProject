package com.amt.designpatterns.H_memble;

import java.util.ArrayList;

public class SimpleVisitor implements BaseVisitor {

    ArrayList<String> mGetAllResponsibility = new ArrayList<String>();
    
    public void clearVisitorMessage() {
        mGetAllResponsibility.clear();
    }
    
    public ArrayList<String> getVisitorMessage() {
        return mGetAllResponsibility;
    }
    
    @Override
    public void visit(ProductManagerChain productMannager) {
        mGetAllResponsibility.add(productMannager.getResponsibility());

    }

    @Override
    public void visit(ProjectManagerChain projectManager) {
        mGetAllResponsibility.add(projectManager.getResponsibility());

    }

    @Override
    public void visit(RDChain rd) {
        mGetAllResponsibility.add(rd.getResponsibility());

    }

    @Override
    public void visit(QAChain qa) {
        mGetAllResponsibility.add(qa.getResponsibility());

    }

    @Override
    public void visit(CustomerChain customer) {
        mGetAllResponsibility.add(customer.getResponsibility());

    }

}
