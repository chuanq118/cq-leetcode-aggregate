package cn.lqs.leetcode_1_1000.leetcode_201_500.leetcode_224;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
  public int calculate(String s) {
    Deque<Character> opStk = new LinkedList<>();
    Deque<Integer> numStk = new LinkedList<>();
    StringBuilder nsb = new StringBuilder();
    for(int i = 0; i < s.length(); i++){
      char ch = s.charAt(i);
      if(ch == ' ') continue;
      if('0' <= ch && ch <= '9'){
        nsb.append(ch);
      }else{
        if(nsb.length() > 0){
          numStk.push(Integer.parseInt(nsb.toString()));
          nsb.setLength(0);
        }
        if(ch == '+' || ch == '-'){
          if(numStk.isEmpty()){
            numStk.push(0);
          }else{
            int j = i - 1;
            while(j >= 0 && s.charAt(j) == ' '){
              j -= 1;
            }
            if(s.charAt(j) == '('){
              numStk.push(0);
            }
          }
          if(opStk.isEmpty() || opStk.peek() == '('){
            opStk.push(ch);
            continue;
          }
          Integer num2 = numStk.pop();
          Integer num1 = numStk.pop();
          numStk.push(opStk.pop() == '+' ? num1 + num2 : num1 - num2);
          opStk.push(ch);
        }else if(ch == '('){
          opStk.push(ch);
        }else if(ch == ')'){
          char op = '\0';
          while((op = opStk.pop()) != '('){
            Integer num2 = numStk.pop();
            Integer num1 = numStk.pop();
            numStk.push(op == '+' ? num1 + num2 : num1 - num2);
          }
        }
      }
    }
    if(nsb.length() > 0){
      numStk.push(Integer.parseInt(nsb.toString()));
      nsb.setLength(0);
    }
    while(!opStk.isEmpty()){
      Integer num2 = numStk.pop();
      Integer num1 = numStk.pop();
      numStk.push(opStk.pop() == '+' ? num1 + num2 : num1 - num2);
    }
    return numStk.pop();
  }

  public static void main(String[] args) {
    new Solution().calculate(" 2-1 + 2 ");
  }
}