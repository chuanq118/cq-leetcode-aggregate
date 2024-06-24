package cn.lqs.demo;

import java.util.Stack;

public class Demo03 {

    public static void main(String[] args) throws Exception{
//        toString("aaa12312");
//        StringBuilder
        Stack<Integer> stack = new Stack<>();
//        stack.peek()
    }


    public static int toString(String str) throws NotNumberException {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                throw new NotNumberException();
            }
        }
        return 0;
    }

    static class NotNumberException extends Exception {

    }
}
