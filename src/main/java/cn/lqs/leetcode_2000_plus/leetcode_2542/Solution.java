package cn.lqs.leetcode_2542;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // 根据第二个数组对对一个数组降序排序
        Integer[] index1 = new Integer[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            index1[i] = i;
        }
        Arrays.sort(index1, (prev, next)->{
            if (nums2[prev] == nums2[next]) {
                return nums1[next] - nums1[prev];
            }
            return nums2[next] - nums2[prev];
        });
        // 同时排序第二个数组
        Integer[] copyNums2 = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            copyNums2[i] = nums2[i];
        }
        Arrays.sort(copyNums2, (prev, next) -> next - prev);
        
        
        // 从 k - 1 处遍历第二个递减数组
        // 每次向下遍历产生两中影响
        // 1. 第二数组的最小值呈现非递增变化
        // 2. 第一数组需要新增最新索引处一个值,同时需要弹出一个之前的最小值,以保证加和尽可能大

        // 初始化最初数据
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long sum = 0L;
        long min = (long) copyNums2[k - 1];
        for(int i = 0; i < k; i++){
            long curVal = (long) nums1[index1[i]];
            pq.offer(curVal);
            sum += curVal;
        }
        long res = sum * min;
        // 向下遍历
        for(int i = k; i < nums2.length; i++){
            // 更新最小值
            min = (long) copyNums2[i];
            long toAdd = nums1[index1[i]];
            // 弹出 i 索引前的第一数组对应的最小值
            assert !pq.isEmpty();
            long preMin = pq.poll();
            sum += (toAdd - preMin);
            pq.offer(toAdd);
            if(toAdd > preMin){
                res = Math.max(res, sum * min);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k = 3;
        long result = solution.maxScore(nums1, nums2, k);
        System.out.println(result);
    }
}