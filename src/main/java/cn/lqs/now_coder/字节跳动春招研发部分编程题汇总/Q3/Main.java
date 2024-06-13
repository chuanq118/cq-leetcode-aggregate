package cn.lqs.now_coder.字节跳动春招研发部分编程题汇总.Q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int[] cards = new int[14];
//        for(int i = 0; i < 13; i++){
//            cards[i] = in.nextInt();
//        }
        int[] cards = new int[]{1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, -1};
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 9; i++){
            cards[13] = i;
            if(ok(cards)){
                sb.append(i).append(" ");
            }
        }
        if(sb.length() == 0){
            System.out.print("0");
        }else{
            System.out.print(sb.deleteCharAt(sb.length()-1));
        }
    }

    private static boolean ok(int[] cards){
        int[] buckets = new int[10];
        for(int num : cards){
            buckets[num] += 1;
            if(buckets[num] > 4){
                return false;
            }
        }
        int[] distribution = new int[5];
        for(int bucket : buckets){
            if(bucket > 0){
                distribution[bucket] += 1;
            }
        }
        if(distribution[3] == 4 && distribution[2] == 1){
            return true;
        }
        for(int i = 1; i <= 9; i++){
            if(buckets[i] >= 2){
                buckets[i] -= 2;
                int[] ints = new int[buckets.length];
                System.arraycopy(buckets, 0, ints, 0, buckets.length);
                if(isSunZi(ints)){
                    return true;
                }
                buckets[i] += 2;
            }
        }
        return false;
    }

    private static boolean isSunZi(int[] ints){
        for(int i = 1; i <= 7; i++){
            if(ints[i] >= 3){
                ints[i] -= 3;
            }
            while(ints[i] > 0){
                ints[i] -= 1;
                if(ints[i+1] == 0){
                    return false;
                }
                ints[i+1] -= 1;
                if(ints[i+2] == 0){
                    return false;
                }
                ints[i+2] -= 1;
            }
        }
        if(ints[8] != 0 && ints[8] != 3){
            return false;
        }
        if(ints[9] != 0 && ints[9] != 3){
            return false;
        }
        return true;
    }
}