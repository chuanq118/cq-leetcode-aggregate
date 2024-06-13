package cn.lqs.interview.design;

import java.util.concurrent.CountDownLatch;

public class 死锁实现 {

    public static void main(String[] args) {
        Object resA = new Object();
        Object resB = new Object();
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (resA) {
                System.out.println("t1 get a");
                synchronized (resB) {
                    System.out.println("t1 get b");
                }
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (resB) {
                System.out.println("t2 get b");
                synchronized (resA) {
                    System.out.println("t2 get a");
                }
            }
        }, "t2").start();
        latch.countDown();
        latch.countDown();
    }
}
