package com.amt.designpatterns.H_memble;

public interface BaseVisitor {
    public void visit(ProductManagerChain productMannager);
    
    public void visit(ProjectManagerChain projectManager);
    
    public void visit(RDChain rd);
    
    public void visit(QAChain qa);
    
    public void visit(CustomerChain customer);
}
