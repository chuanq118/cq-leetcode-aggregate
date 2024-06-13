package cn.lqs.interview.recursion;

public class 判断数字是否在斐波那契数列 {

    public static void main(String[] args) {
        int target = 123123;
        int n = 1;
        int val = fib(n);
        while (val < target) {
            n += 1;
            val = fib(n);
            if (val == target) {
                System.out.println("ok");
                return;
            }
        }
        System.out.println("nok");
    }

    private static int fib(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
