package cn.lqs.bishi.meituan.comp_230812.q1;


import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n + 1];
        for(int i = 0; i < nums.length; i += 1){
            nums[in.nextInt()] = i;
        }
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(Math.abs(nums[x] - nums[y]) == 1 ? "Yes" : "No");        
    }
}