package cn.lqs.interview.recursion;

public class 汉诺塔 {

    public static void main(String[] args) {
        int nDisks = 3; // 例如，我们要移动3个盘子
        // doTowers(nDisks, 'A', 'B', 'C');
        move(nDisks, 'A', 'B', 'C');
    }

    // src: source
    // dst: destination
    private static void move(int n, char src, char dst, char mid) {
        if (n == 1) {
            System.out.println("move from " + src + " to " + dst);
            return;
        }
        move(n - 1, src, mid, dst);
        move(1, src, dst, mid);
        move(n - 1, mid, dst, src);
    }

    // 移动盘子
    // topN:移动的盘子数
    // from:起始塔座
    // inter:中间塔座
    // to:目标塔座
    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("盘子 1，从" + from + "塔座到" + to + "塔座");
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("盘子 " + topN + "，从" + from + "塔座到" + to + "塔座");
            doTowers(topN - 1, inter, from, to);
        }
    }

}
