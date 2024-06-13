package cn.lqs.leetcode_1_1000.leetcode_0_200.leetcode_67;

class Solution {
    public String addBinary(String a, String b) {
      int ai = a.length() - 1;
      int bi = b.length() - 1;
      StringBuilder sb = new StringBuilder();
      boolean overflow = false;
      while(ai >= 0 && bi >= 0){
        if(a.charAt(ai) == '1' && b.charAt(bi) == '1'){
          sb.append(overflow ? '1' : '0');
          overflow = true;
        }else if((a.charAt(ai) == '1' && b.charAt(bi) == '0') ||(a.charAt(ai) == '0' && b.charAt(bi) == '1')){
          sb.append(overflow ? '0' : '1');
        }else{
          sb.append(overflow ? '1' : '0');
          overflow = false;
        }
        ai--;
        bi--;
      }
      if(ai < 0){
        while(bi >= 0){
          if(b.charAt(bi) == '1'){
            sb.append(overflow ? '0' : '1');
          }else{
            sb.append(overflow ? '1' : '0');
            overflow = false;
          }
          bi--;
        }
      }
      if(bi < 0){
        while(ai >= 0){
          if(a.charAt(ai) == '1'){
            sb.append(overflow ? '0' : '1');
          }else{
            sb.append(overflow ? '1' : '0');
            overflow = false;
          }
          ai--;
        }
      }
      if (overflow) {
        sb.append('1');
      }
      return sb.reverse().toString();
    }

  public static void main(String[] args) {
    System.out.println(new Solution().addBinary("11", "1"));
  }
}