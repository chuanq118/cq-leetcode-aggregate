package cn.lqs.now_coder.美团2024届秋招笔试第一场编程真题.Q5;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = 1, r = n;
        StringBuilder sb = new StringBuilder();
        while(l < r){
            sb.append(String.valueOf(l)).append(" ").append(String.valueOf(r)).append(" ");
            l++;
            r--;
        }
        if(l == r){
            sb.append(l);
        }else{
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.print(sb.toString());
    }
}