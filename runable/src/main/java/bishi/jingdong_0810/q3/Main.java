package bishi.jingdong_0810.q3;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            int maxV = 0;
//            for (int j = 0; j < n; j++) {
//                arr[j] = in.nextInt();
//                maxV = Math.max(maxV, arr[j]);
//            }
//            int ans = 0;
//            while (maxV > 0){
//                if (maxV % 2 != 0){
//                    maxV -= 1;
//                    ans += 1;
//                }
//                while (maxV > 0 && maxV % 2 == 0){
//                    maxV /= 2;
//                    ans += 1;
//                }
//            }
//            System.out.println(ans);
//        }
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            int ans = 0;
            while (true){
                boolean flag = true;
                for (int i1 : arr) {
                    if (i1 > 1){
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                boolean isGroup = false;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] <= 1){
                        if (isGroup){
                            ans += 1;
                        }
                        isGroup = false;
                        continue;
                    }
                    isGroup = true;
                    arr[j] = arr[j] % 2 == 0 ? arr[j] / 2 : arr[j] - 1;
                }
                if (isGroup) {
                    ans += 1;
                }
            }
            System.out.println(ans + 1);
        }
    }
}
