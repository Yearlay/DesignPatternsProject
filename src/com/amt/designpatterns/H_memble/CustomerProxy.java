package com.amt.designpatterns.H_memble;

public class CustomerProxy {
    private CustomerChain mCustomer;
    
    public CustomerProxy(CustomerChain customer) {
        mCustomer = customer;
    }
    
    public void notifyOrder(String order) {
        mCustomer.notifyOrder(order);
    }
}
