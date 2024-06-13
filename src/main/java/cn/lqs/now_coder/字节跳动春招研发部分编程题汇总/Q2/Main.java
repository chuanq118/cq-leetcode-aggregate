package cn.lqs.now_coder.字节跳动春招研发部分编程题汇总.Q2;

import java.util.Scanner;

public class Main {

    static int C = 99997867;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int[] nums = null;
        int distance = -1;
        int numIdx = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            if(nums == null){
                nums = new int[in.nextInt()];
            }else if(distance == -1){
                distance = in.nextInt();
            }else{
                nums[numIdx] = in.nextInt();
                numIdx++;
            }
        }
        long ans = 0;
        int l = 0, r = l + 2;
        for(; l < nums.length; l++){
            while(r < nums.length && nums[r] - nums[l] <= distance){
                r++;
            }
            long len = (long) (r - l - 2);
            if(len > 0){
                ans = (ans + ((1 + len) * len / 2)) % C;
            }
        }
        System.out.println(ans);
    }

}