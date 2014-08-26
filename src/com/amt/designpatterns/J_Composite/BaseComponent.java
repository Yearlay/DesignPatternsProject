package com.amt.designpatterns.J_Composite;

public abstract class BaseComponent {
    public abstract void add(BaseComponent component);
    public abstract void remove(BaseComponent component);
    public abstract void doSomething();
}
