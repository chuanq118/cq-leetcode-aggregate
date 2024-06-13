package cn.lqs.other;

import java.util.Arrays;
import java.util.Scanner;

/*

一支N个士兵的军队正在趁夜色逃亡，途中遇到一条湍急的大河。
敌军在T的时长后到达河面，没到过对岸的士兵都会被消灭。
现在军队只找到了1只小船，这船最多能同时坐上2个士兵。

    当1个士兵划船过河，用时为 a[i]；0 <= i < N
    当2个士兵坐船同时划船过河时，用时为max(a[j],a[i])两士兵中用时最长的。
    当2个士兵坐船1个士兵划船时，用时为 a[i]*10；a[i]为划船士兵用时。
    如果士兵下河游泳，则会被湍急水流直接带走，算作死亡。

请帮忙给出一种解决方案，保证存活的士兵最多，且过河用时最短。

原题 [https://www.luogu.com.cn/problem/P1809]

有一个大晴天，Oliver 与同学们一共
N 人出游，他们走到一条河的东岸边，想要过河到西岸。而东岸边有一条小船。

船太小了，一次只能乘坐两人。每个人都有一个渡河时间
T，船划到对岸的时间等于船上渡河时间较长的人所用时间。

现在已知
N 个人的渡河时间
T，Oliver 想要你告诉他，他们最少要花费多少时间，才能使所有人都过河。

注意，只有船在东岸（西岸）的人才能坐上船划到对岸。

 */
public class 华为0D_士兵过河 {

    private static int minT(int[] costs) {
        if (costs.length == 1) {
            return costs[0];
        }
        Arrays.sort(costs);
        int totalCost = 0;
        int endIdx = costs.length - 1;
        while (endIdx > 2) {
            int cost1 = costs[endIdx] + costs[endIdx - 1] + 2 * costs[0];
            int cost2 = costs[endIdx] + 2 * costs[1] + costs[0];
            totalCost += Math.min(cost1, cost2);
            endIdx -= 2;
        }
        if (endIdx == 2) {
            totalCost += (costs[0] + costs[1] + costs[2]);
        } else if (endIdx == 1) {
            totalCost += Math.max(costs[0], costs[1]);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // scan.useDelimiter("\n");
        int num = scan.nextInt(10);
        int[] costs = new int[num];
        for (int i = 0; i < num; i++) {
            costs[i] = scan.nextInt(10);
        }
        System.out.printf("%d\n", minT(costs));
    }
}
