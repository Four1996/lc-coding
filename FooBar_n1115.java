package leetcode;

import java.util.concurrent.Semaphore;

/**
 * @author panhao
 * @date 2021年04月20日 9:35 上午
 */
public class FooBar_n1115 {
    private int n;
    Object o = new Object();
//    private int foo_bar = 0;
//    private int bar_foo = 0;
    private boolean tag=true;
//    private Semaphore semaphore = new Semaphore(1);

    public FooBar_n1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (o){
                while (tag==false)o.wait();
                // printFoo.run() outputs "foo". Do not change or removeNode this line.
                printFoo.run();
//                foo_bar++;
//                bar_foo=0;
                tag=false;
                o.notifyAll();

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (o){
                while (tag==true) o.wait();
                // printBar.run() outputs "bar". Do not change or removeNode this line.
                printBar.run();
                tag=true;
//                bar_foo++;
//                foo_bar=0;
                o.notifyAll();
            }
        }
    }
}
