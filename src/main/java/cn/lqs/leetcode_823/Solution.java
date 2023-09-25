package cn.lqs.leetcode_823;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int numFactoredBinaryTrees(int[] arr) {
        int result = arr.length;
        Arrays.sort(arr);
        HashMap<Integer, Integer> arrMap = new HashMap<>(arr.length);
        for (int value : arr) {
            arrMap.put(value, 0);
        }
        for(int j = 1; j < arr.length; j++){
            int comb = 0;
            int rl = (arr[j] >> 1) + (arr[j] % 2 == 0 ? 1 : 0);
            for(int i = 0; i < j; i++){
                if(arr[i] >= rl){
                    break;
                }
                if(arr[j] % arr[i] == 0){
                    int factor = arr[j] / arr[i];
                    if(arrMap.containsKey(factor)){
                        int s1 = f(arrMap, arr[i]);
                        int s2 = f(arrMap, factor);
                        int add = ((s1 != 0 && s2 == 0) || (s1 == 0 && s2 != 0)) ? s1 + s2 : s1 * s2;
                        comb += (1 + add);
                    }
                }
            }
            arrMap.put(arr[j], comb);
            result += comb;
        }
        return result;
    }

    private int f(HashMap<Integer, Integer> arrMap, int num){
        // if(arrMap.get(num) == 0){
        //     arrMap.put(num, 1);
        //     return 1;
        // }
        return arrMap.get(num);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {8,4,2};
        int result = solution.numFactoredBinaryTrees(arr);
        System.out.println(result);
    }
}