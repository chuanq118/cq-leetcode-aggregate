package cn.lqs.now_coder.美团2024届秋招笔试第一场编程真题.Q1;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigDecimal s1 = new BigDecimal("0.00");
        BigDecimal s2 = new BigDecimal("0.00");
        BigDecimal a, b;
        for(int i = 0; i < n; i++){
            double v1 = in.nextDouble();
            double v2 = in.nextDouble();
            if(v1 < 0 || v2 <= 0.0 || v1 - v2 < 0){
                System.out.print("error");
                return;
            }
            a = BigDecimal.valueOf(v1);
            b = BigDecimal.valueOf(v2);
            s1 = s1.add(a);
            s2 = s2.add(b);
        }
        a = BigDecimal.valueOf(in.nextDouble());
        b = BigDecimal.valueOf(in.nextDouble());
        if(a.compareTo(BigDecimal.valueOf(0.0)) <= 0 || b.compareTo(BigDecimal.valueOf(0.0)) <= 0 || a.compareTo(b) < 0){
            System.out.print("error");
            return;
        }
        if(s1.compareTo(a) >= 0){
            if(s1.compareTo(b) <= 0){
                System.out.print("error");
                return;
            }
            s1 = s1.subtract(b);
        }
        BigDecimal minV = s1.compareTo(s2) < 0 ? s1 : s2;
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println(df.format(minV));
    }
}