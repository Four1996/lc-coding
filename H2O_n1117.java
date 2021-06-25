package leetcode;

/**
 * @author panhao
 * @date 2021年04月20日 2:55 下午
 */
public class H2O_n1117 {

    private int hy=0;
    Object o=new Object();
    public H2O_n1117() {
    }
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (o){
            while (hy==2){
                o.notifyAll();
                o.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or removeNode this line.
            releaseHydrogen.run();
            hy++;
            o.notifyAll();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (o){
            while (hy!=2){
                o.notifyAll();
                o.wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or removeNode this line.
            releaseOxygen.run();
            hy=0;
            o.notifyAll();
        }

    }
}
