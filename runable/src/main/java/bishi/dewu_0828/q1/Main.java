package bishi.dewu_0828.q1;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] nums = line.split(" ");
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int c1 = nums[0].charAt(i) - '0';
            int c2 = nums[1].charAt(i) - '0';
            if (c1 > c2) {
                ans += (c1 - c2);
            }else if(c1 < c2) {
                ans += (c1 + 10 - c2);
            }
//            int maxV = Math.max(c2, c1);
//            int minV = Math.min(c2, c1);
//            ans += Math.min(maxV - minV, minV + 10 - maxV);
        }
        System.out.println(ans);
    }
}