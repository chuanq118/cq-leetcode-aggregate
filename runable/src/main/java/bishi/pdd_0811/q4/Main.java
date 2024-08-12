package bishi.pdd_0811.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static boolean isSout = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] != -1){
                list.add(arr[i]);
            }
        }
        list.sort((n1, n2) -> n1 - n2);
        int[] arr_ = new int[n];
        for (int i = 0; i < n; i++) {
            arr_[i] = -1;
        }
        dfs(arr, arr_, new boolean[list.size()], new ArrayList<>(), list);
    }

    private static void dfs(int[] arr, int[] arr_,
                            boolean[] visited,
                            ArrayList<Integer> record,
                            ArrayList<Integer> list){
        if (isSout) return;
        boolean allVisited = true;
        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) continue;
            if (isSout) return;
            visited[i] = true;
            allVisited = false;
            int num = list.get(i);
            int n = arr.length;
            int idx = num % n;
            while (arr_[idx] != -1){
                idx = (idx + 1) % n;
            }
            arr_[idx] = num;
            if (arr[idx] == arr_[idx]){
                record.add(num);
                dfs(arr, arr_, visited, record, list);
                record.remove(record.size() - 1);
            }
            if (isSout) return;
            arr_[idx] = -1;
            visited[i] = false;
        }
        if (isSout) return;
        if (allVisited) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : record) {
                sb.append(i + " ");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            System.out.println(sb.toString());
            isSout = true;
        }
    }
}