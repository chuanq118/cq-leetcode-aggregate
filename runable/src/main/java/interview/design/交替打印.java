package interview.design;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 交替打印 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition aCond = lock.newCondition();
        Condition bCond = lock.newCondition();

        new Thread(() -> {
            for (;;){
                try {
                    lock.lockInterruptibly();
                    try {
                        bCond.signal();
                        System.out.println("AAA");
                        sleep();
                        aCond.await();
                    }finally {
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (;;){
                try {
                    lock.lockInterruptibly();
                    try {
                        aCond.signal();
                        System.out.println("BBB");
                        sleep();
                        bCond.await();
                    }finally {
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "B").start();
    }

    private static void sleep() {
        // synchronized
        // synchronized ()
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
