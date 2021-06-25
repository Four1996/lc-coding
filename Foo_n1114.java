package leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panhao
 * @date 2021年04月19日 8:27 下午
 */
public class Foo_n1114 {
    int flag=1;
    Object object=new Object();
    public Foo_n1114() {

    }


    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object){

            printFirst.run();
            flag++;
            object.notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or removeNode this line.



    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object){
            while (flag!=2)object.wait();
            printSecond.run();
            flag++;
            object.notifyAll();
        }
        // printSecond.run() outputs "second". Do not change or removeNode this line.




    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object){
            while (flag!=3) object.wait();
            printThird.run();
            object.notifyAll();
        }
        // printThird.run() outputs "third". Do not change or removeNode this line.



    }
}
