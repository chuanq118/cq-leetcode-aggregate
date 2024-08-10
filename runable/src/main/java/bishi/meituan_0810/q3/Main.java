package bishi.meituan_0810.q3;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        char[] op = new char[q];
        int[] opLen = new int[q];
        for (int i = 0; i < q; i++) {
            String line = in.nextLine();
            String[] split = line.split(" ");
            op[i] = split[0].charAt(0);
            opLen[i] = Integer.parseInt(split[1]);
        }
        ArrayList<HashMap<Integer, Integer>> ll = new ArrayList<>();
        ArrayList<HashMap<Integer, Integer>> rl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(arr[i], 1);
                ll.add(map);

                HashMap<Integer, Integer> map2 = new HashMap<>();
                map2.put(arr[arr.length - 1 - i], 1);
                rl.add(map2);
            }else{
                HashMap<Integer, Integer> preMap = ll.get(i - 1);
                HashMap<Integer, Integer> map = new HashMap<>(preMap);
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                ll.add(map);

                HashMap<Integer, Integer> preMap2 = ll.get(i - 1);
                HashMap<Integer, Integer> map2 = new HashMap<>(preMap2);
                map2.put(arr[arr.length - 1 - i], map2.getOrDefault(arr[arr.length - 1 - i], 0) + 1);
                rl.add(map2);
            }
        }
        int li = 0;
        int ri = n - 1;
        for (int i = 0; i < q; i++) {
            if (op[i] == 'L'){
                int nli = li;
                if (opLen[i] <= (n - li)) {
                    nli = li + opLen[i];
                    if (opLen[i] == 1){
                        System.out.println(1);
                    }else{
                        HashMap<Integer, Integer> map1 = ll.get(li);
                        HashMap<Integer, Integer> map2 = ll.get(nli - 1);
                        System.out.println(computeDiff(map1, map2));
                    }
                    li = (nli % n);
                }

            } else if (op[i] == 'R') {
                int nri = ri;
                if (opLen[i] <= (ri + 1)) {
                    nri = ri - opLen[i];
                    if (opLen[i] == 1){
                        System.out.println(1);
                    }else{
                        HashMap<Integer, Integer> map1 = rl.get(ri - 1);
                        HashMap<Integer, Integer> map2 = ll.get(nri + 1);
                        System.out.println(computeDiff(map1, map2));
                    }
//                    li = (nli % n);
                }
            }
        }
    }

    private static int computeDiff(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if (entry.getValue() > map1.getOrDefault(entry.getKey(), 0)) {
                res += 1;
            }
        }
        return res;
    }
}