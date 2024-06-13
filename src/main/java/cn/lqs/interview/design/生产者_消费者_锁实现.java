package cn.lqs.interview.design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 生产者_消费者_锁实现 {

    private final static int MAX_SIZE = 10;
    private static Queue<String> Q = new LinkedList<>();
    private static Lock lock = new ReentrantLock();
    private static Condition pdcCond = lock.newCondition();
    private static Condition csmCond = lock.newCondition();

    static class Producer extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    // 这个方法可以使线程在等待获取锁的过程中响应中断
                    lock.lockInterruptibly();
                    System.out.println("生产者获取锁");
                    try {
                        while (Q.size() == MAX_SIZE) {
                            System.out.println("队列已满");
                            pdcCond.await();
                        }
                        randomSleep();
                        String key = UUID.randomUUID().toString();
                        Q.offer(key);
                        System.out.println("队列添加: " + key);
                        csmCond.signal();
                    }finally {
                        System.out.println("生产者释放锁");
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    System.out.println("生产者线程被中断");
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    // 这个方法可以使线程在等待获取锁的过程中响应中断
                    lock.lockInterruptibly();
                    System.out.println("消费者获取锁");
                    try {
                        while (Q.size() == 0) {
                            System.out.println("队列为空");
                            csmCond.await();
                        }
                        randomSleep();
                        System.out.println("队列移除: " + Q.poll());
                        pdcCond.signal();
                    }finally {
                        System.out.println("消费者释放锁");
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    System.out.println("消费者线程被中断");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Consumer().start();
        new Producer().start();
    }

    private static void randomSleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
