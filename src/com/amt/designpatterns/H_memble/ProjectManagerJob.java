package com.amt.designpatterns.H_memble;

public class ProjectManagerJob implements JobImpl {
    private String mJob;

    public ProjectManagerJob(String job) {
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
