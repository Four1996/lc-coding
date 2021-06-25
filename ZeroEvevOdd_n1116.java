package leetcode;

import java.awt.print.PrinterGraphics;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author panhao
 * @date 2021年04月20日 10:33 上午
 */
public class ZeroEvevOdd_n1116 {
    private int n;
    Semaphore odd=new Semaphore(0);
    Semaphore even=new Semaphore(0);
    Semaphore zero=new Semaphore(1);

    public ZeroEvevOdd_n1116(int n){
        this.n=n;
    }
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++){
            zero.acquire();
            printNumber.accept(0);
            if (i%2==0) even.release();
            else odd.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvevOdd_n1116 zeroEvevOdd_n1116=new ZeroEvevOdd_n1116(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvevOdd_n1116.zero((e)->{ System.out.print(e);});//;Lambda简化版
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvevOdd_n1116.even(e->System.out.print(e) );//Lambda表达式的更加简化版
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvevOdd_n1116.odd(System.out::print);//Lambda表达式的更加更加简化版
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
