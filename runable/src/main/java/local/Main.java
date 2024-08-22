package local;

import java.util.Deque;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        // LinkedBlockingDeque

        Deque<String> dq = new LinkedList<>();
        final int CAPACITY = 5;

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (dq) {
                    if (dq.size() == CAPACITY) {
                        try {
                            dq.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        sleep();
                        dq.offer(UUID.randomUUID().toString().split("-")[0]);
                        printDQ(dq);
                        dq.notify();
                        try {
                            dq.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "producer").start();

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (dq) {
                    if (dq.isEmpty()) {
                        try {
                            dq.wait();
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else {
                        sleep();
                        System.out.printf("Consumer::poll -> [%s]%n", dq.poll());
                        printDQ(dq);
                        dq.notify();
                        try {
                            dq.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "consumer").start();

    }

    static void sleep(){
        try {
            TimeUnit.MILLISECONDS.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void printDQ(Deque<String> dq) {
        System.out.println(dq.stream().toList());
    }

}


