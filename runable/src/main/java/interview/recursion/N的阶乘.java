package interview.recursion;

public class N的阶乘 {
    public static void main(String[] args) {
        System.out.println(dfs(10));
    }

    private static int dfs(int n) {
        if (n == 1) {
            return 1;
        }
        return n * dfs(n - 1);
    }
}
