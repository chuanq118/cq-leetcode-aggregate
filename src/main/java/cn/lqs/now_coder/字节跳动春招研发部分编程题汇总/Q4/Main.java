package cn.lqs.now_coder.字节跳动春招研发部分编程题汇总.Q4;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int exampleNum = in.nextInt();
        HashMap<String, Integer> cache = new  HashMap<>();
        for(int i = 0; i < exampleNum; i++){
            System.out.println(findMax(in, cache));
        }
    }

    private static int findMax(Scanner in, HashMap<String, Integer> cache){
        cache.clear();
        int ans = 0;
        int frameNum = in.nextInt();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < frameNum; i++){
            set.clear();
            int featureNum = in.nextInt();
            for(int j = 0; j < featureNum; j++){
                set.add(in.nextInt() + "," + in.nextInt());
            }
            for(String key : set){
                int times = cache.getOrDefault(key, 0) + 1;
                cache.put(key, times);
                ans = Math.max(times, ans);
            }
            cache.entrySet().removeIf(stringIntegerEntry -> !set.contains(stringIntegerEntry.getKey()));
        }
        return ans;
    }

    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}