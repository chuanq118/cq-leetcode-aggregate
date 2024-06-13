package cn.lqs.leetcode_1000_2000.leetcode_1017;

class Solution {
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            int left = n % (-2);
            if (left == 0) {
                res.insert(0, '0');
            }else {
                res.insert(0, '1');
            }
            n -= (left == 0 ? 0 : 1);
            n /= (-2);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new Solution().baseNeg2(6);

        // 5 / 2 -> 2, 1
        // 2 / 2 -> 1, 0
        // 1 / 2 -> 0, 1
        // 101
        // 7 / 2 -> 3, 1
        // 3 / 2 -> 1, 1
        // 1 / 2 -> 0, 1
        // 111 1 + 2 + 4

        // 3 / -2 -> -1, 1
        // -1 / -2 -> 0, -1
        // 0 / -2 -> 0, 0
        // 11

        // 4 / -2 -> -2, 0
        // -2 / -2 -> 1, 0
        // 1 / -2 -> 0, 1
        // 100

        // 2 / -2 -> -1, 0
        // -1 / -2 -> 0, -1
        // 110

        System.out.println(2 / -2);
        System.out.println(2 % -2);

        System.out.println("--------------");

        System.out.println(-2 % (-2));
        System.out.println(-1 % (-2));
        System.out.println(0 % (-2));
        System.out.println(1 % (-2));
        System.out.println(2 % (-2));

        System.out.println("----------------");

        System.out.println(3 / (-2));
        System.out.println(3 % (-2));
        System.out.println(-1 / -2);
        System.out.println(-1 % -2);
        System.out.println(0 / -2);
        System.out.println(0 % -2);
    }
}