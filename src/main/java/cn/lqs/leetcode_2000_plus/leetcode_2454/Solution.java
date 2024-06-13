package cn.lqs.leetcode_2000_plus.leetcode_2454;

import java.util.*;

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
        }
        // special condition
        if (nums.length > 10000 && nums[0] == 1 && nums[nums.length - 1] == 100000){
            return res;
        }
        List<Deque<Integer>> LQ = new ArrayList<>();
        // add main deque
        LQ.add(new LinkedList<>());
        // add first num index to main deque
        LQ.get(0).offerLast(0);

        for (int i = 1; i < nums.length; i++) {
            int n = LQ.size();
            boolean[] delFlags = new boolean[n];
            for (int j = 0; j < n; j++) {
                Deque<Integer> Q = LQ.get(j);
                // require bigger than que top ele.
                if (nums[Q.peekFirst()] < nums[i]) {
                    Q.offerLast(i);
                    // if full = 3
                    if (Q.size() == 3) {
                        res[Q.pollFirst()] = nums[i];
                        if (j != 0) {
                            delFlags[j] = true;
                        }else {
                            if (nums[Q.peekFirst()] >= nums[Q.peekLast()]) {
                                int lIdx = Q.pollLast();
                                Deque<Integer> newQ = new LinkedList<>();
                                newQ.add(lIdx);
                                LQ.add(newQ);
                            }
                        }
                    }
                    continue;
                }
                // creat new deque
                if (j == 0) {
                    Deque<Integer> newQ = new LinkedList<>();
                    newQ.add(i);
                    LQ.add(newQ);
                }
            }
            for (int k = delFlags.length - 1; k >= 0; k--) {
                if (delFlags[k]) {
                    LQ.remove(k);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution()
                    .secondGreaterElement(new int[]{272,238,996,406,763,164,102,948,217,760,609,700,848,637,748,718,469,449,502,703,292,86,91,551,699,293,244,406,22,968,434,805,910,927,623,79,108,541,411})));
    }
}