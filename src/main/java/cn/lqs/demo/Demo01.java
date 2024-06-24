package cn.lqs.demo;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Deque<Integer> dq1 = new LinkedList<>();
        dq1.push(2);
        System.out.println(dq1.peek());
        dq1.push(5);
        System.out.println(dq1.peek());
        dq1.push(6);
        System.out.println(dq1.peek());


        HashMap<Integer, Object> map = new HashMap<>();
        map.remove(21);
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        // PQ.offer()
        // PQ.poll()
//        PQ.peek()
//        PQ.clear();

        StringBuilder sb = new StringBuilder();
        sb.insert(0, 1);
        sb.insert(0, 2);
        sb.insert(0, 3);
        System.out.println(sb.toString());

        // ThreadLocal
        char res = 'a' - 32;
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Arrays.sort(mat, (prev, next) -> {
            return 0;
        });
    }
}
