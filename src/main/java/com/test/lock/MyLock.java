package com.test.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock{

    private final MySync mySync;

    public MyLock () {
        mySync = new MySync();
    }

    public void lock() {
        mySync.acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        mySync.acquireInterruptibly(1);
    }

    public boolean tryLock() {
        return mySync.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySync.tryAcquireNanos(1, time);
    }

    public void unlock() {
        mySync.release(1);
    }

    public Condition newCondition() {
        return mySync.newCondition();
    }

    private static class MySync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if(state == 0) {
                if(compareAndSetState(0, arg)) {
                    return true;
                }
            } else {
                return false;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            int state = getState();
            if(state != 0) {
                int c = state - arg;
                setState(c);
                return true;
            } else {
                return false;
            }
        }

        protected Condition newCondition() {
            return new ConditionObject();
        }
    }

}
