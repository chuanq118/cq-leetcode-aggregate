package cn.lqs.bishi.huawei_230823.q1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int am = in.nextInt();
        boolean[] aFlags =  new boolean[5];
        for (int i = 0; i < am; i++) {
            aFlags[in.nextInt()] = true;
        }
        int n = in.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long id = in.nextLong();
            int pn = in.nextInt();
            boolean connect = false;
            for (int j = 0; j < pn; j++) {
                if (aFlags[in.nextInt()]) {
                    connect = true;
                }
            }
            if (connect){
                pq.offer(id);
            }
        }
        System.out.println(pq.size());
        while (!pq.isEmpty()){
            System.out.print(pq.poll());
            System.out.print(" ");
        }
    }
}
