package com.zhw.java.study.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

// 简化的线程池
public class MyThreadPool {

    // 阻塞队列实现生产者消费者
    BlockingQueue<Runnable> workQueue;

    // 保存内部工作线程
    List<WorkerThread> threads = new ArrayList<>();

    public MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int idx = 0; idx < poolSize; idx++) {
            WorkerThread work = new WorkerThread();
            work.start();
            threads.add(work);
        }
    }

    public void execute(Runnable command) throws InterruptedException {
        workQueue.put(command);
    }

    // 工作线程负责消费任务，并执行任务
    class WorkerThread extends Thread {
        public void run() {
            //循环取任务并执行
            while (true) {
                try {
                    Runnable task = workQueue.take();
                    task.run();
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}
