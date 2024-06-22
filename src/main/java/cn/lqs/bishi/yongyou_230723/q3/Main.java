package cn.lqs.bishi.yongyou_230723.q3;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 原错误：
 * sb.length() == n * 2
 * 这个是错误的因为如果出现了大于 9 的数字
 * 数字的长度无法准确确定
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] inDegrees = new int[n];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int fa = in.nextInt();
            int fb = in.nextInt();
            inDegrees[fb] += 1;
            adjList.get(fa).add(fb);
        }
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                dq.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int processedCnt = 0;
        while (!dq.isEmpty()) {
            int fi = dq.poll();
            sb.append(fi).append(' ');
            processedCnt += 1;
            for (int nf : adjList.get(fi)) {
                inDegrees[nf] -= 1;
                if (inDegrees[nf] == 0) {
                    dq.offer(nf);
                }
            }
        }
        if (processedCnt == n) {
            System.out.println(sb.deleteCharAt(sb.length() - 1));
            return;
        }
        System.out.println("-1");
    }
}
