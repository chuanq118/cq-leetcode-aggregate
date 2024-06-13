package cn.lqs.leetcode_2520;

class Solution {
    public int countDigits(int num) {
      int k = 10;
      int counter = 0;
      while(true){
        int left = num % k;
        int tar = left / (k / 10);
        if(num % tar == 0){
          counter++;
        }
        if(num < k){
          break;
        }
        k *= 10;
      }
      return counter;
    }

  public static void main(String[] args) {
    System.out.println(new Solution().countDigits(1248));
  }
}