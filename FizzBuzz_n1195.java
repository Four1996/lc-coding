package leetcode;

import java.util.concurrent.Semaphore;

import java.util.function.IntConsumer;

/**
 * @author panhao
 * @date 2021年04月20日 4:37 下午
 */
public class FizzBuzz_n1195 {
    private int n;
     Semaphore f = new Semaphore(0);
     Semaphore b = new Semaphore(0);
     Semaphore fb = new Semaphore(0);
     Semaphore num = new Semaphore(1);
    public FizzBuzz_n1195(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".被3整除
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i=3;i<=n;i+=3){
            if (i % 3 == 0 && i % 5 != 0){
                f.acquire();
                printFizz.run();
                num.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".被5整除
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i=5;i<=n;i+=5){
            if (i % 3 != 0 && i % 5 == 0){
                b.acquire();
                printBuzz.run();
                num.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".被3和5整除
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i=15;i<=n;i+=15){
            if (i % 3 == 0 && i % 5 == 0){
                fb.acquire();
                printFizzBuzz.run();
                num.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++){
            num.acquire();
            if (i % 3 == 0 && i % 5 != 0) {
                f.release();
            } else if (i % 3 != 0 && i % 5 == 0) {
                b.release();
            } else if (i % 3 == 0 && i % 5 == 0) {
                fb.release();
            } else {
                printNumber.accept(i);
                num.release();
            }
        }


    }

    public static void main(String[] args) {
        FizzBuzz_n1195 fizzBuzz_n1195 = new FizzBuzz_n1195(30);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz_n1195.number((e) -> {
                        System.out.print(e);
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz_n1195.fizz(() -> System.out.print("fizz"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz_n1195.buzz(() -> System.out.print("buzz"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz_n1195.fizzbuzz(() -> System.out.print("fizzbuzz"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
