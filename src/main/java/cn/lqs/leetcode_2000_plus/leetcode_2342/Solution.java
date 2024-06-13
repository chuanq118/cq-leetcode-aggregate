package cn.lqs.leetcode_2342;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumSum(int[] nums) {
      Map<Integer, int[]> sumMap = new HashMap<>();
      for(int num : nums){
        int sum = digitSum(num);
        if (!sumMap.containsKey(sum)) {
          sumMap.put(sum, new int[]{0, 0});
        }
        if(sumMap.get(sum)[0] < num){
          sumMap.get(sum)[1] = sumMap.get(sum)[0];
          sumMap.get(sum)[0] = num;
        }else if(sumMap.get(sum)[1] < num){
          sumMap.get(sum)[1] = num;
        }
      }
      int maxRes = -1;
      for(int key : sumMap.keySet()){
        int[] arr = sumMap.get(key);
        if(arr[0] > 0 && arr[1] > 0){
          maxRes = Math.max(arr[0] + arr[1], maxRes);
        }
      }
      return maxRes;
    }

    private int digitSum(int sum){
      int n = 10;
      int res = 0;
      while(sum > 0){
        res += (sum % n);
        sum = sum / n;
      }
      return res;
    }

  public static void main(String[] args) {
    Map<Integer, int[]> map = new HashMap<>();
    int[] arr = map.putIfAbsent(1, new int[]{0, 0});
    System.out.println(Arrays.toString(map.get(1)));
    int[] arr1 = map.get(1);
    arr1[0] = 1;
    arr1[1] = 1;
    System.out.println(Arrays.toString(map.get(1)));
  }
}