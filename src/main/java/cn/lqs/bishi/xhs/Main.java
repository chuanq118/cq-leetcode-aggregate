package cn.lqs.bishi.xhs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] fav = new int[n];
        int[] cmt = new int[n];
        for (int i = 0; i < n; i++) {
            fav[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cmt[i] = in.nextInt();
        }
        Integer[] idxes = new Integer[n];
        for (int i = 0; i < n; i++) {
            idxes[i] = i;
        }
        Arrays.sort(idxes, (i1, i2) -> {
            return cmt[i2] - cmt[i1];
        });
        long favSum = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        int i = 0;
        for (; i < k; i++) {
            favSum += fav[idxes[i]];
            PQ.offer(fav[idxes[i]]);
        }
        long ans = favSum * cmt[idxes[i - 1]];
        for (; i < n; i += 1) {
            if (PQ.peek() < fav[idxes[i]]) {
                favSum -= PQ.poll();
                favSum += fav[idxes[i]];
                ans = Math.max(ans, favSum * cmt[idxes[i]]);
            }
        }
        System.out.println(ans);
    }
}
