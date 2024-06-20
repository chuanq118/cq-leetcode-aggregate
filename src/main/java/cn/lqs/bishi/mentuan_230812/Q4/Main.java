import java.util.*;

/**
小美拿到了一个长度为 n 的字符串，她希望将字符串从左到右平铺成一个矩阵（先平铺第一行，然后是第二行，以此类推，矩阵有 x 行 y 列，必须保证 x * y=n，即每 y 个字符换行，共 x 行）。 

该矩阵的权值定义为这个矩阵的连通块数量。小美希望最终矩阵的权值尽可能小，你能帮小美求出这个最小权值吗？ 

注：我们定义，上下左右四个方向相邻的相同字符是连通的。
*/

/**
 * 错误分析：
 * char curCh = str.charAt((i * x) + j); 会出现 index out of range
 * 具体来说，这个问题出在：(i * x) + j 这个计算式子上。在这里，i 是行的索引，x 是行的数量，j 是列的索引。在一个正常的行、列布局中，为了得到一个元素的一维索引，我们应该使用 (i*列的数量)+j ，而不是 (i*行的数量)+j。所以正确的索引计算应该是 i * y + j。
 */
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        int ans = Integer.MAX_VALUE;
        for(int y = 1; y <= n; y += 1){
            if(n % y != 0){
                continue;
            }
            int x = n / y;
            boolean[][] flag = new boolean[x][y];
            int cnt = 0;
            for(int i = 0; i < x; i += 1){
                for(int j = 0; j < y; j += 1){
                    if(!flag[i][j]){
                        dfs(str, i, j, x, y, flag, str.charAt(i * y + j));
                        cnt += 1;
                    }
                }
            }
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }

    static int[][] dirs = new int[][]{
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    private static void dfs(String str, int i, int j, int x, int y, boolean[][] flag, char preCh){
        if(i < 0 || i >= x || j < 0 || j >= y || flag[i][j]){
            return;
        }
        char curCh = str.charAt((i * y) + j);
        if(curCh != preCh){
            return;
        }
        flag[i][j] = true;
        for(int k = 0; k < 4; k += 1){
            dfs(str, dirs[k][0] + i, dirs[k][1] + j, x, y, flag, curCh);
        }
    }

}