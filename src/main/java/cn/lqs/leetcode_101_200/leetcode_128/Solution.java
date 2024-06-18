package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_128;

import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {
      HashMap<Integer, int[]> map = new HashMap<>();
      int groupId = 1;
      int maxLen = 0;
      for(int num : nums){
        if(map.containsKey(num)){
          int count = map.get(num)[0] + 1;
          maxLen = Math.max(maxLen, count);
          map.get(num)[0] = count;
          continue;
        }
        boolean hasSmaller = map.containsKey(num - 1);
        boolean hasBigger = map.containsKey(num + 1);
        if(hasSmaller && hasBigger){
          int[] group1 = map.get(num - 1);
          int[] group2 = map.get(num + 1);
          int count = group1[0] + group2[0] + 1;
          maxLen = Math.max(maxLen, count);
          map.get(num - 1)[0] = count;
          map.put(num, map.get(num - 1));
          int k = num + 1;
          while(map.containsKey(k)){
            map.put(k, map.get(num - 1));
            k++;
          }
        }else if(hasBigger){
          int count = map.get(num + 1)[0] + 1;
          maxLen = Math.max(maxLen, count);
          map.get(num + 1)[0] = count;
          map.put(num, map.get(num + 1));
        }else if(hasSmaller){
          int count = map.get(num - 1)[0] + 1;
          maxLen = Math.max(maxLen, count);
          map.get(num - 1)[0] = count;
          map.put(num, map.get(num - 1));
        }else{
          maxLen = Math.max(maxLen, 1);
          map.put(num, new int[]{1});
        }
      }
      return maxLen;
    }

    public static void main(String[] args) {
      System.out.println(new Solution().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
