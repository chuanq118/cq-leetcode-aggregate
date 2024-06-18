package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_149;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        Map<Double, Map<Double, HashSet<int[]>>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double k = points[j][0] == points[i][0] ? Double.POSITIVE_INFINITY : (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                double b = points[j][0] == points[i][0] ? points[i][0] : points[j][1] - k * points[j][0];
                if (!map.containsKey(k)) {
                    map.put(k, new HashMap<>());
                }
                Map<Double, HashSet<int[]>> kMap = map.get(k);
                if (!kMap.containsKey(b)) {
                    kMap.put(b, new HashSet<>());
                }
                kMap.get(b).add(points[i]);
                kMap.get(b).add(points[j]);
            }
        }
        int ans = 1;
        for (Double k1 : map.keySet()) {
            for (Double k2 : map.get(k1).keySet()) {
                // ans = Math.max(map.get(k1).get(k2).size(), ans);
                int size = map.get(k1).get(k2).size();
                if (size > ans) {
                    System.out.println("size = " + size);
                    System.out.println("k1 = " + k1);
                    System.out.println("k2 = " + k2);
                    ans = size;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // String inputText = "[[7,3],[19,19],[-16,3],[13,17],[-18,1],[-18,-17],[13,-3],[3,7],[-11,12],[7,19],[19,-12],[20,-18],[-16,-15],[-10,-15],[-16,-18],[-14,-1],[18,10],[-13,8],[7,-5],[-4,-9],[-11,2],[-9,-9],[-5,-16],[10,14],[-3,4],[1,-20],[2,16],[0,14],[-14,5],[15,-11],[3,11],[11,-10],[-1,-7],[16,7],[1,-11],[-8,-3],[1,-6],[19,7],[3,6],[-1,-2],[7,-3],[-6,-8],[7,1],[-15,12],[-17,9],[19,-9],[1,0],[9,-10],[6,20],[-12,-4],[-16,-17],[14,3],[0,-1],[-18,9],[-15,15],[-3,-15],[-5,20],[15,-14],[9,-17],[10,-14],[-7,-11],[14,9],[1,-1],[15,12],[-5,-1],[-17,-5],[15,-2],[-12,11],[19,-18],[8,7],[-5,-3],[-17,-1],[-18,13],[15,-3],[4,18],[-14,-15],[15,8],[-18,-12],[-15,19],[-9,16],[-9,14],[-12,-14],[-2,-20],[-3,-13],[10,-7],[-2,-10],[9,10],[-1,7],[-17,-6],[-15,20],[5,-17],[6,-6],[-11,-8]]";
        // String s1 = inputText.replaceAll("\\[", "{");
        // String s2 = s1.replaceAll("]", "}");
        // System.out.println(s2);
        int ans = new Solution().maxPoints(new int[][]{{7, 3}, {19, 19}, {-16, 3}, {13, 17}, {-18, 1}, {-18, -17}, {13, -3}, {3, 7}, {-11, 12}, {7, 19}, {19, -12}, {20, -18}, {-16, -15}, {-10, -15}, {-16, -18}, {-14, -1}, {18, 10}, {-13, 8}, {7, -5}, {-4, -9}, {-11, 2}, {-9, -9}, {-5, -16}, {10, 14}, {-3, 4}, {1, -20}, {2, 16}, {0, 14}, {-14, 5}, {15, -11}, {3, 11}, {11, -10}, {-1, -7}, {16, 7}, {1, -11}, {-8, -3}, {1, -6}, {19, 7}, {3, 6}, {-1, -2}, {7, -3}, {-6, -8}, {7, 1}, {-15, 12}, {-17, 9}, {19, -9}, {1, 0}, {9, -10}, {6, 20}, {-12, -4}, {-16, -17}, {14, 3}, {0, -1}, {-18, 9}, {-15, 15}, {-3, -15}, {-5, 20}, {15, -14}, {9, -17}, {10, -14}, {-7, -11}, {14, 9}, {1, -1}, {15, 12}, {-5, -1}, {-17, -5}, {15, -2}, {-12, 11}, {19, -18}, {8, 7}, {-5, -3}, {-17, -1}, {-18, 13}, {15, -3}, {4, 18}, {-14, -15}, {15, 8}, {-18, -12}, {-15, 19}, {-9, 16}, {-9, 14}, {-12, -14}, {-2, -20}, {-3, -13}, {10, -7}, {-2, -10}, {9, 10}, {-1, 7}, {-17, -6}, {-15, 20}, {5, -17}, {6, -6}, {-11, -8}}
        );
        System.out.println("ans = " + ans);
    }
}