package cn.lqs.competition;

import java.util.*;

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int remove1 = 0, remove2 = 0;
        int maxRemove1 = nums1.length / 2, maxRemove2 = nums2.length / 2;
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> countMap1 = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();
        for (int num : nums1){
            countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2){
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> countMap.get(o2) - countMap.get(o1));
        heap.addAll(countMap.keySet());

        Integer polled = null;
        while ((polled = heap.poll()) != null) {
            int pIdx = polled;
            if (remove1 < maxRemove1 && remove2 < maxRemove2){
                if (countMap1.get(pIdx) >= countMap2.get(pIdx)){
                    countMap1.put(pIdx, countMap1.get(pIdx) - 1);
                    remove1++;
                }else {
                    countMap2.put(pIdx, countMap2.get(pIdx) - 1);
                    remove2++;
                }
            }else if (remove1 == maxRemove1){
                if (countMap2.get(pIdx) > 0) {
                    countMap2.put(pIdx, countMap2.get(pIdx) - 1);
                    remove2++;
                }

            }else if (remove2 == maxRemove2){
                if (countMap1.get(pIdx) > 0) {
                    countMap1.put(pIdx, countMap1.get(pIdx) - 1);
                    remove1++;
                }
            }
            int left = countMap.get(pIdx) - 1;
            if (left > 0) {
                countMap.put(pIdx, left);
                heap.offer(pIdx);
            }
        }
        int ans = 0;
        for (Integer i : countMap.keySet()) {
            if (countMap.get(i) > 0) {
                ans++;
            }
        }
        return ans;
    }
}