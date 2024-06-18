package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_135;

class Solution {
    public int candy(int[] ratings) {
      int level = 0;
      int[] candies = new int[ratings.length];
      int min = 1;
      for(int i = 0; i < ratings.length; i++){
        if(i == 0){
          candies[i] = 1;
        }else{
          if(ratings[i] < ratings[i - 1]){
            candies[i] = candies[i - 1] - 1;
          }else if(ratings[i] == ratings[i - 1]){
            candies[i] = min;
            for(int j = i + 1; j < ratings.length && ratings[j] < ratings[j - 1]; j++){
              candies[i] += 1;
            }
          }else{
            candies[i] = candies[i - 1] + 1;
          }
        }
        min = Math.min(min, candies[i]);
      }
      int padding = min <= 0 ? 1 - min : 0;
      return totalCandies(candies, padding);
    }

    private int totalCandies(int[] candies, int padding){
      int total = 0;
      for(int candy : candies){
        total += (candy + padding);
      }
      return total;
    }

  public static void main(String[] args) {
      int[] ratings = {1,3,2,2,1};
      System.out.println(new Solution().candy(ratings));
  }
}