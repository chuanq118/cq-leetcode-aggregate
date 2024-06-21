package cn.lqs.bishi.yongyou_230723.q1;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] splits = in.nextLine().split("\\s+");
        String num1 = splits[0].trim();
        String num2 = splits[1].trim();

        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger("-"+num2);
        System.out.println(b1.add(b2));
    }
}
