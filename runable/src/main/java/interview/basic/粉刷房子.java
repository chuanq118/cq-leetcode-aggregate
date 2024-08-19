package interview.basic;

public class 粉刷房子 {

    public static void main(String[] args) {
        int[][] costs = new int[][]{
                {17, 2, 17}, {16, 16, 5}, {14, 3, 19}
        };
        int v1 = dfs(costs.length - 1, 0, costs);
        int v2 = dfs(costs.length - 1, 1, costs);
        int v3 = dfs(costs.length - 1, 2, costs);
        System.out.println(Math.min(v1, Math.min(v2, v3)));
    }

    // dfs(i, 0) = min(dfs(i - 1, 1), dfs(i - 1, 2))
    // dfs
    private static int dfs(int i, int color, int[][] costs) {
        if (i < 0){
            return 0;
            // return Integer.MAX_VALUE;
        }
        int[] oc = new int[2];
        int idx = 0;
        for (int j = 0; j < 3; j++) {
            if (j != color) {
                oc[idx] = j;
                idx += 1;
            }
        }
        return costs[i][color] + Math.min(dfs(i - 1, oc[0], costs), dfs(i - 1, oc[1], costs));
    }
}
