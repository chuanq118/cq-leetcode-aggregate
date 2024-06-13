package cn.lqs.demo;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Demo01 {
    public static void main(String[] args) {
        Deque<Integer> dq1 = new LinkedList<>();
        dq1.push(2);
        System.out.println(dq1.peek());
        dq1.push(5);
        System.out.println(dq1.peek());
        dq1.push(6);
        System.out.println(dq1.peek());
        // dq1.peekLast()
        // dq1.push();
        // dq1.pop()
        // dq1.peek()
        // dq1.peekLast()
        // dq1.isEmpty()
        // dq1.clear();
        HashMap<Integer, Object> map = new HashMap<>();
        map.remove(21);
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        // PQ.offer()
        // PQ.poll()

        StringBuilder sb = new StringBuilder();
        sb.insert(0, 1);
        sb.insert(0, 2);
        sb.insert(0, 3);
        System.out.println(sb.toString());

        // ThreadLocal
        char res = 'a' - 32;
    }
}
