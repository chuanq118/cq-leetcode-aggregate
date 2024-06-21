package cn.lqs.bishi.yongyou_230723.q2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // nums = [1,3,-1,-3,5,3,6,7], k = 3
        String inpStr = in.nextLine();
        int idx = 0;
        while (inpStr.charAt(idx) != '[') {
            idx += 1;
        }
        idx += 1;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>();
        while(inpStr.charAt(idx) != ']'){
            if('0' <= inpStr.charAt(idx) && inpStr.charAt(idx) <= '9'){
                sb.append(inpStr.charAt(idx));
            }else{
                if (sb.length() > 0) {
                    nums.add(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
            }
        }
        idx += 1;
        int k = Integer.parseInt(inpStr.substring(idx).split("=")[1].trim());

    }
}
