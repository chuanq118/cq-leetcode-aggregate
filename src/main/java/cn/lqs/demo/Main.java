package cn.lqs.demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 011010100000000101
        // amnbocpdefghijkqlr
        // System.out.println('m' - 'a');
        // int c0 = 99831;
        // int c1 = 100072;
        // double rate = 0.49939720764570816;
        // System.out.println(26 * rate);
        // int a0_1 = (int) Math.floor(26 * rate);
        // int a1_1 = 26 - a0_1;
        // int a0_2 = (int) Math.ceil(26 * rate);
        // int a1_2 = 26 - a0_2;
        // int maxT1 = Math.max((c0 / a0_1) + (c0 % a0_1 == 0 ? 0 : 1), (c1 / a1_1) + (c1 % a1_1 == 0 ? 0 : 1));
        // int maxT2 = Math.max((c0 / a0_2) + (c0 % a0_2 == 0 ? 0 : 1), (c1 / a1_2) + (c1 % a1_2 == 0 ? 0 : 1));
        // int a0 = maxT1 < maxT2 ? a0_1 : a0_2;
        // int a1 = maxT1 < maxT2 ? a1_1 : a1_2;


        Scanner in = new Scanner(System.in);
        String s = "01101010000000010100101110101110100001010001011010000011000101000100111000000011110110010000110001000000110011100101010011010110100101111101100100110110100111111101011000100110011100011101100101100010101010100111111110010010010011110101100110101110001000111111000000100101000010100101100000001011100100001011011110010111001110110101100001010001000111010111001100010000000001000000010110000101101101100001000100000010101010001100110100110111011011101001111000010110001000110111010111000000000111110001011010111110110001001001100100000011010000111111001111111110011001000001100010000100011101111011111000100100000111110111111010001011110010000111110100100101001111110100011011100101000110101011010000001011001110101011110000100001010111000000001001010001011000011010100011010111111101010010110000110100010100101000011011100011000100010101000011010001010111011100011001111001101100000101010110101110100001100110001100100110000100111101111110100011111101111011011000110100110110111110011101000100011101001110001011010111000101110011110101001111010100011010000101111001110010111011000001011110110000101111011001011000101001011101101111101111010011000011100001111110100001010000001000001001101100110000001110010100111000001110111110111001111101010110110110001001010001010001001110101010001101101001011111010101000101110011101100010100000111111010110101100000110001110001001001110010101010010001011001111110011101110010101111110001110101111000011000001010111010110000101110110111101000001011001011000101111111010000000010001100110000001011100011110111100110110010000011111001101111101011010001100011111011111111111011110011001011100010100011110000100000110000011000100000111011000101010100001000010110001100110111101100110111011111111001001011000001101101101101010101110101010100011011101111100001110000100101000010100000111101101100000001011001111000000110001010101100011000000110010001100010101011000110111010100101101101000111111000110110111010110100111010111001000010111000001111001101000101101101111111";
        int c0 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                c0 += 1;
            }
        }
        // int n0 = 0;
        // if (c0 == (s.length() - c0)) {
        //     n0 = 13;
        // }else{
        //     double rate = (double) c0 / s.length();
        //     if (s.startsWith("01101010000000010100101110101110100001010001011010000011000101000100111000000011110110010000110001000000110011100101010011010110100101111101100100110110100111111101011000100110011100011101100101100010101010100111111110010010010011110101100110101110001000111111000000100101000010100101100000001011100100001011011110010111001110110101100001010001000111010111001100010000000001000000010110000101101101100001000100000010101010001100110100110111011011101001111000010110001000110111010111000000000111110001011010111110110001001001100100000011010000111111001111111110011001000001100010000100011101111011111000100100000111110111111010001011110010000111110100100101001111110100011011100101000110101011010000001011001110101011110000100001010111000000001001010001011000011010100011010111111101010010110000110100010100101000011011100011000100010101000011010001010111011100011001111001101100000101010110101110100001100110001100100110000100111101111110100011111101111011011000110100110110111110011101000100011101001110001011010111000101110011110101001111010100011010000101111001110010111011000001011110110000101111011001011000101001011101101111101111010011000011100001111110100001010000001000001001101100110000001110010100111000001110111110111001111101010110110110001001010001010001001110101010001101101001011111010101000101110011101100010100000111111010110101100000110001110001001001110010101010010001011001111110011101110010101111110001110101111000011000001010111010110000101110110111101000001011001011000101111111010000000010001100110000001011100011110111100110110010000011111001101111101011010001100011111011111111111011110011001011100010100011110000100000110000011000100000111011000101010100001000010110001100110111101100110111011111111001001011000001101101101101010101110101010100011011101111100001110000100101000010100000111101101100000001011001111000000110001010101100011000000110010001100010101011000110111010100101101101000111111000110110111010110100111010111001000010111000001111001101000101101101111111")) {
        //         System.out.println("rate = " + rate);
        //         System.out.println("c0 = " + c0);
        //         System.out.println("c1 = " + (s.length() - c0));
        //     }
        //     int a1 = rate < 0.5 ? (int) Math.floor(26 * rate) : (int) Math.ceil(26 * rate);
        //     n0 = Math.min(a1, c0);
        // }

        int c1 = s.length() - c0;

        int n0 = c0 == 0 ? 0 : 26;
        if (c1 != 0 && c0 != 0){
            double rate = (double) c0 / s.length();
            int a0_1 = Math.min((int) Math.floor(26 * rate), c0);
            if (a0_1 == 0 && c0 != 0) {
                a0_1 = c0;
            }
            int a1_1 = 26 - a0_1;
            int a0_2 = Math.min((int) Math.ceil(26 * rate), c0);
            if (a0_2 == 0 && c0 != 0) {
                a0_2 = c0;
            }
            int a1_2 = 26 - a0_2;
            int maxT1 = Math.max((c0 / a0_1) + (c0 % a0_1 == 0 ? 0 : 1), (c1 / a1_1) + (c1 % a1_1 == 0 ? 0 : 1));
            int maxT2 = Math.max((c0 / a0_2) + (c0 % a0_2 == 0 ? 0 : 1), (c1 / a1_2) + (c1 % a1_2 == 0 ? 0 : 1));
            n0 = maxT1 < maxT2 ? a0_1 : a0_2;
        }

        int idx0 = 0;
        int idx1 = n0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                sb.append((char)('a' + idx0));
                idx0 += 1;
                if(idx0 == n0){
                    idx0 = 0;
                }
            }else{
                sb.append((char)('a' + idx1));
                idx1 += 1;
                if(idx1 == 26){
                    idx1 = n0;
                }
            }
        }
        System.out.println(sb.toString());
    }
}