package cn.lqs.leetcode_2731;

import java.util.Arrays;

class Solution {
    private Integer[] gIndexes;
    public int sumDistance(int[] nums, String s, int d) {
        Integer[] indexes = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }
        Arrays.sort(indexes, (prev, next)->{
            return nums[prev] - nums[next];
        });
        gIndexes = indexes;
        char[] chs = s.toCharArray();
        boolean[] directions = new boolean[s.length()];
        for(int i = 0; i < directions.length; i++){
            directions[i] = chs[i] == 'R';
        }
        for(int i = 0; i < d; i++){
            checkAndMove(nums, directions);
        }
        return Math.abs((int) (computeTotalDistance(nums) % 1000000007));
    }

    private void checkAndMove(int[] nums, boolean[] directions){
        boolean[] notMove = new boolean[nums.length];
        boolean[] changeDirection = new boolean[nums.length];
        // 判断所有机器人的位置是否需要改变方向
        for(int i = 1; i < nums.length; i++){
            if((nums[gIndexes[i]] - nums[gIndexes[i - 1]] == 1)
                    && !directions[gIndexes[i]] && directions[gIndexes[i - 1]]){
                changeDirection[gIndexes[i - 1]] = true;
                changeDirection[gIndexes[i]] = true;
                notMove[gIndexes[i - 1]] = true;
                notMove[gIndexes[i]] = true;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if(changeDirection[gIndexes[i]]){
                directions[gIndexes[i]] = !directions[gIndexes[i]];
            }
            if (notMove[gIndexes[i]]){
                continue;
            }
            nums[gIndexes[i]] += directions[gIndexes[i]] ? 1 : -1;
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[gIndexes[i]] == nums[gIndexes[i + 1]]){
                directions[gIndexes[i + 1]] = !directions[gIndexes[i + 1]];
                directions[gIndexes[i]] = !directions[gIndexes[i]];
                i++;
            }
        }
    }

    private long computeTotalDistance(int[] nums){
        long total = 0L;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                total += (long) nums[gIndexes[j]] - (long) nums[gIndexes[i]];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-39,21,20,31,-8,9,7};
        String s = "LRRLLRL";
        int d = 7;
        System.out.println(solution.sumDistance(nums, s, d));
    }

}