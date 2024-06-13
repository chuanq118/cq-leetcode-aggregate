package cn.lqs.demo;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    static Deque<Integer> dq = new LinkedList<>();
    public static void main(String[] args) {
        dq.offer(1);
        dq.offer(2);
        dq.offer(3);
        System.out.println(dq.peek());
        // System.out.println(dq.top());
        System.out.println(dq.peekLast());
        // dq.size()
        // printDq();
        // System.out.println(dq.peek());
        // System.out.println(dq.pop());

        dq.clear();

        // StringBuilder sb = new StringBuilder();
        // sb.charAt()

        // dq.push(1);
        // dq.push(2);
        // dq.push(3);
        dq.push(1);
        dq.push(2);
        dq.push(3);
        // System.out.println(dq.peek());

        // dq.isEmpty()


    }

    private static void printDq() {
        for (Integer integer : dq) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

}
