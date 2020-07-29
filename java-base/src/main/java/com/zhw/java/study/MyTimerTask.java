package com.zhw.java.study;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

    public void run() {
        System.out.printf("这是一个 Task,执行时间：%s \n", LocalDateTime.now());
    }
}

