package com.zhw.java.study.thread;

public class MySignal {

    protected boolean hasDataToProcess = false;

    public synchronized boolean isHasDataToProcess() {
        return hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }
}
