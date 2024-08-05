package cn.lqs.bishi.mhy240803.q3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//// 注意类名必须为 Main, 不要有任何 package xxx 信息
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        for (int t = 0; t < T; t += 1) {
//            int n = in.nextInt();
//            int x = in.nextInt();
//            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//            for (int i = 0; i <= n; i++) {
//                adj.add(new ArrayList<>());
//            }
//            for (int i = 0; i < n; i++) {
//                int u = in.nextInt();
//                int v = in.nextInt();
//                adj.get(u).add(v);
//                adj.get(v).add(u);
//            }
//            Deque<Integer> dq = new LinkedList<>();
//            for (int i = 1; i <= n; i++) {
//                if (adj.get(i).size() == 1) {
//                    dq.offerLast(i);
//                }
//            }
//            boolean isXDel = false;
//            int counterBeforeX = 0;
//            while (!dq.isEmpty()) {
//                int levelN = dq.size();
//                for (int k = 0; k < levelN; k++) {
//                    int node = dq.pollFirst();
//                    if (node == x) {
//                        isXDel = true;
//                        break;
//                    }
//                    int neighborNode = adj.get(node).get(0);
//                    adj.get(neighborNode).remove((Integer) node);
//                    adj.get(node).clear();
//                    if (adj.get(neighborNode).size() == 1) {
//                        dq.offerLast(neighborNode);
//                    }
//                }
//                if (isXDel) {
//                    break;
//                }
//                counterBeforeX += levelN;
//            }
//            if (!isXDel) {
//                System.out.println("Draw");
//                continue;
//            } else {
//                System.out.println(counterBeforeX);
//                if (counterBeforeX == 0) {
//                    System.out.println("Xiaoyo");
//                } else if (((counterBeforeX - 1) % 2) == 0) {
//                    System.out.println("Pyrmont");
//                } else {
//                    System.out.println("Xiaoyo");
//                }
//            }
//
//        }
//    }
//}


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t += 1) {
            int n = in.nextInt();
            int x = in.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Deque<Integer> dq = new LinkedList<>();
            boolean isXOuter = false;
            for (int i = 1; i <= n; i++) {
                if (adj.get(i).size() == 1) {
                    if (i == x) {
                        isXOuter = true;
                    }
                    dq.offerLast(i);
                }
            }
            if (isXOuter){
                System.out.println("Xiaoyo");
                continue;
            }
            boolean isXDel = false;
            int counterBeforeX = 0;
            while (!dq.isEmpty()) {
                int levelN = dq.size();
                for (int k = 0; k < levelN; k++) {
                    int node = dq.pollFirst();
                    if (node == x) {
                        isXDel = true;
                        continue;
                    }
                    counterBeforeX += 1;
                    int neighborNode = adj.get(node).get(0);
                    adj.get(neighborNode).remove((Integer) node);
                    adj.get(node).clear();
                    if (adj.get(neighborNode).size() == 1) {
                        dq.offerLast(neighborNode);
                    }
                }
            }
            if (!isXDel) {
                System.out.println("Draw");
            } else {
//                System.out.println(counterBeforeX);
                if ((counterBeforeX % 2) == 0) {
                    System.out.println("Xiaoyo");
                } else {
                    System.out.println("Pyrmont");
                }
            }

        }
    }
}
