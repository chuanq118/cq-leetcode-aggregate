package bishi.jingdong_0810.q2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int X = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = in.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() <= X) {
                if ((entry.getKey() + entry.getKey()) == X) {
                    ans += ((long) entry.getValue() * entry.getValue());
                    continue;
                }
                int leftX = X - entry.getKey();
                if (map.containsKey(leftX)){
                    int n2 = map.get(leftX);
                    ans += (long) entry.getValue() * n2;
                }
            }
        }
        System.out.println(ans);
    }
}
