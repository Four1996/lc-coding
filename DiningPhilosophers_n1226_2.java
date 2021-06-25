package leetcode;

import java.util.concurrent.Semaphore;

/**
 * @author panhao
 * @date 2021年04月20日 8:14 下午
 * 哲学家进餐
 */
public class DiningPhilosophers_n1226_2 {
    //五个叉子
    volatile boolean[] folks=new boolean[5];
    public DiningPhilosophers_n1226_2() {

    }
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left=philosopher;
        int right=(philosopher+1)%5;
        synchronized (this){
            while (folks[left]||folks[right]) this.wait();
            folks[left]=true;folks[right]=true;
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        synchronized (this){
            folks[left]=false;
            folks[right]=false;
            this.notifyAll();
        }
    }
}
