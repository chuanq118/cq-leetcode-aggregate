package interview.design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class 生产者_消费者_线程通信 {
    private static final int MAX_SIZE = 10;
    private static final Queue<String> QUE = new LinkedList<>();

    static class Producer extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (QUE) {
                    while (QUE.size() == MAX_SIZE) {
                        try {
                            System.out.println("队列已满");
                            // wait 会释放锁
                            QUE.wait();
                        } catch (InterruptedException e) {
                            System.out.println("已满队列被唤醒");
                        }
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String key = UUID.randomUUID().toString();
                    QUE.offer(key);
                    System.out.println("队列添加 Key: " + key);
                    QUE.notifyAll();
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (QUE) {
                    while (QUE.size() == 0) {
                        System.out.println("队列为空");
                        try {
                            QUE.wait();
                        } catch (InterruptedException e) {
                            System.out.println("空队列被唤醒");
                        }
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("队列取出: " + QUE.poll());
                    QUE.notifyAll();
                }
            }
        }
    }


    public static void main(String[] args) {
        new Producer().start();
        new Consumer().start();
    }
}
