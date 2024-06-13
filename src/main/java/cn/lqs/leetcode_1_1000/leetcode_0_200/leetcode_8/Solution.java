package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_8;

class Solution {
  public int myAtoi(String s) {
    boolean negative = false;
    boolean trimPrev = true;
    int n = s.length();
    int idx = 0;
    for(;idx < n; idx++){
      if(s.charAt(idx) != ' ') break;
    }
    if(idx == n) return 0;
    if(s.charAt(idx) == '-'){
      negative = true;
      idx += 1;
    }else if(s.charAt(idx) == '+'){
      idx += 1;
    }
    StringBuilder sb = new StringBuilder();
    for(;idx < n; idx++){
      char ch = s.charAt(idx);
      if('0' <= ch && ch <= '9'){
        sb.append(ch);
      }else{
        break;
      }
    }
    while(sb.length() > 0 && sb.charAt(0) == '0'){
      sb.deleteCharAt(0);
    }
    if(sb.length() == 0) return 0;
    long num = 0L;
    n = sb.length();
    long times = 1;
    for(int i = n - 1; i > -1; i--){
      num += ((long)(sb.charAt(i) - '0') * times);
      times *= 10;
    }
    if(negative){
      num = -num;
      return num < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) num;
    }
    return num > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) num;
  }
}