package com.amt.designpatterns.H_memble;

public class ProductManagerJob implements JobImpl {
    private String mJob;

    public ProductManagerJob(String job) {
        super();
        this.mJob = job;
    }

    @Override
    public String getjob() {
        return mJob;
    }

    @Override
    public void dojob() {
        // TODO Auto-generated method stub

    }

}
