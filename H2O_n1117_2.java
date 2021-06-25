package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panhao
 * @date 2021年04月20日 2:55 下午
 */
public class H2O_n1117_2 {

    private volatile int hnum=0;
    Lock lock=new ReentrantLock();
    Condition O=lock.newCondition();
    Condition H=lock.newCondition();
    public H2O_n1117_2() {
    }
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while (hnum==2){
                O.signal();
                H.await();
            }
            releaseHydrogen.run();
            hnum++;
            if (hnum==2){
                O.signal();
            }
        }finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while (hnum!=2){
                O.await();
            }
            releaseOxygen.run();
            hnum=0;
            H.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
