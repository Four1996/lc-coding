package leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panhao
 * @date 2021年04月20日 2:55 下午
 */
public class H2O_n1117_3 {

    private Semaphore O=new Semaphore(0);
    private Semaphore H=new Semaphore(2);
    public H2O_n1117_3() {
    }
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        H.acquire();
        releaseHydrogen.run();
        O.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        O.acquire(2);
        releaseOxygen.run();
        H.release(2);
    }
}
