package bishi.meituan_0810.q1;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        in.nextLine();
        String password = in.nextLine();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            int k = line.length();
            if (!map.containsKey(k)) {
                map.put(k, new HashSet<>());
            }
            map.get(k).add(line);
        }
        int maxTry = 0;
        int minTry = 0;
        for (Map.Entry<Integer, HashSet<String>> entry : map.entrySet()) {
            if (entry.getKey() < password.length()) {
                minTry += entry.getValue().size();
            }
        }
        int n2 = map.getOrDefault(password.length(), new HashSet<>()).size();
        System.out.println((minTry + 1) + " " + (minTry + n2));
    }
}