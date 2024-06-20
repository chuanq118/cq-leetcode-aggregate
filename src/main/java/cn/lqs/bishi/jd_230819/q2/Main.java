package cn.lqs.bishi.jd_230819.q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String status = in.nextLine();
        int m = in.nextInt();
        in.nextLine();
        String[] medicines = new String[m * 2];
        for (int i = 0; i < medicines.length; i++) {
            medicines[i] = in.nextLine();
        }
        int q = in.nextInt();
        int[] eaten = new int[q];
        for (int i = 0; i < q; i++) {
            eaten[i] = in.nextInt() - 1;
        }
        for (int i = 0; i < q; i++) {
            status = heal(status, medicines[eaten[i] * 2]);
            status = ill(status, medicines[eaten[i] * 2 + 1]);
            int cnt = 0;
            for(char ch : status.toCharArray()) {
                if (ch == '1') {
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        }
    }

    private static String heal(String status, String medicine) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < status.length(); i++) {
            if (medicine.charAt(i) == '1') {
                sb.append('0');
            }else {
                sb.append(status.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String ill(String status, String medicine) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < status.length(); i++) {
            if (medicine.charAt(i) == '1') {
                sb.append('1');
            }else {
                sb.append(status.charAt(i));
            }
        }
        return sb.toString();
    }
}
