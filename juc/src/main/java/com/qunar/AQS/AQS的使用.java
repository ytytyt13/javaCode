package com.qunar.AQS;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author yang
 * 2021年01月22日 18:01:00
 *
 * AQS定义了一套多线程访问共享资源的同步器框架
 * AQS 中state的访问方式
 * getState()
 * setState()
 * compareAndSetState()
 *
 * AQS重写的方法
 * tryAcquire(int arg)   独占式获取同步状态
 * tryRelease(int arg)   独占式释放同步状态
 *
 * tryAcquireShared(int arg)
 * tryRealseShared(int arg)
 * isHeldExclusively() 当前线程是否被独占式占用
 *
 *AQS已经完成的方法
 *acquire
 * 1 public final void acquire(int arg) {
 * 2     if (!tryAcquire(arg) &&
 * 3         acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
 * 4         selfInterrupt();
 * 5 }
 *release
 * 1 public final boolean release(int arg) {
 * 2     if (tryRelease(arg)) {
 * 3         Node h = head;//找到头结点
 * 4         if (h != null && h.waitStatus != 0)
 * 5             unparkSuccessor(h);//唤醒等待队列里的下一个线程
 * 6         return true;
 * 7     }
 * 8     return false;
 * 9 }
 *
 */
public class AQS的使用 implements Lock, Serializable {

    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // Acquires the lock if state is zero
        @Override
        public boolean tryAcquire(int acquires) {
            assert acquires == 1; // Otherwise unused
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // Releases the lock by setting state to zero
        @Override
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // Provides a Condition
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    // The sync object does all the hard work. We just forward to it.
    private final Sync sync = new Sync();
    //使用同步器的模板方法实现自己的同步语义
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock(long timeout, TimeUnit unit)
            throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
}
