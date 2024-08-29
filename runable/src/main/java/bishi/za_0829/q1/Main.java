package bishi.za_0829.q1;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            char[][] mat = new char[n][m];
            for (int j = 0; j < n; j++) {
                mat[j] = in.nextLine().toCharArray();
            }
            boolean ok = true;
            for (int x = 0; x < n - 1; x += 1) {
                if (!ok) {
                    break;
                }
                for (int y = 0; y < m - 1; y++) {
                    if (mat[x][y] == '*') {
                        boolean ok1 = mat[x + 1][y] == '*' && mat[x][y + 1] == '*' && mat[x + 1][y + 1] == '*';
                        boolean ok2 = true;
                        if (x + 2 < n) {
                            ok2 = (mat[x + 2][y] == '.' && mat[x + 2][y + 1] == '.');
                        }
                        if (ok2 && y + 2 < m) {
                            ok2 = (mat[x][y + 2] == '.' && mat[x + 1][y + 2] == '.');
                        }
                        if (ok2 && x + 2 < n && y + 2 < m) {
                            ok2 = mat[x + 2][y + 2] == '.';
                        }
                        if (!ok1 || !ok2) {
                            ok = false;
                            break;
                        }
                        mat[x + 1][y] = '.';
                        mat[x + 1][y + 1] = '.';
                        mat[x][y + 1] = '.';
                    }
                }
            }
            System.out.println(ok ? "Yes" : "No");
        }
    }
}