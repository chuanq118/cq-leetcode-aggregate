package cn.lqs.now_coder.字节跳动春招研发部分编程题汇总.Q1;

import java.util.Scanner;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        in.nextInt();
        while (in.hasNext()) { // 注意 while 处理多个 case
            String line = in.nextLine();
            if(line.trim().length() > 0){
                System.out.println(fix(line));
            }
        }
    }

    private static String fix(String input){
        sb.setLength(0);
        for(int i = 0; i < input.length(); i++){
            if (sb.length() < 2){
                sb.append(input.charAt(i));
                continue;
            }
            if (input.charAt(i) == sb.charAt(sb.length()-1) && input.charAt(i) == sb.charAt(sb.length() - 2)){
                continue;
            }
            if(sb.length() > 2 && input.charAt(i) == sb.charAt(sb.length()-1) && sb.charAt(sb.length()-2) == sb.charAt(sb.length()-3)){
                continue;
            }
            sb.append(input.charAt(i));
        }
        return sb.toString().trim();
    }
}