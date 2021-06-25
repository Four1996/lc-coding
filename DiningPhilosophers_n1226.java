package leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panhao
 * @date 2021年04月20日 8:14 下午
 * 哲学家进餐
 */
public class DiningPhilosophers_n1226 {
    //五个叉子的信号量
    Semaphore[] semaphore=new Semaphore[5];
    //五个哲学家
    int num=5;
    public DiningPhilosophers_n1226() {
        for (int i=0;i<5;i++){
            //每只叉子只有一个
            semaphore[i]=new Semaphore(1);
        }
    }
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left=philosopher;
        int right=(philosopher+1)%num;
        while(true){
            if (semaphore[left].tryAcquire()){//先尝试获取左边的叉子
                if (semaphore[right].tryAcquire()){//成功获取左边的叉子后，在尝试获取右边的叉子
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();//释放左边叉子
                    semaphore[left].release();
                    putRightFork.run();//释放右边叉子
                    semaphore[right].release();
                    break;
                }else{
                    //拿到了左边的叉子，但没拿到右边的叉子：就释放左边的叉子。
                    semaphore[left].release();
                    //让出cpu歇一会
                    Thread.yield();
                }

            }else{
                //如果连左边的都没抢到，那就歇一会吧
                Thread.yield();
            }
        }




    }
}
