package com.test.thread;

import java.util.concurrent.*;

public class TestThreadPool {

    public static void main(String[] args) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
        /*Future<?> submit = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        // tasks=1000 taskcost=0.1s responsetime=1s
        // tasks=1000 taskcost=2s responsetime=1s
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println(threadPoolExecutor.getActiveCount());
        }
        System.out.println("end");
    }

}
