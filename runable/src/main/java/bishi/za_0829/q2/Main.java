package bishi.za_0829.q2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[] chs = in.nextLine().toCharArray();
        int[] cnt = new int[26];
        int[] preIdx = new int[26];
        for (int i = 0; i < 26; i++) {
            preIdx[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int idx = chs[i] - 'a';
            cnt[idx] += (i - preIdx[idx]);
            preIdx[idx] = i;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append(cnt[j]).append(' ');
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
//        int[][] stat = new int[n][26];
//        stat[0][chs[0]-'a'] = 1;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < 26; j++) {
//                stat[i][j] = stat[i - 1][j];
//            }
//            stat[i][chs[i]-'a'] += 1;
//        }
//        for (int i = 0; i < n; i++) {
//            int[] cnt = new int[26];
//            for (int k = 0; k < 26; k++) {
//                if (stat[i][k] > 0) {
//                    cnt[k] += 1;
//                }
//            }
//            for (int j = 1; j <= i; j += 1) {
//                for (int k = 0; k < 26; k++) {
//                    if (stat[i][k] > stat[j-1][k]) {
//                        cnt[k] += 1;
//                    }
//                }
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < 26; j++) {
//                sb.append(cnt[j]).append(' ');
//            }
//            sb.setLength(sb.length() - 1);
//            System.out.println(sb);
//        }
    }
}