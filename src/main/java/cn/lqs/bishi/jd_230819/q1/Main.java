package cn.lqs.bishi.jd_230819.q1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[][] mat = new char[n * 3][3];
        for (int i = 0; i < mat.length; i += 1) {
            String line = in.nextLine();
            for (int j = 0; j < 3; j++) {
                mat[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < mat.length; i += 3) {
            boolean blackWin = false;
            boolean whiteWin = false;
            if (mat[i + 1][1] == '*' && mat[i + 1][0] == 'o' && mat[i + 1][2] == 'o') {
                whiteWin = true;
            }
            if (mat[i + 1][1] == 'o' && mat[i + 1][0] == '*' && mat[i + 1][2] == '*') {
                blackWin = true;
            }
            if (mat[i + 1][1] == '*' && mat[i][1] == 'o' && mat[i + 2][1] == 'o') {
                whiteWin = true;
            }
            if (mat[i + 1][1] == 'o' && mat[i][1] == '*' && mat[i + 2][1] == '*') {
                blackWin = true;
            }
            // left mid
            if (mat[i + 1][0] == 'o' && mat[i][0] == '*' && mat[i + 2][0] == '*') {
                blackWin = true;
            }
            if (mat[i + 1][0] == '*' && mat[i][0] == 'o' && mat[i + 2][0] == 'o') {
                whiteWin = true;
            }
            // right mid
            if (mat[i + 1][2] == 'o' && mat[i][2] == '*' && mat[i + 2][2] == '*') {
                blackWin = true;
            }
            if (mat[i + 1][2] == '*' && mat[i][2] == 'o' && mat[i + 2][2] == 'o') {
                whiteWin = true;
            }
            // top mid
            if (mat[i][1] == 'o' && mat[i][0] == '*' && mat[i][2] == '*') {
                blackWin = true;
            }
            if (mat[i][1] == '*' && mat[i][0] == 'o' && mat[i][2] == 'o') {
                whiteWin = true;
            }
            // btm mid
            if (mat[i + 2][1] == 'o' && mat[i + 2][0] == '*' && mat[i + 2][2] == '*') {
                blackWin = true;
            }
            if (mat[i + 2][1] == '*' && mat[i + 2][0] == 'o' && mat[i + 2][2] == 'o') {
                whiteWin = true;
            }
            if (blackWin && !whiteWin) {
                System.out.println("kou");
                continue;
            }
            if (whiteWin && !blackWin) {
                System.out.println("yukan");
                continue;
            }
            System.out.println("draw");
        }
    }
}
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        char[][] mat = new char[n][3];
//        for(int i = 0; i < n; i += 1){
//            String line = in.nextLine();
//            for (int j = 0; j < 3; j++) {
//                mat[i][j] = line.charAt(j);
//            }
//        }
//        for(int k = 0; k < n; k += 3){
//            boolean blackWin = false;
//            boolean whiteWin = false;
//            char midChar = arr[k + 1].charAt(1);
//            char topChar = arr[k].charAt(1);
//            char ltChar = arr[k].charAt(0);
//            char rtChar = arr[k].charAt(2);
//            char lChar = arr[k + 1].charAt(0);
//            char rChar = arr[k + 1].charAt(2);
//            char blChar = arr[k].charAt(0);
//            char brChar = arr[k + 2].charAt(2);
//            char btmChar = arr[k + 2].charAt(1);
//            if (midChar == 'o' && topChar == '*' && btmChar == '*' && lChar == '*' && rChar == '*') {
//                blackWin = true;
//            }
//            if (midChar == '*' && topChar == 'o' && btmChar == 'o' && lChar == 'o' && rChar == 'o') {
//                whiteWin = true;
//            }
//            if(topChar == 'o' && ltChar == '*' && rtChar == '*' && midChar == '*'){
//                blackWin = true;
//            }
//            if(topChar == '*' && ltChar == 'o' && rtChar == 'o' && midChar == 'o'){
//                whiteWin = true;
//            }
//            if(lChar == 'o' && ltChar == '*' && blChar == '*' && midChar == '*'){
//                blackWin = true;
//            }
//            if(lChar == '*' && ltChar == 'o' && blChar == 'o' && midChar == 'o'){
//                whiteWin = true;
//            }
//            if(rChar == 'o' && rtChar == '*' && brChar == '*' && midChar == '*'){
//                blackWin = true;
//            }
//            if(rChar == '*' && rtChar == 'o' && brChar == 'o' && midChar == 'o'){
//                whiteWin = true;
//            }
//            if(btmChar == 'o' && blChar == '*' && brChar == '*' && midChar == '*'){
//                blackWin = true;
//            }
//            if(btmChar == '*' && blChar == 'o' && brChar == 'o' && midChar == 'o'){
//                whiteWin = true;
//            }
//            if(ltChar == 'o' && topChar == '*' && lChar == '*'){
//                blackWin = true;
//            }
//            if(ltChar == '*' && topChar == 'o' && lChar == 'o'){
//                whiteWin = true;
//            }
//            if(rtChar == 'o' && topChar == '*' && rChar == '*'){
//                blackWin = true;
//            }
//            if(rtChar == '*' && topChar == 'o' && rChar == 'o'){
//                whiteWin = true;
//            }
//            if(blChar == 'o' && lChar == '*' && btmChar == '*'){
//                blackWin = true;
//            }
//            if(blChar == '*' && lChar == 'o' && btmChar == 'o'){
//                whiteWin = true;
//            }
//            if(brChar == 'o' && rChar == '*' && btmChar == '*'){
//                blackWin = true;
//            }
//            if(brChar == '*' && rChar == 'o' && btmChar == 'o'){
//                whiteWin = true;
//            }
//            if(blackWin && !whiteWin){
//                System.out.println("kou");
//                continue;
//            }
//            if(whiteWin && !blackWin){
//                System.out.println("yukan");
//                continue;
//            }
//            System.out.println("draw");
//        }
//    }
