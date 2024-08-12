package bishi_pre.pdd_2021.q2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s1 = in.nextLine();
        String s2 = in.nextLine();
//        int n = 4;
//        String s1 = "abca";
//        String s2 = "abcd";
        int[] chs1 = new int[26];
        int[] chs2 = new int[26];
        for (int i = 0; i < n; i++) {
            chs1[s1.charAt(i) - 'a'] += 1;
            chs2[s2.charAt(i) - 'a'] += 1;
        }
        int[] diff = new int[26];
        for (int i = 0; i < 26; i++) {
            diff[i] = chs1[i] - chs2[i];
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (diff[i] == 0) {
                continue;
            }
            for(int j = i + 1; diff[i] != 0 && j < 26; j += 1){
                if (diff[j] == 0) continue;
                if ((diff[j] ^ diff[i]) < 0) {
                    int transNum = Math.min(Math.abs(diff[i]), Math.abs(diff[j]));
                    ans += (j - i) * transNum;
                    diff[i] = (diff[i] < 0 ? -1 : 1) * (Math.abs(diff[i]) - transNum);
                    diff[j] = (diff[j] < 0 ? -1 : 1) * (Math.abs(diff[j]) - transNum);
                }
            }
        }
        System.out.println(ans);
    }
}
