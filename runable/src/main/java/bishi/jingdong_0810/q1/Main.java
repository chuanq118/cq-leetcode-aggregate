package bishi.jingdong_0810.q1;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int[] pos = new int[]{0, 0};
        int[][] dirs = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        int way = 0;
        for (char ch : line.toCharArray()) {
            switch (ch) {
                case 'W':
                    pos[0] += dirs[way][0];
                    pos[1] += dirs[way][1];
                    break;
                case 'A':
                    way = (way - 1 + 4) % 4;
                    break;
                case 'D':
                    way = (way + 1) % 4;
                    break;
                case 'S':
                    break;
            }
        }
        System.out.println(pos[0] + " " + pos[1]);
    }
}
