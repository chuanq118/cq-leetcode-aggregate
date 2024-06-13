package cn.lqs.now_coder.美团2024届秋招笔试第一场编程真题.Q2;

import java.util.Scanner;

import java.util.HashSet;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // nextInt不会读取任何后面的换行符或者空格,因此需要消耗掉数字后紧跟的换行符
        in.nextLine();
        String s = in.nextLine();
        String t = in.nextLine();

        boolean[] unMathCharsOfS = new boolean[26];
        HashSet<String> pairs = new HashSet<>();
        int ans = 0;
        boolean find1 = false;
        boolean find2 = false;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == t.charAt(i)){
                ans += 1;
            }else{
                if(find2){
                    continue;
                }
                if(!find1){
                    unMathCharsOfS[s.charAt(i)-'a'] = true;
                    if(unMathCharsOfS[t.charAt(i)-'a']){
                        find1 = true;
                    }
                }
                pairs.add(s.charAt(i) + "" + t.charAt(i));
                if(pairs.contains(t.charAt(i) + "" + s.charAt(i))){
                    find2 = true;
                }
            }
        }
        if(find2){
            System.out.print(ans + 2);
            return;
        }
        if(find1){
            System.out.print(ans + 1);
            return;
        }
        System.out.print(ans);
    }
}