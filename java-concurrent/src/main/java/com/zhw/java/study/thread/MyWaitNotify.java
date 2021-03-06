package com.zhw.java.study.thread;

public class MyWaitNotify {

    private MyMonitorObject myMonitorObject = new MyMonitorObject();

    private boolean wasSignalled = false;

    public void doWait() {
        synchronized (myMonitorObject) {
            while (!wasSignalled) {
                try {
                    myMonitorObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized (myMonitorObject) {
            wasSignalled = true;
            myMonitorObject.notifyAll();
        }
    }

    private class MyMonitorObject {
    }
}
