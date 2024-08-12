package bishi.pdd_0811.q2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static int maxV = 1999999999;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = in.nextInt();
            jobs[i][1] = in.nextInt();
        }
//        int n = 3;
//        int[][] jobs = new int[][]{
//                {1, 5},
//                {5, 1},
//                {7, 3}
//        };
        Arrays.sort(jobs, (pv, nxt) -> pv[0] - nxt[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            if(jobs[i1][1] >= jobs[i2][1]) {
                return 1;
            } else if (jobs[i1][1] < jobs[i2][1]) {
                return  -1;
            }
            return 0;
        });
        long ans = 0;
        int workIn = 0;
        long curT = jobs[0][0];
        pq.offer(0);
        for (int i = 1; i < n; i++) {
            int timeDiff = jobs[i][0] - jobs[i - 1][0];
//            System.out.println( workIn + "#"+ curT);
            if (timeDiff >= jobs[workIn][1]){
//                System.out.println("workin -1" + jobs[workIn][1]);
                ans += (jobs[workIn][1] + curT - jobs[workIn][0]);
                int leftT = timeDiff - jobs[workIn][1];
                curT = jobs[workIn][1] + curT;
                jobs[workIn][1] = maxV;
                pq.remove((Integer) workIn);
                pq.offer(workIn);
                int topW = pq.peek();
                while (leftT >= jobs[topW][1]) {
                    curT = (long) jobs[topW][1] + curT;
                    ans += (curT - jobs[topW][0]);
                    leftT -= jobs[topW][1];
                    jobs[topW][1] = maxV;
                    pq.remove((Integer) topW);
                    pq.offer(topW);
                    topW = pq.peek();
                }
                topW = pq.peek();
                if (jobs[topW][1] < maxV){
                    jobs[topW][1] -= leftT;
                    pq.remove((Integer) topW);
                    pq.offer(topW);
                }
//                System.out.println("ans = " + ans);

            }else {
                jobs[workIn][1] = jobs[workIn][1] - timeDiff;
                pq.remove((Integer) workIn);
                pq.offer(workIn);
            }
            pq.offer(i);
            curT = jobs[i][0];
            workIn = pq.peek();
        }
        int topW = pq.peek();
        while (jobs[topW][1] < maxV) {
//            System.out.println(pq.peek()+ "#" +curT);
            ans += ((long) jobs[topW][1] + (long)curT - (long) jobs[topW][0]);
//            System.out.println("ans = " + ans);
            curT = (long)jobs[topW][1] + curT;
            jobs[topW][1] = maxV;
            pq.remove((Integer) topW);
            pq.offer(topW);
        }
        System.out.println(ans);
    }
}
